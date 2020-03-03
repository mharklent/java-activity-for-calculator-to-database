/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malcontin_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author AICS-CEBU
 */
public class Malcontin_database {

    /**
     * @param args the command line arguments
     * 
     * 
     */    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        System.out.println("Username:");
        String username = in.nextLine();
        System.out.println("TID:");
        int tid = in.nextInt();
        System.out.println("Amount:");
        Double amount = in.nextDouble();
        System.out.println("Quantity:");
        int quantity = in.nextInt();
        System.out.println("Total:");
        Double total = amount*quantity;
        System.out.println("Cash:");
        Double cash = in.nextDouble();
        System.out.println("Change:");
        Double change = cash-total;
    }
    static void insert(String username, int tid, Double amount, int quantity, Double total, Double cash, Double change){
    try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:msql://localhost/malcontin_database","Transaction","");
    Statement st = con.createStatement();
    String sql = "insert into Transaction value ('"+username+"',"+tid+","+amount+","+quantity+","+total+","+cash+","+change+")";
    System.out.println(sql);
    st.executeUpdate(sql);
    con.close();
    }catch (Exception e){System.out.print(e);}
    }
}
