package Work;

import java.sql.Connection;

public class CellsAtollDao extends CellsDao{

    public CellsAtollDao(Connection con) {
        super(con);
    }

    @Override
    protected String getCellName(String site_name, String txId) {
        if(txId.length()<7){
            System.out.println("Wrong Length: "+ txId);
        }
        return txId;
    }
}
