public class Node<T extends returner> {

     T data ;

     Node<T> next;

    public Node(T data) {
        this.data = data;
    }
    public Node(){

    }

    String printFulldata(){
        return data.toString();

    }
    String[] printNames(){
        String fulldata = data.returnInfo();
         String [] info = fulldata.split(" ");
         return info;
    }





}
