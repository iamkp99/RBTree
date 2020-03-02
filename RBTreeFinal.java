import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class Node {

    Node left, right, parent;
    char color;
    int key;
   

    Node() {
        this.color = 'R';
        this.left = null;
        this.right = null;
    }

    Node(int key) {
        this.key = key;
       
        this.left = null;
        this.right = null;
        this.parent=null;
        this.color='R';
    }

   
}


class RBTree {

    Node root;
   
    int count =0;
    Node nil;
   static int lcount=0,rcount=0;
    RBTree() {
        nil = new Node();
        root = nil;
    }
   

    public int insert(Node z,int f) {
        System.out.println("Inserting " + z.key);
       

        Node y = nil;
        Node x = root;
        Node temp=z;

        while (x != nil) {
            y = x;

            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = y;

        if (y == nil) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = nil;
        z.right = nil;
        if(f==1)z.color='B';
        else
        z.color = 'R';
        insertFixUp(z);
        //System.out.println("Root="+root.key);
       return blackht(root);
    }
   

    public void insertFixUp(Node z) {
        Node y;
        if(z!=root)
        {
        while (z.parent.color == 'R'&&z!=root) {
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;
                if(y.key==0){
                y=new Node();        
                y.color='B';
                }  
                if (y.color == 'R') {
                   
                    z.parent.color ='B';
                    y.color = 'B';
                    z.parent.parent.color = 'R';
                    z = z.parent.parent;
                }
                else {
                    if (z == z.parent.right) {
                       
                        z = z.parent;
                        leftRotate(z);
                        lcount++;

                    }
                   
                    z.parent.color = 'B';
                    z.parent.parent.color = 'R';
                    rightRotate(z.parent.parent);
                    rcount++;
                }
            }
            else {
                y = z.parent.parent.left;
                if(y.key==0){
                y=new Node();        
                y.color='B';
                }
                if (y.color == 'R') {
                    z.parent.color = 'B';
                    y.color = 'B';
                    z.parent.parent.color = 'R';
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                        rcount++;
                    }
                    z.parent.color = 'B';
                    z.parent.parent.color = 'R';
                    leftRotate(z.parent.parent);
                    lcount++;
                }
            }
           

        }
        }
        root.color = 'B';
    }
   
    public int blackht(Node z)
    {
        Node x =z,y=z;
        int c=0,d=0;
       
         while (x!= nil) {
             x=x.right;
             if(x.color=='B'&&x.key!=0)
               c++;          
        }
         while (y != nil) {
           y=y.left;        
           if(y.color=='B'&&y.key!=0)
               d++;
        }
         if(c!=d)
         {
             System.out.println("Black Height Not balanced.");
             System.out.println("Values of Black Ht: Left="+d+" Right="+c);
             System.out.println("Terminate Insert Operation.");
               
             return -1;
             
         }
         else
         {
             System.out.println("Property 5 Preserved");
             System.out.println("Values of Black Ht: Left="+d+" Right="+c);
       //  System.out.println("Values of Black Ht: Left="+d+" Right="+c);  
         
         return 0;
         }
    }
   

    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != nil) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
       
    }

    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != nil) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == nil) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
       
    }




   
     void postorder(Node rbtree){
        if(rbtree!=null){    
        postorder(rbtree.left);
        postorder(rbtree.right);
       
        if(rbtree.key>0)
        {
        System.out.println(rbtree.key+" "+rbtree.color);
        blackht(rbtree);
        }
        }
    }
     void postorder1(){
         postorder(root);
    }
     void postordernormal(){
         postorderwithoutht(root);
    }
     
     
     void postorderwithoutht(Node rbtree){
        if(rbtree!=null){    
        postorderwithoutht(rbtree.left);
        postorderwithoutht(rbtree.right);
       
        if(rbtree.key>0)
        {
        System.out.println(rbtree.key+" "+rbtree.color);
       
        }
        }
    }
     
}





public class finalassign {
 
    public static void main(String[] args) {
        RBTree rbTree = new RBTree(),rbTree2,rbTree3 = null;
        Scanner sc = new Scanner(System.in);
        int f=0,dec=0,s=0,ele=0;
        int arr[]={41,38,31,12,19,8};
        int arr1[]={8,18,5,15,17};
        int arr2[]={2,1,4,5,9,3,6};
        int arr3[]={10,5,60,25,23};
       
       
        do
        {
        System.out.println("Enter Task Number");
        System.out.println("1.Insert Black/Red Node\n2.Insert Nodes into RBTree\n3.Check RBTree Black Height\n4.Tree Traversal\n5.Run Test Cases.6.EXIT");    
        s=sc.nextInt();    
        switch(s)
        {
            case 1:  
                  rbTree2=new RBTree();
                 
                  System.out.println("Enter Color of Node to be Inserted 1.Black 2.Red");
                  f=sc.nextInt();
                  System.out.println("Enter Nodes to Insert.-1 to Terminate");
                  ele=1;
                  while(ele!=-1)
                  {
                      ele=sc.nextInt();
                      if(ele==-1)
                      break;
                      dec=rbTree2.insert(new Node(ele), f);
                      if(dec==-1)break;
                  }
                  System.out.println("\n\n");
                  rbTree2.postordernormal();
                  break;
            case 2:              
                 f=0;
                 rbTree = new RBTree();
                 for(int i=0;i<arr.length;i++)
                 {      
                 dec=rbTree.insert(new Node(arr[i]), f);
                 if(dec==-1)
                 break;
                 }
                 rbTree3=rbTree;
               
                 System.out.println("\n\n");
                 break;
            case 5:              
                 f=0;
                 System.out.println("Test Case 1");
                 for(int i=0;i<arr1.length;i++)
                 {      
                 dec=rbTree.insert(new Node(arr1[i]), f);
                 if(dec==-1)
                 break;
                 }
                 System.out.println("POSTORDER");
                 rbTree.postordernormal();
                 System.out.println("\n");
                 
                 System.out.println("Test Case 2");
                 rbTree=new RBTree();
                 for(int i=0;i<arr2.length;i++)
                 {      
                 dec=rbTree.insert(new Node(arr2[i]), f);
                 if(dec==-1)
                 break;
                 }
                 System.out.println("POSTORDER");
                 rbTree.postordernormal();
                 System.out.println("\n\n");
                 
                 System.out.println("Test Case 3");
                 rbTree=new RBTree();
                 for(int i=0;i<arr3.length;i++)
                 {      
                 dec=rbTree.insert(new Node(arr3[i]), f);
                 if(dec==-1)
                 break;
                 }
                 System.out.println("POSTORDER");
                 rbTree.postordernormal();
                 
               
                 System.out.println("\n\n");
                 break;    
            case 3:    

                System.out.println("Insert Node to Verify Black Height");
                int g=sc.nextInt();
                System.out.println("Before Insertion");
                rbTree.blackht(rbTree.root);
                dec=rbTree.insert(new Node(g), f);
                System.out.println("After Insertion");
                rbTree.blackht(rbTree.root);
               
                break;
            case 4:    
                rbTree.postordernormal();
               
               
                break;    
            case 6:
                System.out.println("EXIT");
               
               
                break;

        }
    }while(s!=6);
    }
}
