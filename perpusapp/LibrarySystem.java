/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;


import java.util.Scanner;
//import com.mycompany.perpusapp.Book;
//import com.mycompany.perpusapp.BookProvider;
/**
 *
 * @author user
 */
public class LibrarySystem {

    public LibrarySystem(BookProvider bookProvider1, CategoryProvider categoryProvider1, UserProvider userProvider1) {
    }

    private BookProvider bookProvider;
    private CategoryProvider categoryProvider;
    private UserProvider userProvider;
    
//    public LibrarySystem(BookProvider bookProvider, CategoryProvider categoryProvider, UserProvider userProvider) {
//        this.bookProvider = bookProvider;
//        this.categoryProvider = categoryProvider;
//        this.userProvider = userProvider;
//    }
    Category[] categoryProvider = categoryProvider.getcategories();
    Book[] bookProvider = bookProvider.getBooks(categories);
    User[] users = userProvider.getUser();
            
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        User currentUser = userProvider.login(username, password);

        if (currentUser != null) {
            displayMenu(scanner, currentUser);
        } else {
            System.out.println("Username atau password salah.");
        }

        scanner.close();
    }

    private void displayMenu(Scanner scanner, User currentUser) {
        while (true) {
            System.out.println("\nSelamat datang pada perpustakaan virtual!");
            System.out.println("Silahkan memilih menu di sini:");
            System.out.println("1. Melihat semua daftar katalog buku");
            System.out.println("2. Melihat detail suatu buku");
            System.out.println("3. Mencari dengan sortir kategori");
            System.out.println("4. Melihat data user saat ini");
            System.out.println("5. Meminjam suatu buku");
            System.out.println("6. Mengembalikan suatu buku");
            System.out.println("7. Keluar dari system");

            System.out.print("Masukan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline di buffer

            switch (choice) {
                case 1:
                    displayBookCatalog();
                    break;
                case 2:
                    displayBookDetail();
                    break;
                case 3:
                    searchByCategory(scanner);
                    break;
                case 4:
                    displayUserData(currentUser);
                    break;
                case 5:
                    borrowBook(scanner, currentUser);
                    break;
                case 6:
                    returnBook(scanner, currentUser);
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan perpustakaan virtual!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }

    private void displayBookCatalog() {
    System.out.println("Daftar semua buku yang tersedia:");
    for (int i = 0; i < bookProvider.books.length; i++) {
//        System.out.println((i + 1) + ". " + bookProvider.books[i].getName());
        System.out.println("Judul: " + (i + 1) + ". " + bookProvider.books[i].getName());
        System.out.println("Penulis: " + (i + 1) + ". " + bookProvider.books[i].getAuthorName());
        System.out.println("Tahun Rilis: " + (i + 1) + ". " + bookProvider.books[i].getTahunRilis());
        
    }
}
    public void displayBookDetail() {
    if (bookProvider == null) {
        System.out.println("Error: Book provider is not initialized.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nMasukkan index buku yang ingin dilihat detailnya: ");
    int index = scanner.nextInt();
    scanner.nextLine(); // Membersihkan newline di buffer

//    Book[] books = bookProvider.getBooks();
    if (index >= 1 && index <= books.length) {
        Book book = books[index - 1];
        System.out.println("\nDetail Buku:");
        System.out.println("Judul: " + book.getName());
        System.out.println("Penulis: " + book.getAuthorName());
        System.out.println("Tahun Rilis: " + book.getTahunRilis());
        // Tambahkan informasi lainnya sesuai kebutuhan
    } else {
        System.out.println("Index buku tidak valid.");
    }
}

    
    private void searchByCategory(Scanner scanner) {
    System.out.println("Daftar Kategori Buku yang Tersedia:");
    for (int i = 0; i < categoryProvider.categories.length; i++) {
        System.out.println((i + 1) + ". " + categoryProvider.categories[i].getNameCategory());
    }

    System.out.print("Pilih untuk melakukan sortir buku per category (masukkan nomor kategori): ");
    int categoryIndex = scanner.nextInt();
    scanner.nextLine(); // Membersihkan newline di buffer

    if (categoryIndex > 0 && categoryIndex <= categoryProvider.categories.length) {
    System.out.println("Anda memilih kategori: " + categoryProvider.categories[categoryIndex - 1].getNameCategory());
    System.out.println("Buku yang termasuk dalam kategori ini adalah:");
    boolean found = false; 
    for (Book book : bookProvider.books) {
        if (book.getCategory() != null && book.getCategory().equals(categoryProvider.categories[categoryIndex - 1])) {
            System.out.println(book);
            found = true; // Ubah ke true jika buku ditemukan
        }
    }
    if (!found) {
        System.out.println("Tidak ada buku dalam kategori ini.");
    }
} else {
    System.out.println("Nomor kategori tidak valid.");
}
}


    private void displayUserData(User currentUser) {
        System.out.println("Data diri Anda:");
        System.out.println("Nama: " + currentUser.getName());
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Password: " + currentUser.getPassword());
        System.out.println("Buku yang dipinjam:");
        for (Book book : currentUser.getBorrowedBooks()) {
            System.out.println(book);
        }
    }

    private void borrowBook(Scanner scanner, User currentUser) {
        displayBookCatalog();
        System.out.print("Pilih buku yang akan dipinjam (masukkan index): ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline di buffer

        if (bookIndex >= 0 && bookIndex < bookProvider.books.length) {
            Book selectedBook = bookProvider.books[bookIndex];
            if (!selectedBook.isBorrowed()) {
                selectedBook.setBorrowed(true);
                selectedBook.setUser(currentUser);
                currentUser.borrowBook(selectedBook);
                System.out.println("Anda berhasil meminjam buku.");
            } else {
                System.out.println("Buku sudah dipinjam.");
            }
        } else {
            System.out.println("Index buku tidak valid.");
        }
    }

   private void returnBook(Scanner scanner, User currentUser) {
    displayUserData(currentUser);
    System.out.print("Masukkan nomor buku yang ingin Anda kembalikan: "); // Menggunakan nomor buku, bukan indeks
    int bookNumber = scanner.nextInt();
    scanner.nextLine(); // Membersihkan newline di buffer

    // Mengubah nomor buku menjadi indeks dengan mengurangkan 1
    int bookIndex = bookNumber - 1;

    if (bookNumber >= 1 && bookNumber <= currentUser.borrowedBooksSize()) {
        Book returnedBook = currentUser.returnBook(bookIndex);
        if (returnedBook != null) {
            returnedBook.setBorrowed(false);
            returnedBook.setUser(null);
            System.out.println("Buku berhasil dikembalikan.");
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    } else {
        System.out.println("Nomor buku tidak valid.");
    }
}

   public static void main(String[] args) {
        // Inisialisasi daftar buku
//        Book[] books = {
//            new Book("Mein Kampf", "Adolf Hitler", "1925", null),
//            new Book("Laskar Pelangi", "Andrea Hirata", "2007", null),
//            new Book("MAHABARATA", "Byasa", "1990", null),
//            new Book("Mengais Asa", "Ramdani Koernia", "2018", null)
//        };
//
//        // Inisialisasi daftar kategori
//        Category[] categories = {
//            new Category("Cerpen", "..."),
//            new Category("Novel", "..."),
//            new Category("Saga", "..."),
//            new Category("Komik", "..."),
//            new Category("Biografi", "..."),
//            new Category("Karya Ilmiah", "..."),
//            new Category("Pemberitaan", "...")
//        };
// 
//        // Inisialisasi daftar pengguna
//        User[] users = {
//            new User("User 1", "user1@gmail.com", "PasswordUser1")
//        };

        // Inisialisasi provider
       // BookProvider bookProvider = new BookProvider();
        CategoryProvider categoryProvider = new CategoryProvider();
        UserProvider userProvider = new UserProvider();

        // Buat objek LibrarySystem
       // LibrarySystem librarySystem = new LibrarySystem(bookProvider, categoryProvider, userProvider);

        // Panggil method start
        librarySystem.start();
    }

    }

