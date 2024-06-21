/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.perpusapp;

/**
 *
 * @author user
 */


    public class Book {
    String name;
    String authorName;
    String tahunRilis;
    Category category;
    boolean isBorrowed;
    User user;

    Book(String name, String authorName, String tahunRilis, Category category) {
        this.name = name;
        this.authorName = authorName;
        this.tahunRilis = tahunRilis;
        this.category = category;
        this.isBorrowed = false;
    }
    
    // getters and setters
     public String getName() {
        return name;
    }
     
     public String getAuthorName() {
        return authorName;
    }
     
     public String getTahunRilis() {
        return tahunRilis;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
    
     public Category getCategory() {
        return category;
    }
     
    public User getUser() {
        return user;
    }
    
      public void setUser(User user) {
        this.user = user;
    }
      
    // New method to borrow a book
    public void borrowBook(User currentUser) {
        if (!this.isBorrowed()) {
            this.setBorrowed(true);
            this.setUser(currentUser);
            currentUser.borrowBook(this);
            System.out.println("Anda berhasil meminjam buku.");
        } else {
            System.out.println("Buku sudah dipinjam.");
        }
    }
    
    public String toString() {
    String status = isBorrowed ? "Dipinjam" : "Tersedia";
    return "Judul: " + name + "\n" +
           "Penulis: " + authorName + "\n" +
           "Tahun Rilis: " + tahunRilis + "\n" +
           "Kategori: " + category.getNameCategory() + "\n" +
           "Status: " + status;
}

    
    
}


