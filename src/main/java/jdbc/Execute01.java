package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. adım driverea kaydol
        Class.forName("org.postgresql.Driver");
        // 2. adım database ya bağlan
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","fuksel51");

        //3.adım: Statement oluştur.
        Statement st=con.createStatement();

        //4.adım Query çalıştır.

        //1 örnek :

        //st.execute("Create table workers(worker_id varchar(50), worker_name varchar(50), worker_salary varchar(INT)");
        String sql1="Create table workers(worker_id varchar(50), worker_name varchar(50), worker_salary INT)";
        boolean result=st.execute(sql1);
        System.out.println(result); // False return yapar, çünkü data çağrılmadı.

        // 2.örnek: table a worker name sütünu ekleyerek alter yapın
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);// bu ekliyor

        //3.Örnek: Drop workers table
        String sql3 = "DROP TABLE workers";
        st.execute(sql3);

        //5. Adım: Bağlantı ve Statement'ı kapat.
        con.close();
        st.close();







    }
}
