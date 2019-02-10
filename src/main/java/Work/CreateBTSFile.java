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

        insertGSM();
        fileWorker.closeFiles();

    }

    private void insertGSM() throws IOException {
        for (CellsGSM cellGSM:cellsGSM){

            switch(cellGSM.site.substring(5,10)){
                case "_ChD-":
                    files.get(gsmName+chDName).write(cellGSM.toString());
                    break;
                case "_Bsk-":
                    files.get(gsmName+chDName).write(cellGSM.toString());
                    break;
                case "_IsK-":
                    files.get(gsmName+ikName).write(cellGSM.toString());
                    break;
                case "_NrN-":
                    files.get(gsmName+nrnName).write(cellGSM.toString());
                    break;
                case "_Tls-":
                    files.get(gsmName+tlsName).write(cellGSM.toString());
                    break;
                case "_Djk-":
                    files.get(gsmName+djName).write(cellGSM.toString());
                    break;
                case "_DjA-":
                    files.get(gsmName+djName).write(cellGSM.toString());
                    break;
                case "_Osk-":
                    files.get(gsmName+oskName).write(cellGSM.toString());
                    break;
                case "_Osh-":
                    files.get(gsmName+oskName).write(cellGSM.toString());
                    break;
                case "_Btk-":
                    files.get(gsmName+btkName).write(cellGSM.toString());
                    break;
                default:
                    System.out.println(cellGSM);
                    break;
            }
            //if(cellGSM.site.substring(5,10).equals("_ChD-")){
            //    files.get(gsmName+chDName).write(cellGSM.toString());
            //}else if(cellGSM.site.substring(5,10).equals("_Bsk-")){
            //    files.get(gsmName+chDName).write(cellGSM.toString());
            //}
            System.out.println("GSM cell inserted!");
        }
    }

}
