/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbcontext;

/**
 *
 * @author Ly Quynh Tran
 */
public interface DatabaseInfor {
    String DRIVER_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://localhost:1433;databaseName=Workshop2_Se1501;trustServerCertificate=true";
    String USER_NAME = "sa";
    String PASSWORD = "abc@123";
}
