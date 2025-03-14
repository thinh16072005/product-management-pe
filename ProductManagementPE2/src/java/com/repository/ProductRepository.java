/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.dbcontext.DBContext;
import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hungt
 */
public class ProductRepository {
    DBContext db = new DBContext();
    Connection conn = null;
    Product product = null;

    public ProductRepository() {
    }
    
    public Product getProduct(String idd) {
        int id = Integer.parseInt(idd);
        
        String sql = "Select * from Product where product_id = ?";
        try {
            conn = db.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String productName = rs.getString(2);
                String productUnit = rs.getString(3);
                String productCategory = rs.getString(4);
                double productPrice = rs.getDouble(5);
                product = new Product(id, productName, productUnit, productCategory, productPrice);
            }
            db.close(conn, statement, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public List<Product> getProductList() throws Exception {
        List<Product> sl = new ArrayList<>();
        String sql = "Select * from Product";
        try {
            conn = db.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt(1);
                String productName = rs.getString(2);
                String productUnit = rs.getString(3);
                String productCategory = rs.getString(4);
                double productPrice = rs.getDouble(5);
                Product product = new Product
        (productId, productName, productUnit, productCategory, productPrice);
                sl.add(product);
            }
            db.close(conn, statement, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sl;
    }
}
