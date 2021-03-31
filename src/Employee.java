public class Employee extends User {
    MyStack<Book> borrowingHistory;
    public Employee(int ID, String name, String password, Constants type,boolean isActive,MyStack<Book> borrowingHistory) {
        super(ID, name, password, type,isActive);
        this.borrowingHistory = borrowingHistory;
    }
}
