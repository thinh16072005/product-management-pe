/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author hungt
 */
public class Category {
    int catID;
    String catName;
    String catDesc;

    public Category(int catID, String catName, String catDesc) {
        this.catID = catID;
        this.catName = catName;
        this.catDesc = catDesc;
    }

    public Category(String catName, String catDesc) {
        this.catName = catName;
        this.catDesc = catDesc;
    }

    
    
    public Category(String catName) {
        this.catName = catName;
    }
    
    

    public Category() {
    }
    

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
    
    
}
