package Work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOracleConnection {

    private Connection con;

    private void initCon(){
        try {
            BufferedReader reader=new BufferedReader( new FileReader("Connection.txt"));
            String host=reader.readLine();
            String port=reader.readLine();
            String database=reader.readLine();
            String user=reader.readLine();
            String pass=reader.readLine();

            Class.forName("oracle.jdbc.driver.OracleDriver");
            DriverManager.setLoginTimeout(5);
            String bUrl = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST="+host+")(PORT="+port+"))(CONNECT_DATA=(SERVER = DEDICATED)(SERVICE_NAME="+database+")))";

            con= DriverManager.getConnection(bUrl,user,pass);
            System.out.println("Connected!");
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon(){

        if (con==null){
            initCon();
        }
        return con;

    }

}
