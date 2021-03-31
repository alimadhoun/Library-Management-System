public class Student extends User {

    MyStack<Book> borrowingHistory;
    int grade;
    public Student(int ID, String name, String password, Constants type,boolean isActive,MyStack<Book> borrowingHistory,int grade) {
        super(ID, name, password, type,isActive);
        this.borrowingHistory = borrowingHistory;
        this.grade = grade;
    }




}
