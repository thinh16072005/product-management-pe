/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.dbcontext.DBContext;
import com.model.Category;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author hungt
 */
public class CategoryService implements CategoryServiceInterface {
    
    DBContext db = new DBContext();
    Connection conn;
    PreparedStatement statement;
    
    @Override
    public void addCategory(Category category) {
        // create sql for insert
        String sql = "INSERT INTO Category(category_name, category_description) VALUES (?,?);";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.getCatName());
            statement.setString(2, category.getCatDesc());
            statement.execute();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            //Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE Category\n"
                + "SET category_name=?, category_description=?\n"
                + "WHERE category_id = ?";
        try {
            conn = db.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, category.getCatName());
            statement.setString(2, category.getCatDesc());
            statement.execute();
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(String idd) {
        // create the connection
        String sql = "DELETE FROM Category WHERE category_id=?";
        try {
            conn = db.getConnection();
            // prepare the statement in order to excute the sql comments
            statement = conn.prepareStatement(sql);

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
