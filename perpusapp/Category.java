/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.perpusapp;

/**
 *
 * @author user
 */
public class Category {
    String nameCategory;
    String generalDescription;

    Category(String nameCategory, String generalDescription) {
        this.nameCategory = nameCategory;
        this.generalDescription = generalDescription;
    }
    
    public String getNameCategory() {
        return nameCategory;
    }

    public String getGeneralDescription() {
        return generalDescription;
    }
    
//    public Category findCategoryByName(Category[] categories, String categoryName) {
//        for (Category category : categories) {
//            if (category.getNameCategory().equalsIgnoreCase(categoryName)) {
//                return category;
//            }
//        }
//        return null; // Mengembalikan null jika kategori tidak ditemukan
//    }
}
