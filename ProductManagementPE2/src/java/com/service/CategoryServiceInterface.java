/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.model.Category;

/**
 *
 * @author hungt
 */
public interface CategoryServiceInterface {
    void addCategory(Category category);
    
    void updateCategory(Category category);
    
    void deleteCategory(String idd);
}
