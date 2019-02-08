package Work;

import java.sql.*;

public class App
{
    public static void main( String[] args )
    {
        Connection con=new MyOracleConnection().getCon();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

