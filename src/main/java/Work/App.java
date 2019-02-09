package Work;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        Scanner in=new Scanner(System.in);
        Connection con;
        CellsDao cellsDao;
        List<CellsGSM> cellsGSM;
        //try {
        //    con=new MyOracleConnection().getCon();
        //    cellsDao=new CellsDao(con);
        //    cellsGSM=cellsDao.getCellsGSM();
        //    //TODO selects
        //    con.close();
        //} catch (SQLException | NullPointerException | IOException | ClassNotFoundException e) {
        //    e.printStackTrace();
        //    in.nextLine();
        //}

        CellsGSM cellGSM=new CellsGSM("70006_ChD-Novopavlovka","a","a","a",
                "a","a","a","a","a","a","5","6");
        System.out.println(cellGSM);
        cellsGSM=new ArrayList<>();
        cellsGSM.add(cellGSM);
        cellsGSM.add(cellGSM);
        cellsGSM.add(cellGSM);
        cellsGSM.add(cellGSM);
        try {
            CreateBTSFile createBTSFile= new CreateBTSFile(cellsGSM);
            createBTSFile.insertDataToBtsFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ok!");//TODO place in try
        in.nextLine();

    }
}

