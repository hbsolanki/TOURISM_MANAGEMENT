package Db;

import java.sql.*;
import java.util.HashMap;

public class DB {
    private static Connection connect()throws Exception{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/amit", "root","8160062665");
    }

    public static void placeStoreInDB(String placeName,String p1,String p2,String p3)throws Exception{
        String sql="insert into place(pname,p1,p2,p3) values(?,?,?,?)";
        Connection con=connect();
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, placeName);
        pst.setString(2, p1);
        pst.setString(3, p2);
        pst.setString(4, p3);
        pst.executeUpdate();
    }

    public static HashMap<String,String> getPlaceFromDB()throws Exception{
        HashMap<String,String> map=new HashMap<>();

        String sql="select * from place";
        Connection con=connect();
        PreparedStatement pst=con.prepareStatement(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            String placeName=rs.getString(1);
            String p1=rs.getString(2);
            String p2=rs.getString(3);
            String p3=rs.getString(4);
            map.put(placeName,p1+";"+p2+";"+p3);
        }

        return map;
    }
}
