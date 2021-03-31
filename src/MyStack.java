public class MyStack<T extends returner> {
    Node<T> head;
    int size =0;

    public MyStack(){
        head = null;
    }
    public MyStack(T head){
        this.head = new Node<T>(head);
        size++;
    }
    void add(Node<T> node){
        if (head == null){
            head = node;
            size++;
            return;
        }
        Node<T> newNode = head;
        while (newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next = node;
        size++;

    }

    @Override
    public String toString() {
        Node<T> newNode = head;
        while (newNode!=null){
            System.out.println(newNode.toString());
            newNode = newNode.next;
        }
       return null;
    }



void printAlldata(){
    Node<T> newNode = head;
    while (newNode!=null){
       System.out.println(newNode.printFulldata());
        newNode = newNode.next;
    }
}
}
