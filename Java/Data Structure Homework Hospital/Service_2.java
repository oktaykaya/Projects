
//Stack with Linked List
public class Service_2 {
    Service_1 stack;

    // Constructor to initialize the stack
    Service_2(){
        this.stack = new Service_1();
    }

    // Utility function to add an element `x` to the stack
    public void push(Patient x){
        if(stack.tail == null)
        {
            stack.tail=stack.head=x;
            stack.tail.next=null;
            stack.tail.previous=null;

        }
        else{
            stack.head.previous=x;
            x.next = stack.head;
            stack.head = x;
            x.previous = null;}
    }

    // Utility function to pop a top element from the stack
    public Patient pop(){
        Patient pat = this.stack.head;
        stack.head = pat.next;
        stack.head.previous = null;
        return pat;
    }

    // Utility function to check if the stack is empty or not
    public Boolean isEmpty(){
        if(stack.tail == null)
        {
            return true;
        }
        else
            return false;
    }

    // Utility function to return the size of the stack
    public int size() {
        int size = 0;
        Patient pat = this.stack.tail;
        while (pat!=null)
        {
            pat = pat.previous;
            size++;
        }
        return size;
    }

}
