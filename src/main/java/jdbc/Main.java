package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //DBwork objesini oluştur
        DBWork db=new DBWork();


        //connection methodunu çağır
        Connection con=db.connect_to_db("techproed","postgres","fuksel51");

        ////Yeni table oluşturma methodunu çağır.
              db.createTable(con,"employees");
    }

}
