/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;

/**
 *
 * @author user
 */
public class User {
    String name;
    String username;
    String password;
    Book[] borrowedBooks = new Book[2];
    boolean isBanned;

    User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    // getters and setters
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Book[] getBorrowedBooks() {
         return borrowedBooks;
    }
    
    
    public void borrowBook(Book book) {
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i] == null) {
                borrowedBooks[i] = book;
                break;
            }
        }
    }
    public int borrowedBooksSize() {
        int count = 0;
        for (Book book : borrowedBooks) {
            if (book != null) {
                count++;
            }
        }
        return count;
    }
    public Book returnBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < borrowedBooks.length) {
            Book returnedBook = borrowedBooks[bookIndex];
            borrowedBooks[bookIndex] = null;
            return returnedBook;
        } else {
            return null;
        }
        
        
}}

//public class User {
//    String name;
//    String username;
//    String password;
//    Book[] borrowedBooks = new Book[2];
//    boolean isBanned;
//
//    User(String name, String username, String password) {
//        this.name = name;
//        this.username = username;
//        this.password = password;
//    }
//    
//    // getters and setters
//    
//    public void setName(String name) {
//        this.name = name;
//    }
//    
//    public void setUsername(String username) {
//        this.username = username;
//    }
//    
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    
//    public Book[] getBorrowedBooks() {
//         return borrowedBooks;
//    }
//    
//    // Method untuk menambahkan buku yang dipinjam oleh pengguna
//    public void borrowBook(Book book) {
//        for (int i = 0; i < borrowedBooks.length; i++) {
//            if (borrowedBooks[i] == null) {
//                borrowedBooks[i] = book;
//                break;
//            }
//        }
//    }
//}

