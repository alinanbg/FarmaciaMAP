/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.farmacia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alina
 */
public class ConnectionFactory {
    
     public static Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    ConfUtil.getConf(ConfUtil.CONF_JDBC_URL), 
                    ConfUtil.getConf(ConfUtil.CONF_JDBC_USUARIO), 
                    ConfUtil.getConf(ConfUtil.CONF_JDBC_SENHA));
            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }
}
