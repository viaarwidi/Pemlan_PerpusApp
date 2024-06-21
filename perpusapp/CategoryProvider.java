/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;

/**
 *
 * @author user
 */
public class CategoryProvider {
    Category[] categories;

    CategoryProvider() {
        // Inisialisasi kategori
        categories = new Category[7];
        categories[0] = new Category("Cerpen","Fiksi cerita pendek");
        categories[1] = new Category("Novel","Cerita fiksi dalam buku");
        categories[2] = new Category("Saga","Cerita-cerita lama dari epos terkenal");
        categories[3] = new Category("Komik","Buku dengan cerita bergambar");
        categories[4] = new Category("Biografi","Berisi cerita-cerita tentang kehidupan seseorang");
        categories[5] = new Category("Karya Ilmiah","Karya-karya ilmiah dalam berbagai bidang");
        categories[6] = new Category("Pemberitaan","Arsip koran dan majalah");
    }   
         public Category[] getcategories() {
        return categories;
    }
    }

