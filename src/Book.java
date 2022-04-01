public class Book extends Node implements Informer {
    int ISBN;
    String name;
    MyStack<User> borrowingHistory;
    boolean isAvailable;
    boolean registered = false;
    public Book(int ISBN,String name,MyStack<User> borrowingHistory,boolean isAvailable){
        super();
        this.ISBN = ISBN;
        this.name = name;
        this.borrowingHistory = borrowingHistory;
        this.isAvailable = isAvailable;
    }

    @Override
    public String returnInfo() {
        return name + " " + ISBN + " "+ isAvailable + " " + registered;
    }

    @Override
    public String toString() {
       if (this.isAvailable){
           System.out.println(this.ISBN+","+this.name+","+"Available");
       }else {
           System.out.println(this.ISBN+","+this.name+","+"Not Available");
       }
        System.out.println("Borrowed by:");
        if (this.borrowingHistory.head == null){
            System.out.println("\t -");
        }else {
            borrowingHistory.toString();
        }
       return this.name+" "+ this.ISBN+ " " + isAvailable + " "+registered;
    }


//    @Override
//    public String toString() {
//
//        return name + " " + ISBN + " "+ isAvailable + " " + registered;
//    }

    void showBorrowedBy(){
        System.out.println("Borrowed by:");
        if (this.borrowingHistory.head == null){
            System.out.println("\t -");
        }else {
            borrowingHistory.toString();
        }
    }
}

