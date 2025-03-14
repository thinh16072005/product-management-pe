/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dbcontext.DBContext;
import com.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hungt
 */
public class ProductService implements ProductServiceInterface {
    
    DBContext db = new DBContext();
    Connection conn;
    PreparedStatement statement;

    @Override
    public void addProduct(Product product) {
        // create sql for insert
        String sql = "INSERT INTO Product(product_name, product_unit, product_category, product_price) VALUES (?,?,?,?);";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, product.getProdName());
            statement.setString(2, product.getProdUnit());
            statement.setString(3, product.getCatName());
            statement.setDouble(4, product.getProdPrice());
            
            statement.execute();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            //Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        String sql = " UPDATE Product\n"
                + "SET product_name=?, product_unit=?, product_category=?, product_price=?\n"
                + "WHERE product_id = ?";
        try {
            conn = db.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.getProdName());
            statement.setString(2, product.getProdUnit());
            statement.setString(3, product.getCatName());
            statement.setDouble(4, product.getProdPrice());
            statement.setDouble(5, product.getProdId());
            statement.execute();
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(String idd) {
        // create the connection
        String sql = "DELETE FROM Product WHERE product_id=?";
        try {
            conn = db.getConnection();
            // prepare the statement in order to excute the sql comments
            PreparedStatement statement = conn.prepareStatement(sql);
            
            // convert String id to int id
            int id = Integer.parseInt(idd);
            
            // set parameter in the sql
            statement.setInt(1, id);
            
            // execute the sql
            statement.execute();
            
            // Close the connection
            conn.close();
            statement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
