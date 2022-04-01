import java.util.ArrayList;

class LinkedList<T extends Informer> {
     int size = 0;
     Node<T> head;


    public void add(T data) {
        if (data == null) {
            return;
        }
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> newNode = new Node<T>(data);
            Node<T> n = head;
            while (n.next !=null){
                n = n.next;
            }
            n.next = newNode;
        }
        size++;
    }

   void printAlldata(){
       Node<T> newNode = head;
       while (newNode!=null){
            newNode.printFulldata();
           //System.out.println(newNode.printFulldata());
           newNode = newNode.next;
       }
   }
   void dataAt(String name){
       Node<Book> newNode = (Node<Book>) head;
       while (true){
           if (newNode.data.name.equals(name)){
               newNode.printFulldata();
               break;
           }
           newNode = newNode.next;
       }
   }

   void printData(){
       Node<T> newNode = head;
       while (newNode!=null){
           String name = newNode.printNames()[0];
           String isbn = newNode.printNames()[1];
           System.out.println(isbn+", "+name);
           newNode = newNode.next;
       }
   }
     ArrayList<String> datainArr(){
         Node<T> newNode = head;
         ArrayList<String> listtoreturn = new ArrayList<>();
         while (newNode!=null){
             String name = newNode.printNames()[0];
             String isbn = newNode.printNames()[1];
             listtoreturn.add(name);
             listtoreturn.add(isbn);
             newNode = newNode.next;
         }
         return listtoreturn;
     }

}
