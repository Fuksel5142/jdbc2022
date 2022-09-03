package jdbc;

import java.sql.*;

public class tekrart {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/sql_practice", "postgres", "fuksel51");
        Statement st=con.createStatement();
        String sql="select * from calisanlar where maas=(select MİN(maas) from calisanlar)";

        ResultSet result1 =st.executeQuery(sql);
        while (result1.next()) {
            System.out.println(result1.getInt("id")+"--"+result1.getString("isim")+"--"+result1.getString("sehir")+result1.getInt("maas")+result1.getString("isyeri"));
        }
        }
    }

