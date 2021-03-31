import java.util.Scanner;

class BorrowingQueu {
    BorrowingNode head;
    int size = 0;

    public BorrowingQueu(BorrowingNode node){
        this.head = head;
    }
    public BorrowingQueu(){
        this.head = null;
    }

    void addnewBorrow(BorrowingNode node){
        if (head == null){
            head = node;
            size++;
            return;
        }
        BorrowingNode newNode = head;
        while (newNode.next !=null){
            newNode = newNode.next;
        }
        newNode.next = node;
        size+=1;
    }


    void ShowBorrowingRequests(){
        Scanner in = new Scanner(System.in);
        if (head == null){
            System.out.println("There is no more borrowing requests.");
            return;
        }

        BorrowingNode node = head;
        while (head != null){
            System.out.println("\t-"+head.user.name+" wants to borrow ("+head.book.ISBN+", "+head.book.name+")");
            System.out.println("Approve it? (1:yes, 0:no)");
            int choice = in.nextInt();
            if (choice == 1){
                head = head.next;
                size--;
            System.out.println("The book has been registered as borrowed.");
            }
        }


    }


}
