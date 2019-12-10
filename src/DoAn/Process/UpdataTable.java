/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn.Process;
import DoAn.DaTa.Connect;
import java.sql.*;
import javax.swing.*;
import DoAn.Data.*;
import net.proteanit.sql.*;
/**
 *
 * @author Long Y
 */
public class UpdataTable {
     public static PreparedStatement pst=null;//Thuc thi sql:
     public static ResultSet rs=null;//Ket qua tra ve:
     public static Connection conn=Connect.getConnect();//Ket noi data:
     //Viet ham ket noi du lieu cho bang:
     public static void LoadDaTa(String sql,JTable tb)
     {
         try{
             pst =conn.prepareStatement(sql);
             rs=pst.executeQuery();
             tb.setModel((DbUtils.resultSetToTableModel(rs)));
             //Nạp dữ liệu lên bảng truyen vao:
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, e,"Thông báo lỗi",1);
         }
     }
     //Viet ham dua 1 dong du lieu tu bang len texfiled:
     public  static ResultSet ShowTextField(String sql)
     {
         try{
             pst=conn.prepareStatement(sql);
             return pst.executeQuery();
             //Trả về 1 dòng dữ liệu đọc được:
         }catch(Exception e)
         {
             return null;
             
         }
     }
}
