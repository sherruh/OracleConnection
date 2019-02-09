package Work;

import java.io.BufferedReader;
import java.sql.*;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner in=new Scanner(System.in);
        Connection con;
        try {
            con=new MyOracleConnection().getCon();
            //TODO selects
            con.close();
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
            in.nextLine();
            System.exit(0);
        }

        CellsGSM cellsGSM=new CellsGSM("a","a","a","a",
                "a","a","a","a","a","a","5","6");

        System.out.println(cellsGSM);

        System.out.println("Ok!");
        in.nextLine();

    }
}

