public enum Constants {
    STUDENT,
    EMPLOYEE,
    LIBRARIAN;

    public static linkedList<Book> books;
    public static UsersArrayList<User> users;
    public static BorrowingQueu borrowingQueu;
    static{
        books = new linkedList<Book>();
        users = new UsersArrayList <>();

        Book bookCalculus = new Book(1,"Calculus",new MyStack<User>(),true);
        bookCalculus.registered = true;
        books.add(bookCalculus);

        Book bookc = new Book(2,"c++",new MyStack<User>(),false);
        books.add(bookc);

        Student newStudentHass = new Student(1,"Hasan","123",Constants.STUDENT,true,new MyStack<Book>(),80);


        newStudentHass.borrowingHistory.add(bookc);
        bookc.borrowingHistory.add(newStudentHass);
        users.add(newStudentHass);

        User newEmpEias = new Employee(2,"Eias","123",Constants.EMPLOYEE,true,new MyStack<Book>());
        users.add(newEmpEias);

        User newLibKamal = new Librarian(3,"Kamal","123",Constants.LIBRARIAN,true);
        users.add(newLibKamal);

        borrowingQueu = new BorrowingQueu();
        borrowingQueu.addnewBorrow(new BorrowingNode(newStudentHass,bookCalculus));
        borrowingQueu.addnewBorrow(new BorrowingNode(newStudentHass,bookc));


    }
}
