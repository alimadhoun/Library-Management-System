import java.util.Arrays;

 class UsersArrayList<T> {
     int size = 0;
     static final int DEFAULT_CAPACITY = 10;
     User elements[];

    public UsersArrayList() {
        elements = new User[DEFAULT_CAPACITY];
    }

     void add(User user) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = user;

    }


     void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    int contains(String name){
        for (int x=0;x<=elements.length;x++){
            try {
                if (elements[x].name.equals(name)){
                    return x;
                }
            }catch (NullPointerException e){
                return -1;
            }
        }
        return -1;
    }
    void printall(){
        for (int i = 0;i<DEFAULT_CAPACITY;i++){
            if (elements[i]!=null){
                if (elements[i].isActive && elements[i].type != Constants.LIBRARIAN){
                    System.out.print(elements[i].id+", "+elements[i].name+", "+elements[i].type+", active\n");

                }else if (elements[i].isActive != true && elements[i].type != Constants.LIBRARIAN){
                    System.out.print(elements[i].id+", "+elements[i].name+", "+elements[i].type+", not active\n");
                }
            }else {
                break;
            }
        }
    }

    void printBorrowingForUserID(int id){
        for (int x= 0;x<size;x++){
            if (elements[x]!=null){
                if (elements[x].id == id){
                    if (elements[x].type == Constants.EMPLOYEE){
                        Employee emp = (Employee) elements[x];
                        Book book = (Book)  emp.borrowingHistory.head;
                        while (book!=null){
                            Book book2 = (Book) book.next;
                            System.out.println("- "+ book.ISBN+", "+book.name);
                            book = book2;
                        }
                    }else if(elements[x].type == Constants.STUDENT){
                        Student student = (Student) elements[x];
                        Book book = (Book)  student.borrowingHistory.head;
                        while (book!=null){
                            Book book2 = (Book) book.next;
                            System.out.println("- "+ book.ISBN+", "+book.name);
                            book = book2;
                        }

                    }
                }
            }else {
                break;
            }
        }
    }

    void toggleAt(int id){
        for (int x = 0;x<size;x++){
            if (elements[x]!=null){
                if (elements[x].id == id){
                    elements[x].isActive = !elements[x].isActive;
                    if (elements[x].isActive){
                        System.out.println(elements[x].name+" is active now");
                    }else {
                        System.out.println(elements[x].name+" is inactive now");
                    }
                }
            }else {
                break;
            }
        }
    }
}