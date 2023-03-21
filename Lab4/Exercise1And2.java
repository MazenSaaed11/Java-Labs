package Lab4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Exercise1And2 {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("                                                                 Hello to my Bookstore");
        System.out.println("                                                                 _____________________");
        System.out.print("Enter number of books please : ");
        int num;
        num = s.nextInt();
        ArrayList<Book> Books = readBooks(num);

        for (int i = 0; i < num; i++) {
            System.out.println("___________________________________________________________________");
            Books.get(i).print();
            System.out.println("___________________________________________________________________");
        }
    }


    public static ArrayList<Book> readBooks(int num) {
        ArrayList<Book> Books = new ArrayList<Book>();
        while (num > 0) {
            System.out.print("Enter Book Type please ( 1 for text / 2 for audio) : ");
            int type = s.nextInt();
            s.nextLine();
            Book b1 = readBook(type);
            Books.add(b1);
            num--;
        }
        return Books;
    }
    static Book readBook(int type) {

        System.out.println("____________________________________________________");
        System.out.print("Enter Book name : ");
        String title = s.nextLine();
        System.out.println("Enter release date : ");
        System.out.print("Day : ");
        int day = s.nextInt();
        System.out.print("Month : ");
        int month = s.nextInt();
        System.out.print("Year : ");
        int year = s.nextInt();
        System.out.print("Enter Book price : ");
        double price = s.nextDouble();
        Book b;
        if (type == 1) {
            System.out.print("Enter Book's number of pages : ");
            int numOfPages = s.nextInt();
            b = new TextBook(title, day, month, year, price, numOfPages);
        } else {
            System.out.print("Enter Book's Length in minutes : ");
            double LengthOfMinutes = s.nextDouble();
            b = new AudioBook(title, day, month, year, price, LengthOfMinutes);
        }
        System.out.println("Book " + b.getId() + " Added successfully");
        System.out.println("____________________________________________________");
        return b;
    }
}

class Book {
    private int id;
    static int num = 1;
    private String title;
    private LocalDate releaseDate;
    private double price;

    public Book(String title, int day, int month, int year, double price) {
        this.id = num;
        this.title = title;
        this.releaseDate = LocalDate.of(year, month, day);
        this.price = price;
        num++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int day, int month, int year) {
        this.releaseDate = LocalDate.of(year, month, day);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void print() {
        System.out.println("Book id : " + id);
        System.out.println("Book title : " + title);
        System.out.println("Book release date : " + releaseDate);
        System.out.println("Book price is $" + price);
    }

    @Override
    public String toString() {
        return (
                "\nBook id : " + id + "\nBook title : " + title + "\nBook release date : " + releaseDate +
                        "\nBook price is $" + price
        );
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = true;
        equal = equal && (id == ((Book) obj).id);
        equal = equal && (releaseDate == ((Book) obj).releaseDate);
        equal = equal && (title.equals(((Book) obj).title));
        return equal;
    }
}
class TextBook extends Book {
    private int numOfPages;

    public TextBook(String title, int day, int month, int year, double price, int numOfPages) {
        super(title, day, month, year, price);
        this.numOfPages = numOfPages;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public void print() {
        System.out.println("Type : Text Book");
        super.print();
        System.out.println("Book size is : " + numOfPages + " pages");
    }

    @Override
    public String toString() {
        return (
                super.toString() + "\nBook size is : " + numOfPages + " pages\n"
        );
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = super.equals(obj);
        equal = equal && (this.numOfPages == ((TextBook) obj).numOfPages);
        return equal;
    }
}
class AudioBook extends Book {

    private double LengthInMinutes;

    public AudioBook(String title, int day, int month, int year, double price, double lengthInMinutes) {
        super(title, day, month, year, price);
        LengthInMinutes = lengthInMinutes;
    }

    public double getLengthInMinutes() {
        return LengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        LengthInMinutes = lengthInMinutes;
    }

    @Override
    public void print() {
        System.out.println("Type : Audio Book");
        super.print();
        System.out.println("Book Length is : " + LengthInMinutes + " minutes");
    }
    @Override
    public String toString() {
        return (
                super.toString() + "\nBook Length in minutes is : " + LengthInMinutes + " minutes\n"
        );
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal = super.equals(obj);
        equal = equal && (this.LengthInMinutes == ((AudioBook) obj).LengthInMinutes);
        return equal;
    }
}


