/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author hungt
 */
public class Product extends Category {
    int prodId;
    String prodName;
    String prodUnit;
    double prodPrice;

    public Product(int prodId, String prodName, String prodUnit, String catName, double prodPrice) {
        super(catName);
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodUnit = prodUnit;
        this.prodPrice = prodPrice;
    }

    public Product(String prodName, String catName, String prodUnit, double prodPrice) {
        super(catName);
        this.prodName = prodName;
        this.prodUnit = prodUnit;
        this.prodPrice = prodPrice;
    }
    
    public Product() {
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdUnit() {
        return prodUnit;
    }

    public void setProdUnit(String prodUnit) {
        this.prodUnit = prodUnit;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    
    
    @Override
    public void setCatName(String catName) {
        super.setCatName(catName); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getCatName() {
        return super.getCatName(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
