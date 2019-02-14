package Work;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        Scanner in=new Scanner(System.in);
        Connection con;
        CellsDao cellsDao;
        CellsAtollDao cellsAtollDao;
        List<Cells> cellsGSM;
        List<Cells> cellsUMTS;
        List<Cells> cellsLTE;
        List<Cells> cellsAtollGSM;
        List<Cells> cellsAtollUMTS;
        List<Cells> cellsAtollLTE;

        try {

            con=new MyOracleConnection().getCon();
            cellsDao=new CellsDao(con);
            cellsAtollDao=new CellsAtollDao(con);
            cellsGSM=cellsDao.getCellsGSM();
            cellsUMTS=cellsDao.getCellsUMTS();
            cellsLTE=cellsDao.getCellsLTE();
            cellsAtollGSM=cellsAtollDao.getCellsGSM();
            cellsAtollUMTS=cellsAtollDao.getCellsUMTS();
            cellsAtollLTE=cellsAtollDao.getCellsLTE();
            con.close();
            CreateBTSFile createBTSFile= new CreateBTSFile(cellsGSM,cellsUMTS,cellsLTE,false);
            createBTSFile.insertDataToBtsFiles();
            createBTSFile= new CreateBTSFile(cellsAtollGSM,cellsAtollUMTS,cellsAtollLTE,true);
            createBTSFile.insertDataToBtsFiles();
            System.out.println("Ok!");
            in.nextLine();

        } catch (SQLException | NullPointerException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            in.nextLine();
        }
    }
}

