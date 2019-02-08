package Work;

import java.sql.*;

public class App
{
    public static void main( String[] args )
    {
        Connection con;
        try {
            con=new MyOracleConnection().getCon();
            con.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            System.exit(0);
        }

        CellsGSM cellsGSM=new CellsGSM("a","a","a","a",
                "a","a","a","a","a","a","5","6");

        System.out.println(cellsGSM);
    }
}

