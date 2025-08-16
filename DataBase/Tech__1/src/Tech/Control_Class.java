/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tech;

import static Tech.Registry.APnum;
import static Tech.Registry.Phone;
import static Tech.Registry.Student_name;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.jar.Attributes.Name;
import javax.swing.*;
public class Control_Class {
    
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";


private boolean loginStatus = false;

     
   public static boolean Student_Name(String Student_name){
        String regex = "^(?=.*_)[a-zA-Z0-9_]{1,10}$";

        return Student_name.matches(regex);
    }
    public static boolean checkApplicationNumber(String APnum){
    
        String regex = "^AP\\d{9}$";
        return Pattern.matches(regex, APnum);
    }
    public static boolean checkCellPhoneNumber(String phone){
        String phoneRegex =  "^\\+27[6-8][0-9]{8}$";
      return Pattern.matches(phoneRegex,phone);
    }

      public String registerUser(String Student_name, String APnum, String Phone, String Course) {
        
    
        if (!Student_Name(Student_name)) {
            String message = "name is not correctly formatted, please ensure that your name contains Letters and is no more than five characters in lenght.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return message;
        }else {
            String messagee1 = "name successfully captured.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
       if (!checkApplicationNumber(APnum)) {
            String message = "Application Number Invalid";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return message;
        }else {
            String messagee1 = "Application number successfully  captured.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        
        if (!checkCellPhoneNumber(Phone)) {
            String message = "Cell phone number incorrectly formatted or does not contain international code.";
            JOptionPane.showMessageDialog(null, message, "Registration Error", JOptionPane.ERROR_MESSAGE);
            return message;
        }else {
            String messagee1 = "Cell phone number successfully added.";
            JOptionPane.showMessageDialog(null, messagee1, "Registration ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    // Database connection
    String url = "jdbc:mysql://localhost:3306/mysql";
    String user = "root";
    String pass = "2003";
    
    String query = "INSERT INTO jTable1 (name, app_number, phone, course) VALUES (?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, user, pass);
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, Student_name);
        stmt.setString(2, APnum);
        stmt.setString(3, Phone);
        stmt.setString(4, Course);

        int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Student registered successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed.");
        }

     } catch (Exception e) {
            String err = "Database error: " + e.getMessage();
            JOptionPane.showMessageDialog(null, err);
            return err;
        }
        return null;
    }
      

public class TableExample {
    public static void main(String[] args) {
       System.out.print("Data Base not found");
    }
}
}
        
/**
 *
 * @author BALOYI MPHO
 */

       
        
        
        
        
        
/**
 *
 * @author BALOYI MPHO
 */


