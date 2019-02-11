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
        List<Cells> cellsGSM;
        List<Cells> cellsUMTS;
        List<Cells> cellsLTE;

        try {

            con=new MyOracleConnection().getCon();
            cellsDao=new CellsDao(con);
            cellsGSM=cellsDao.getCellsGSM();
            cellsUMTS=cellsDao.getCellsUMTS();
            cellsLTE=cellsDao.getCellsLTE();
            con.close();
            CreateBTSFile createBTSFile= new CreateBTSFile(cellsGSM,cellsUMTS,cellsLTE);
            createBTSFile.insertDataToBtsFiles();
            System.out.println("Ok!");
            in.nextLine();

        } catch (SQLException | NullPointerException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            in.nextLine();
        }
    }
}

