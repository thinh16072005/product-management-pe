/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repository;

import com.dbcontext.DBContext;
import com.model.Category;
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
public class CategoryRepository {
    DBContext db = new DBContext();
    Connection conn = null;
    Category category = null;

    public CategoryRepository() {
    }
    
    public Category getCategory(String idd) {
        int id = Integer.parseInt(idd);
        
        String sql = "Select * from Category where category_id = ?";
        try {
            conn = db.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String categoryName = rs.getString(2);
                String categoryDesc = rs.getString(3);
                category = new Category(id, categoryName, categoryDesc);
            }
            db.close(conn, statement, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return category;
    }

    public List<Category> getCategoryList() throws Exception {
        List<Category> sl = new ArrayList<>();
        String sql = "Select * from Category";
        try {
            conn = db.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt(1);
                String categoryName = rs.getString(2);
                String categoryDesc = rs.getString(3);
                category = new Category(categoryId, categoryName, categoryDesc);
                sl.add(category);
            }
            db.close(conn, statement, rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sl;
    }
}
