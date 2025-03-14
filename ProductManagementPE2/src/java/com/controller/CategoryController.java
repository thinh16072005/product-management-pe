/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Category;
import com.model.Product;
import com.repository.CategoryRepository;
import com.service.CategoryService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author hungt
 */
public class CategoryController extends HttpServlet {
    
    CategoryRepository catRepo;
    CategoryService catServ;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        catRepo = new CategoryRepository(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST" -> listCategory(request, response);
                case "ADD" -> addCategory(request, response);
                case "LOAD" -> loadCategory(request, response);
                case "UPDATE" -> updateCategory(request, response);
                case "DELETE" -> deleteCategory(request, response);
                default -> listCategory(request, response);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void listCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get students from the the database
        List<Category> catList = catRepo.getCategoryList();
        
        // add these categories to the object request
        request.setAttribute("categoryList", catList);
        
        request.getRequestDispatcher("category_list.jsp").forward(request, response);
    }
    
    private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read student id from the form data
        String theCategoryId = request.getParameter("categoryId");

        //get student from the database
        Category category = new CategoryRepository().getCategory(theCategoryId);
        
        //place category in the request attribute
        Category c = (Category) category;
        request.setAttribute("category", c);
        
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_product.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read product info from the form
        String categoryName = request.getParameter("catName");
        String categoryDesc = request.getParameter("catDesc");
        
        //create a new product object
        Category category = new Category(categoryName, categoryDesc);
        
        // add the product to the database
        catServ = new CategoryService();
        catServ.addCategory(category);
        
        // calling the student list jsp page
        listCategory(request, response);
    }
    
    // Edit a single product in the list
    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read student info from the form data
        String prodName = request.getParameter("prodName");
        String prodUnit = request.getParameter("prodUnit");
        String prodCategory = request.getParameter("prodCategory");
        Double prodPrice = Double.valueOf(request.getParameter("prodPrice"));
        
        //create a new product object
        Product product = new Product(prodName, prodUnit, prodCategory, prodPrice);

        //perform update on database
        new CategoryService().updateCategory(product);
        
        //send them back to the "list product" page
        listCategory(request, response);
    }
    
    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read student id from the form data
        String theCategoryId = request.getParameter("categoryId");

        // delete student from the database
        new CategoryService().deleteCategory(theCategoryId);
        
        // send them back to the "list student" pages
        listCategory(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
