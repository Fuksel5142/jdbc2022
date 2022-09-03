package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/techproed", "postgres", "fuksel51");
        Statement st = con.createStatement();
        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.

        String sql="update companies set number_of_employees=17000\n" +
                "where number_of_employees < (\n" +
                "select avg (number_of_employees )\n" +
                "from companies)";

        int updatesatırsayisi=st.executeUpdate(sql);
        System.out.println("updatesatırsayisi = " + updatesatırsayisi);
        String sql2 = "SELECT * FROM companies";

        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()){

            System.out.println(result1.getInt(1)+"--"+result1.getString(2)+"--"+result1.getInt(3));

        }

       /* String sql25="update companies set company='xamio'  where number_of_employees =21000";

        ResultSet result3=st.executeQuery(sql25);
        while(result3.next()){
            System.out.println(result3.getInt(1)+"--"+result3.getString(2)+"--"+result3.getInt(3));
        }*/


        con.close();
        st.close();




    }
}
