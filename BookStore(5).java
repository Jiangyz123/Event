package prog2.spring2024.exercise2;

import java.time.LocalDate;

/**
 * Hello world!
 * 
 */
public class BookStore {
    public enum BookDetails {
        BOOK01(
                "001",
                "Carri",
                "Stephen King",
                272,
                "Horror",
                3.98,
                1974,
                "Wings",
                14),
        BOOK02(
                "002",
                "The Firm",
                "Robin Waterfield/John Grisham",
                448,
                "Thriller",
                4.01,
                1991,
                "Addison Wesley",
                25),
        BOOK03(
                "003",
                "Slaughterhouse-Five",
                "Kurt vonnegut Jr",
                275,
                "Sci-Fi",
                4.1,
                1969,
                "Dial Press",
                18),
        BOOK04(
                "004",
                "The Great Gatsby",
                "F.Scott Fitzgerald",
                188,
                "Classic",
                3.91,
                1925,
                "Scribner",
                8),
        BOOK05(
                "005",
                "American Gods",
                "Neil Gaiman",
                635,
                "Fantasy",
                4.11,
                2001,
                "Harper Collins",
                4.11);

        public static final double bookRent = 5.0;
        private final String bookID;
        private final String bookName;
        private final String bookAuthor;
        private final int bookPages;
        private final String bookGenre;
        private final double bookRating;
        private final int bookPublishedYear;
        private final String bookPublisher;
        private final double bookPrice;
        int i;

        BookDetails(
                String bookID,
                String bookName,
                String bookAuthor,
                int bookPages,
                String bookGenre,
                double bookRating,
                int bookPublishedYear,
                String bookPublisher,
                double bookPrice) {
            this.bookID = bookID;
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.bookPages = bookPages;
            this.bookGenre = bookGenre;
            this.bookRating = bookRating;
            this.bookPublishedYear = bookPublishedYear;
            this.bookPublisher = bookPublisher;
            this.bookPrice = bookPrice;
        }

        public String getBookID() {
            return bookID;
        }

        public String getBookName() {
            return bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public int getBookPages() {
            return bookPages;
        }

        public String getBookGenre() {
            return bookGenre;
        }

        public double getBookRating() {
            return bookRating;
        }

        public int getBookPublishedYear() {
            return bookPublishedYear;
        }

        public String getBookPublisher() {
            return bookPublisher;
        }

        public double getBookPrice() {
            return bookPrice;
        }
    }

    private String orderedBook;
    private LocalDate orderDate;
    private String orderID;
    private double transactionAmount;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userID;
    private String orderType;

    public void generateOrderID() {
        String prefix = "TANLOD";
        String datePart = orderDate.format(java.time.format.DateTimeFormatter.ofPattern("YYYY-MM-DD"));
        String bookTitlePrefix = orderedBook.substring(0, 3).toUpperCase();
        orderID = prefix + datePart + bookTitlePrefix;
    }

    public void setUserID() {
        String prefix = "TANLUS";
        String fullName = (firstName + lastName).toUpperCase();

        userID = prefix + fullName.substring(0, 5);
    }

    BookStore(String firstName, String lastName, String emailAddress) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;

    }

    public String getOrderedBook() {
        return orderedBook;
    }

    public void setOrderedBook(String orderedBook) {
        this.orderedBook = orderedBook;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BookDetails searchBook(String bookID) {
        BookDetails[] books = BookDetails.values();
        for (BookDetails book : books) {
            if (book.bookID.equals(bookID)) {
                this.orderedBook = book.getBookName();
                transactionAmount = book.bookPrice;
                return book;
            }
        }
        return null;
    }

    public void orderBook(int choice) {

        switch (choice) {
            case 1:
                System.out.println(
                        "You have chosen to rent the book, and that the rent is only for one month, and that you will be charged €5 for this period.");
                orderType = "Rent";
                transactionAmount = 5;
                break;
            case 2:
                System.out.println(" You have chosen to purchase the book.");
                orderType = "Purchase";

                break;
            default:
                break;
        }

    }

    public void orderConfirmation() {

        System.out.println("Dear," + firstName + lastName);
        System.out.println("Thank you for ordering " + orderedBook + " from Turn-A-New-Leaf. Following are your order details: ");
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Date: " + orderDate);
        System.out.println("User ID: " + userID);
        System.out.println("User contact: " + emailAddress);
        System.out.println("Transaction type: " + orderType);
        System.out.println("Transaction amount: €" + transactionAmount);
    }
}
