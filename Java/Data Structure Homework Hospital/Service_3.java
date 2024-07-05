
//Queue with Linked List
public class Service_3 {
    Service_1 queue; // Your queue. Use this

    // Constructor to initialize a queue
    Service_3() {
        this.queue = new Service_1();
    }

    // Utility function to dequeue the front element
    public Patient dequeue() {
        Patient pat = queue.head;
        queue.head = pat.next;
        return pat;
    }

    // Utility function to add an item to the queue
    public void enqueue(Patient x) {
        if(queue.head == null){
            queue.head = queue.tail = x;
            x.next = null;
            x.previous = null;}

        x.previous = queue.tail;
        queue.tail.next = x;
        queue.tail = x;
        x.next = null;
    }

    // Utility function to check if the queue is empty or not
    public Boolean isEmpty() {
        if(queue.head == null){

            return true;
        }
        else
            return false;
    }

    // Utility function to return the size of the queue
    public int size() {
        Patient pat = this.queue.head;
        int size = 0;
        while (pat!=null){
            pat = pat.next;
            size++;
        }
        return size;
    }

}
