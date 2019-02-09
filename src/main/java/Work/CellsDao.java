package Work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CellsDao {

    private Connection con;
    private Scanner in;

    public CellsDao(Connection con) {
        this.con = con;
        in=new Scanner(System.in);
    }

    public List<CellsGSM> findAll() throws SQLException {

        String query="select id,name,country_id from city";//TODO select
        List<CellsGSM> cellsGSMList=new ArrayList<>();
        PreparedStatement statement= null;
        statement = this.con.prepareStatement(query);
        ResultSet rs=statement.executeQuery();
        System.out.println("Executed selecting GSM cells!");
        while (rs.next()){
            CellsGSM cellsGSM=new CellsGSM(rs.getInt("id"),rs.getString("name"),rs.getInt("country_id"));//TODO fields
            cellsGSMList.add(cellsGSM);
        }
        rs.close();
        statement.close();
        return cellsGSMList;

    }

}
