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

    public CellsDao(Connection con) {
        this.con = con;
    }

    public List<CellsGSM> getCellsGSM() throws SQLException {

        String query="select  u.TX_ID, u.site_name,u.DX,u.DY,u.height,u.azimut+a.electrical_azimuth as azimuth, u.utilization, " +
                "u.num_trx,u.lac,"+
                "u.launch_date,u.fband,s.latitude, s.longitude ,a.beamwidth,a.electrical_azimuth,a.electrical_tilt+u.tilt as tilt," +
                "a.name,u.azimut,u.status,u.ci "+
                "from NURTELECOM.Gtransmitters u , NURTELECOM.SITES s, NURTELECOM.ANTENNAS a "+
                "where s.name=u.site_name(+) "+
                "and u.antenna_name=a.name ";//TODO add channel(BCCH), bsic. Add where status=On-Air
        List<CellsGSM> cellsGSMList=new ArrayList<>();
        PreparedStatement statement= null;
        statement = this.con.prepareStatement(query);
        ResultSet rs=statement.executeQuery();
        System.out.println("Executed selecting GSM cells!");
        while (rs.next()){
            CellsGSM cellsGSM=new CellsGSM(rs.getString("site_name"),rs.getString("latitude"),
                    rs.getString("longitude"),getCellName(rs.getString("site_name"),rs.getString("TX_ID")),
                    rs.getString("channel"),rs.getString("ci"),rs.getString("azimuth"),
                    rs.getString("beamwidth"),rs.getString("height"),rs.getString("tilt"),
                    rs.getString("bsic"),rs.getString("lac"));
            cellsGSMList.add(cellsGSM);
        }
        rs.close();
        statement.close();
        return cellsGSMList;

    }

    private String getCellName(String site_name, String txId) {
        return site_name.substring(6)+"-"+txId.substring(5,7);
    }

}
