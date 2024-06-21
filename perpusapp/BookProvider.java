/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;

/**
 *
 * @author user
 */
public class BookProvider {
    Book[] books;

    public BookProvider() {
        Category cerpen=new Category("Cerpen","Fiksi cerita pendek");
        Category novel=new Category("Novel","Cerita fiksi dalam buku");
        Category saga=new Category("Saga","Cerita-cerita lama dari epos terkenal");
        Category komik=new Category("Komik","Buku dengan cerita bergambar");
        Category biografi=new Category("Biografi","Berisi cerita-cerita tentang kehidupan seseorang");
        Category karyailmiah=new Category("Karya Ilmiah","Karya-karya ilmiah dalam berbagai bidang");
        Category pemberitaan=new Category("Pemberitaan","Arsip koran dan majalah");
        
        // Inisialisasi buku-buku
    }
    
     public Book[] getBooks(Category[] categories) {
         books = new Book[4];
        books[0] = new Book("Mein Kampf", "Adolf Hitler", "1925", categories[4]);
        books[1] = new Book("Laskar Pelangi", "Andrea Hirata", "2007", categories[1]);
        books[2] = new Book("MAHABARATA", "Byasa", "1990", categories[0]);
        books[3] = new Book("Mengais Asa", "Ramdani Koernia", "2018", categories[4]);
        return books;
    }
   
}
