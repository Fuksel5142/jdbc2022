package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection
                ("jdbc:postgresql://localhost:5432/techproed", "postgres", "fuksel51");
        Statement st = con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri olan company ve number_of_employees değerlerini çağırın.
        //1.yol offset ve fetch next kullanarak
        //String sql1 = "select company,max(number_of_employees) as en yuksek ikinci from companies where number_of_employees<(select max(number_of_employees) from companies) ";
        String sql1="SELECT company,number_of_employees FROM companies \n" +
                "order by number_of_employees desc \n" +
                "offset 1 row\n" +
                "fetch next 1 row only;";

        ResultSet result1 =st.executeQuery(sql1);
        while (result1.next()) {
            System.out.println(result1.getString("company")+"-------"+result1.getInt("number_of_employees"));
        }
        //2. Yol Subquery kullanarak
        String sql2 = "SELECT company, number_of_employees\n" +
                "FROM companies\n" +
                "WHERE number_of_employees = (SELECT  MAX(number_of_employees)\n" +
                "                             FROM companies\n" +
                "                             WHERE number_of_employees < (SELECT MAX(number_of_employees)\n" +
                "                             FROM companies))";

        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()){
            System.out.println(result2.getString("company")+"---"+result2.getInt("number_of_employees"));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();









    }
}