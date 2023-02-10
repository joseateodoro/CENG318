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