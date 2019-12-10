/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoAn.Process;
import java.sql.*;
import javax.swing.*;
import DoAn.DaTa.*;
/**
 *
 * @author Long Y
 */
public class XeMay {
    public static Connection conn=Connect.getConnect();
    public static PreparedStatement pst=null;
    public static ResultSet rs=null;
    
    public static void InsertXeMay(String maXe,String tenXe,String loaiXe,String giaXe,String ngaySX,String mauXe,String hangSX)
    {
        String sql="INSERT INTO `xemay`(`maXe`, `tenXe`, `loaiXe`, `giaXe`, `ngaySX`, `mauXe`, `hangSX`) VALUES (?,?,?,?,?,?,?)";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, maXe);
            pst.setString(2, tenXe);
            pst.setString(3, loaiXe);
            pst.setString(4, giaXe);
            pst.setString(5, ngaySX);
            pst.setString(6, mauXe);
            pst.setString(7, hangSX);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm xe: "+maXe+" thành công","Thông báo",1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Mã xe: "+maXe+" đã tồn tại không thể thêm hoặc không được nhập bằng kí tự chữ","Thông báo",1);
        }
    }
    public static void UpdateXeMay(String maXe1,String maXe,String tenXe,String loaiXe,String giaXe,String ngaySX,String mauXe,String hangSX)
    {
        String sql="UPDATE `xemay` SET `maXe`='"+maXe+"',`tenXe`='"+tenXe+"',`loaiXe`='"+loaiXe+"',`giaXe`='"+giaXe+"',`ngaySX`='"+ngaySX+"',`mauXe`='"+mauXe+"',`hangSX`='"+hangSX+"' WHERE `maXe`='"+maXe1+"' ";
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Xe: "+maXe1+" đã sửa thành "+maXe+" thành công","Thông báo",1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Mã xe: "+maXe1+" đã tồn tại không thể sửa hoặc không được nhập bằng kí tự chữ","Thông báo",1);
        }
    }
    public static void DeleteXeMay(String maXe)
    {
        String sql="DELETE FROM `xemay` WHERE `maXe`='"+maXe+"'";
        try{
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa xe: "+maXe+" thành công","Thông báo",1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Xe: "+maXe+" có thể sử dụng ở thực thể khác nên không thể xóa","Thông báo",1);
        }
    }
}
