/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.model.Product;

/**
 *
 * @author hungt
 */
public interface ProductServiceInterface {
    void addProduct(Product product);
    
    void updateProduct(Product product);
    
    void deleteProduct(String idd);
}
