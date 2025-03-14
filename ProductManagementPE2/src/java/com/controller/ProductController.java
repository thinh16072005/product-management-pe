/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.model.Category;
import com.model.Product;
import com.repository.CategoryRepository;
import com.repository.ProductRepository;
import com.service.ProductService;
import jakarta.servlet.RequestDispatcher;
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
public class ProductController extends HttpServlet {
    
    ProductRepository prodRepo;
    ProductService prodServ ;
    CategoryRepository catRepo;

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    public void init() throws ServletException {
        prodRepo = new ProductRepository();
        catRepo = new CategoryRepository();
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
                case "SHOW_ADD_PRODUCT":
                    showAddProductForm(request, response);
                    break;
                case "LIST":
                    listProduct(request, response);
                    break;
                case "ADD":
                    addProduct(request, response);
                    break;
                case "LOAD":
                    loadProduct(request, response);
                    break;
                case "UPDATE":
                    updateProduct(request, response);
                    break;
                case "DELETE":
                    deleteProduct(request, response);
                     break;
                default:
                    listProduct(request, response);
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
    
    /* Retrieve and display product list */
    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get students from the the database
        List<Product> list = prodRepo.getProductList();
        
        // add these students to the object request
        request.setAttribute("productList", list);

        // send to the JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("product_list.jsp");
        dispatcher.forward(request, response);
    }
    
     private void showAddProductForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get students from the the database
        List<Category> catList = catRepo.getCategoryList();
        
        // add these categories to the object request
        request.setAttribute("categoryList", catList);
        
        request.getRequestDispatcher("add_product.jsp").forward(request, response);
    }
    
    /* Load a single product in the list*/
    private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read student id from the form data
        String theProductId = request.getParameter("productId");

        //get student from the database
        Product product = new ProductRepository().getProduct(theProductId);
        
        //place product in the request attribute
        Product p = (Product) product;
        request.setAttribute("PRODUCT", p);
        
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit_product.jsp");
        dispatcher.forward(request, response);
    }
    
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read product info from the form
        int productId = Integer.parseInt(request.getParameter("prodID"));
        String productName = request.getParameter("prodName");
        String productUnit = request.getParameter("prodUnit");
        String productCategory = request.getParameter("prodCategory");
        Double productPrice = Double.valueOf(request.getParameter("prodPrice"));
        
        //create a new product object
        Product product = new Product(productId, productName, productUnit, productCategory, productPrice);
        
        // add the product to the database
        prodServ = new ProductService();
        prodServ.addProduct(product);
        
        // calling the student list jsp page
        listProduct(request, response);
    }
    
    // Edit a single product in the list
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // read product info from the form data
        int id = Integer.parseInt(request.getParameter("productId"));
        String prodName = request.getParameter("name");
        String prodUnit = request.getParameter("unit");
        String prodCategory = request.getParameter("category");
        Double prodPrice = Double.valueOf(request.getParameter("price"));   
        
        //create a new product object
        Product product = new Product(id, prodName, prodUnit, prodCategory, prodPrice);

        //perform update on database
        new ProductService().updateProduct(product);
        
        //send them back to the "list product" page
        listProduct(request, response);
    }
    
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //read student id from the form data
        String theProductId = request.getParameter("studentId");

        // delete student from the database
        new ProductService().deleteProduct(theProductId);
        
        // send them back to the "list student" pages
        listProduct(request, response);
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
