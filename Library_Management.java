package practice.library_management;

import java.lang.*;
import java.util.*;
class Book_detail{
    public int quantity;
    public String name;
    Book_detail(int quantity, String name)
    {
       this.quantity = quantity;
       this.name = name;}
}

class Student{ // parent class
    private String name1;
    private int ID;
    public void setID(int ID){
        this.ID=ID;
    }
    public int getID(){
        return ID;
    }
    public void setname1(String name1){
        this.name1=name1;
    }
     public String getname1(){
       return name1;
    } 
}

public class Library_Management extends Student{// child class
    Scanner obj=new Scanner(System.in);
    int i;
    void design(){             
         System.out.println("\n==================================================");
         System.out.println("----Welcome to the Library management software---- ");
         System.out.println("==================================================\n");
    }
    
    void choise(Book_detail arr[],Library_Management a){
        System.out.println("--------------------------------------------------\n");
        System.out.println("Proceed with\n1. Add Book\n2. Borrow Book\n3. Display Book");
        int chs=obj.nextInt();//add or borrow
        if(chs==1){
            System.out.println("Choose Serial from book list you want to return");
        int ok=obj.nextInt();//for which index
            a.add_book(arr,ok);
            a.main_exit(arr,a);
        }
        else if(chs==2){
            System.out.println("Choose Serial from book list you want to borrow");
        int ok=obj.nextInt();//for which index
            a.borrow_book(arr, ok);
            a.main_exit(arr,a);
        }
        else{
            a.display_book(arr,a);
            a.main_exit(arr,a);
        }
    }
    void add_book(Book_detail arr[],int ok){
        for ( i = 0; i < arr.length; i++){
            if(i==ok){
                arr[i].quantity+=1;}
         }
       System.out.println("Successfully added in the book list");
    }
    void borrow_book(Book_detail arr[],int ok){
        for ( i = 0; i < arr.length; i++){
            if(i==ok){
                if(0<arr[i].quantity){
                arr[i].quantity-=1;
                System.out.println("Book Borrowed Successfully");
                }
                else{
                System.out.println("The book "+arr[i].name+" do not have any available copies now");
                arr[i].quantity=0;}
                }
            }
    }  
    void display_book(Book_detail arr[],Library_Management a){
        System.out.println("\n------------------------------------------------------------");
        System.out.println("   Serial         Quantity           Book Title");
        System.out.println("------------------------------------------------------------");
        for (i = 0; i < arr.length; i++){
           System.out.println("    "+ i + "  :            " + arr[i].quantity+ "              "+ arr[i].name);
        }
        System.out.println("------------------------------------------------------------\n");
       
    }
    void main_exit(Book_detail arr[],Library_Management a){
         System.out.println("Press 1 or 2 for following process\n1. Main Menu\n2. Exit");
            int lop=obj.nextInt();
            if(lop==2){
                System.out.println("\n**Thanks "+a.getname1()+" for being with us\n\n");
                System.exit(0);
            }
            else{
                a.choise(arr,a);
            }
    }

    public static void main(String[] args)
    {
        Library_Management a=new Library_Management();
      
        int i;
        Scanner obj=new Scanner(System.in);
        Book_detail[] arr;
        arr = new Book_detail[5];
        arr[0] = new Book_detail(1, "Harry Potter");
        arr[1] = new Book_detail(2, "It Ends With Us");
        arr[2] = new Book_detail(0, "Dopamin Detox");
        arr[3] = new Book_detail(4, "Steal Like an Artist");
        arr[4] = new Book_detail(5, "Love for imperfect Things");
        System.out.println("Enter Your Name:");
        String nam=obj.nextLine();
        System.out.println("Enter Your ID:");
        int id=obj.nextInt();
        a.setID(id);
        a.setname1(nam);
        a.design();
        System.out.println("Your Name is: "+a.getname1()+"\nYour ID is: "+a.getID());
        a.choise(arr,a);
        }
}
 // encapsulation, Inheritance, this, array as object, 