
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static User user = null;

    public static void main(String[] args){

        if (user == null){
            System.out.println("Welcome to Library System,");
            System.out.println("Enter your ID name.");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            if (Constants.users.contains(name) != -1){
                user = Constants.users.elements[Constants.users.contains(name)];
                System.out.println("hello " +user.type + " "+user.name+" now enter your password:");
                String pass = input.nextLine();
                if (pass.equals(user.password)){
                    System.out.println("welcome "+user.name);
                    switch (user.type){
                        case STUDENT:
                            checkforStudent((Student) user);
                            break;
                        case EMPLOYEE:
                            checkforemployee((Employee) user);
                            break;
                        case LIBRARIAN:
                            checkforLibarian((Librarian) user);
                            break;
                    }

                }
            }else {
                System.out.println("Sorry, this user is not found, press enter key to retry.");
                input.next();
                main.main(null);
            }
        }else {
            switch (user.type){
                case STUDENT:
                    checkforStudent((Student) user);
                    break;
                case EMPLOYEE:
                    checkforemployee((Employee) user);

                    break;
                case LIBRARIAN:
                    checkforLibarian((Librarian) user);
                    break;
            }
        }


    }
    static void checkforStudent(Student student){
        System.out.println("1- Show available books");
        System.out.println("2- Borrow a book (by ISBN)");
        System.out.println("3- Search for books by name");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        switch (choice){
            case "1":
                Constants.books.printAlldata();
                break;
            case "3":
                System.out.println("Enter the name you want to look for, or the ISBN number:");
                String bookname = in.next();
                Constants.books.dataAt(bookname);
                System.out.println("Want to borrow a book?");


            case "2":
                System.out.println("Enter the books’ ISBN:");
                int bookIsbn = in.nextInt();
                Node<Book> book = Constants.books.head;
                while (true){
                    if (book.data.ISBN == bookIsbn){
                        if (book.data.isAvailable){
                            if (student.grade < 85){
                                book.data.registered = true;
                                System.out.println("Your request has been submitted to librarian, check with him.");
                            }else {
                                book.data.isAvailable = false;
                                book.data.borrowingHistory.add(student);
                                student.borrowingHistory.add(book);
                            }
                        }else {
                            System.out.println(book.data.name +" book is not available");
                            break;
                        }
                        break;
                    }else {
                        if (book.next !=null){
                            book = book.next;
                        }else {
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("in valid input");
                checkforStudent(student);
                break;

        }
        System.out.println("Enter any Key to back to main menu");
        in.next();
        main(null);
    }
    static void checkforemployee(Employee employee){
        System.out.println("1- Show available books");
        System.out.println("2- Borrow a book (by ISBN)");
        System.out.println("3- Search for books by name");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        switch (choice){
            case "1":
                Constants.books.printAlldata();
                break;
            case "3":
                Node<Book> bookToborrow = Constants.books.head;
                System.out.println("Enter the name you want to look for:");
                String bookname = in.next();
                Constants.books.dataAt(bookname);
                System.out.println("Want to borrow a book? ");
            case "2":
                System.out.println("Enter the books’ ISBN:");
                int bookIsbn = in.nextInt();
                Node<Book> book = Constants.books.head;
                while (true){
                    if (book.data.ISBN == bookIsbn){
                        if (book.data.isAvailable && book.data.registered !=true) {
                            System.out.println("Done");
                            book.data.isAvailable = true;
                            employee.borrowingHistory.add(book);
                        }else if (book.data.registered){
                            System.out.println("The book has been registered as borrowed, go and take it.");
                        }else {
                            System.out.println(book.data.name +" book is not available");
                            break;
                        }
                        break;
                    }else {
                        if (book.next !=null){
                            book = book.next;
                        }else {
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("in valid input");
                checkforemployee(employee);
                break;

        }
        System.out.println("Enter any Key to back to main menu");
        in.next();
        main(null);
    }
    static void checkforLibarian(Librarian librarian){
        System.out.println("1- Approve Borrowing Request Queue");
        System.out.println("2- View All Books");
        System.out.println("3- Check the borrowing history for a book");
        System.out.println("4- Check the borrowing history for a user");
        System.out.println("5- Manage Library users");
        System.out.println("6- Explore books");
        System.out.println("7- Add Book");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        switch (choice){
            case "1":
                Constants.borrowingQueu.ShowBorrowingRequests();
                break;
            case "2":
                Constants.books.printAlldata();
                break;
            case "3":
                Constants.books.printData();
                System.out.println("Enter book ISBN");
                int isbn = in.nextInt();
                System.out.println("This book has been borrowed by:");
                Node<Book> book = Constants.books.head;
                while (book!=null){
                    if (book.data.ISBN == isbn){
                        book.data.borrowingHistory.toString();
                        break;
                    }else {
                        book = book.next;
                    }
                }
                break;
            case "4":
                Constants.users.printall();
                System.out.println("Which users’ history you want to check?");
                int id = in.nextInt();
                Constants.users.printBorrowingForUserID(id);
                break;
            case "5":
                Constants.users.printall();
                System.out.println("Which users’ status you want to toggle?");
                int userid = in.nextInt();
                Constants.users.toggleAt(userid);
                break;
            case "6":
                System.out.println("First book is:");
                ArrayList<String> arr = Constants.books.datainArr();
                int counter = 0;
//
                while (true){
                    if (counter<arr.size() && counter<arr.size()+1){
                        System.out.println(arr.get(counter+1)+", "+arr.get(counter));
                        System.out.println("Press n for next, p for previous, f for first, l for last.");
                        String choice1 = in.nextLine();
                        switch (choice1){
                            case "n":
                                counter+=2;
                                break;
                            case "p":
                                if (counter!= 0){
                                    counter = counter - 2;
                                }
                                break;
                            case "l":

                                counter = arr.size() - 2;

                                break;
                        }
                    }else {
                        break;
                    }
                }
                break;
            case "7":
                int newIsbn = Constants.books.size+1;
                System.out.println("Book ISBN is "+ newIsbn);
                System.out.println("Book name:");
                String bookname = in.next();
                Constants.books.add(new Book(Constants.books.size+1,bookname,new MyStack<>(),true));
                System.out.println(bookname+" book is added now.");
                break;
            default:
                System.out.println("in valid input");
                checkforLibarian(librarian);
                break;
        }
        System.out.println("Enter any Key to back to the main menu");
        in.next();
        main(null);


    }

}
