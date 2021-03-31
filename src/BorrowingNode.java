public class BorrowingNode {
    User user;
    Book book;
    BorrowingNode next;
    public BorrowingNode(User user,Book book){
        this.book = book;
        this.user = user;

    }
    public BorrowingNode(){
        this.user = null;
        this.book = null;
    }
}
