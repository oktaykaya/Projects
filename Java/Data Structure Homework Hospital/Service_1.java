
//**************Double Linked List************************//
public class Service_1 {
    Patient head; //head of list
    Patient tail; //tail of list

    //Constructor
    public Service_1() {
        head = null ;
        tail = null ;
    }

    //Check list is empty or not
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    //This function first builds new patient with the given data
    //than adds it to the LinkedList
    //new nodes are added to the tail of LinkedList
    public void insert(String name) {
        Patient pat = new Patient(name);
        if(head == null) {
            head = tail = pat;
            head.previous = null;
            tail.next = null;
        }
        else {
            tail.next = pat;
            pat.previous = tail;
            tail = pat;
            tail.next = null;
        }

    }

    // overload this method as new nodes are added to given position (int pos)
    // fill the rest
    public void insert(String name, int pos) {
        Patient pat = new Patient(name);
        Patient pat1 = getByPosition(pos);
        Patient pat2 = getByPosition(pos-1);

        if(pos == 0){
            head.previous = pat;
            pat.previous = null;
            pat.next = head;
            head = pat;
        }
        else if (pat1.next == null)
        {
            Patient pat3 = this.tail;
            pat.next = pat3;
            pat.previous = pat3.previous;
            tail.previous = pat;
            head.next = pat;

        }
        else

            pat.previous = pat1.previous;
        pat.next = pat1;
        pat1.previous = pat;
        pat2.next = pat;
    }

    //This method finds how many patients are exist in LinkedList
    public int size() {
        Patient pat = this.head;
        int size = 0;
        while(pat!=null) {
            pat = pat.next;
            size++;
        }
        return size;
    }

    // This functions delete a node in the LinkedList by a given "data"
    // parameter name changed as key in order to prevent confusion
    public Patient deleteByName(String name) {
        Patient pat = new Patient(name);

        int i = 0;
        while (i<size()){

            if(getByPosition(i).getName().equals(name)){
                getByPosition(i-1).next = pat.next;
                getByPosition(i+1).previous = pat.previous;
            }
            i++;
        }
        return pat;
    }

    // This functions delete a node in the LinkedList by a given position
    public Patient deleteByPosition(int pos) {
        if(pos == 0 ){
            Patient pat3 = this.head;
            head = pat3.next;
            return pat3;
        }
        else{
            Patient pat = getByPosition(pos);
            Patient pat1 = getByPosition(pos-1);
            Patient patient2 = getByPosition(pos+1);
            pat1.next = pat.next;
            patient2.previous = pat.previous;
            return pat;
        }
    }

    //This function get the node in the given index
	//*********************DO NOTHING*********************
    public Patient getByPosition(int pos){
        if(this.isEmpty())
            return new Patient("empty");
        Patient current = this.head;
        int index = 0;

        while (current != null){
            if(index++ == pos)
                break;
            current = current.next;
        }

        if(current == null)
            return new Patient("empty");

        return current;
    }

    // This function prints  the LinkenList
	//*********************DO NOTHING*********************
    public void print() {

        if(this.isEmpty())
            return;
        Patient patient = this.head;  // make a copy of head
        int index = 1;

        // never operate on "head", otherwise you will lost the linkedlist
        //unless you want to change "head"
        while (patient != null) {
            System.out.println(index++ + ". " + patient.getName());

            patient = patient.next;  // iterate to next node
        }

    }

}
