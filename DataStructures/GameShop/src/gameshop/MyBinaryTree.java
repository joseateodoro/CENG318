public class MyBinaryTree {
    private BNode root;
    
    public MyBinaryTree(){
        root=null;
    }
    
    public void insert (int data){
        BNode newNode = new BNode(data);
        if (root == null){
            root=newNode;
            return;
        }
        BNode par,curr;
        par=curr=root;
        while (curr!=null){
            par=curr;
            if (curr.data>data)
                curr=curr.left;
            else
                curr=curr.right;
        }
        if (data<par.data)
            par.left=newNode;
        else
            par.right=newNode;
        
    }
    
    public void inOrder(){
        inOrderWorker(root);
        System.out.println("");
    }
    
    private void inOrderWorker(BNode curr){
        if (curr!=null){
            inOrderWorker(curr.left);
            System.out.println(curr.data);
            inOrderWorker(curr.right);
        }
    }
    
    public void preOrder(){
        preOrderWorker(root);
        System.out.println("");
    }
    
    private void preOrderWorker(BNode curr){
        if (curr!=null){
            System.out.println(curr.data);
            preOrderWorker(curr.left);
            preOrderWorker(curr.right);
        }
    }
    
     public void postOrder(){
        preOrderWorker(root);
        System.out.println("");
    }
    
    private void postOrderWorker(BNode curr){
        if (curr!=null){
            postOrderWorker(curr.left);
            postOrderWorker(curr.right);
            System.out.println(curr.data);
        }
    }
    
    public void levelOrder(){
        MyQueue Q = new MyQueue();
        BNode temp;
        Q.enqueue(root);
        while (!Q.isEmpty()){
            temp = Q.deQueue();
            System.out.print(temp.data+" ");
            if (temp.left!=null){
                Q.enqueue(temp.left);
            }
            if (temp.right!=null){
                Q.enqueue(temp.right);
            }
        }  
    }
    
    public void deleteItem(int key){
        root = deleteRecursive(root,key);       
    }
    
    BNode deleteRecursive (BNode root, int key){
        if (root==null) return root;// case 1
        if (key<root.data)
            root.left=deleteRecursive(root.left,key);
        else
            if (key>root.data)
                root.right=deleteRecursive(root.right,key);
            else{
                // found it
                if (root.left==null) return root.right;
                if (root.right==null) return root.left;
                BNode succ = root.right;
                while (succ.left!=null){
                    succ=succ.left;
                }
                root.data=succ.data;
                root.right=deleteRecursive(root.right,succ.data);              
            }
        return root;       
    }       
}


public class MyQueue {
     private LNode head,tail;
     
     public MyQueue(){
         head=tail=null;
     }
     
     void enqueue(BNode d){
         LNode n= new LNode(d);
         if (head==null){
             head=tail=n;
             return;
         }
         tail.next=n;
         tail=n;
     }
     
     BNode deQueue(){
         if (head==null){
             return null;
         }
         LNode temp = head;
         head=head.next;
         return temp.data;
     }
     
     boolean isEmpty(){
         return head==null;
     }  
}

public class LNode {
     public BNode data;
     public LNode next;
     
     public LNode(BNode d){
         data = d;
         next=null;
     }
}

public class BNode {
    public int data;
    public BNode left,right;
    
    public BNode (int data){
        this.data=data;
        this.left=this.right=null;
    }
}