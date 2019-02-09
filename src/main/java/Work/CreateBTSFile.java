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
    private final String djName="DJ_";
    private final String oskName="Osk_";
    private final String btkName="Btk_";
    private final String[] technologies=new String[]{lteName,umtsName,gsmName};
    private final String[] regions=new String[]{chDName,ikName,nrnName,tlsName,djName,oskName,btkName};
    private String currentDate;
    private List<CellsGSM> cellsGSM;
    private Map<String, FileWriter> files;
    private FileWorker fileWorker;

    public CreateBTSFile(List<CellsGSM> cellsGSM) throws IOException {

        this.cellsGSM = cellsGSM;
        currentDate= new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        fileWorker=new FileWorker(technologies,regions,currentDate);
        files=fileWorker.getFiles();

    }

    public void insertDataToBtsFiles() throws IOException {

        for (CellsGSM cellGSM:cellsGSM){
            if(cellGSM.site.substring(5,10).equals("_ChD-")){
                files.get(gsmName+chDName).write(cellGSM.toString());
            }else if(cellGSM.site.substring(5,10).equals("_Bsk-")){
                files.get(gsmName+chDName).write(cellGSM.toString());
            }
        }
        fileWorker.closeFiles();

    }

}
