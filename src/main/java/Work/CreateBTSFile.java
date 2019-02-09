package Work;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateBTSFile {

    private final String lteName="LTE_";
    private final String umtsName="UMTS_";
    private final String gsmName="GSM_";
    private final String chDName="ChDBsk_";
    private final String ikName="IK_";
    private final String nrnName="NrN_";
    private final String tlsName="Tls_";
    private final String djName="Dj_";
    private final String oskName="Osk_";
    private final String btkName="Btk_";
    private final String[] technologies=new String[]{lteName,umtsName,gsmName};
    private final String[] regions=new String[]{chDName,ikName,nrnName,tlsName,djName,oskName,btkName};
    private String currentDate;
    List<CellsGSM> cellsGSM;

    public CreateBTSFile(List<CellsGSM> cellsGSM) throws IOException {

        this.cellsGSM = cellsGSM;
        currentDate= new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        FileWorker fileWorker=new FileWorker(technologies,regions,currentDate);
        Map<String, FileWriter> files=fileWorker.getFiles();
        for (CellsGSM cellGSM:cellsGSM){
            files.get(gsmName+chDName).write(cellGSM.toString());
        }
        fileWorker.closeFiles();

    }


}
