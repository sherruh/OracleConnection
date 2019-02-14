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
    private List<Cells> cellsGSM ;
    private List<Cells> cellsUMTS;
    private List<Cells> cellsLTE;
    private Map<String, FileWriter> files;
    private FileWorker fileWorker;

    public CreateBTSFile(List<Cells> cellsGSM,List<Cells> cellsUMTS,List<Cells> cellsLTE,boolean atoll) throws IOException {

        this.cellsGSM = cellsGSM;
        this.cellsUMTS=cellsUMTS;
        this.cellsLTE=cellsLTE;
        currentDate= new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        fileWorker=new FileWorker(technologies,regions,currentDate,atoll);
        files=fileWorker.getFiles();

    }

    public void insertDataToBtsFiles() throws IOException {

        insert(gsmName,cellsGSM);
        insert(umtsName,cellsUMTS);
        insert(lteName,cellsLTE);
        fileWorker.closeFiles();

    }

    private void insert(String region,List<Cells> cells) throws IOException {

        if (cells!=null){

            for (Cells cell:cells){

                switch(cell.site.substring(5,10)){
                    case "_ChD-":
                        files.get(region+chDName).write(cell.toString());
                        break;
                    case "_Bsk-":
                        files.get(region+chDName).write(cell.toString());
                        break;
                    case "_IsK-":
                        files.get(region+ikName).write(cell.toString());
                        break;
                    case "_NrN-":
                        files.get(region+nrnName).write(cell.toString());
                        break;
                    case "_Tls-":
                        files.get(region+tlsName).write(cell.toString());
                        break;
                    case "_Djk-":
                        files.get(region+djName).write(cell.toString());
                        break;
                    case "_DjA-":
                        files.get(region+djName).write(cell.toString());
                        break;
                    case "_Osk-":
                        files.get(region+oskName).write(cell.toString());
                        break;
                    case "_Osh-":
                        files.get(region+oskName).write(cell.toString());
                        break;
                    case "_Btk-":
                        files.get(region+btkName).write(cell.toString());
                        break;
                    default:
                        System.out.println(cell);
                        break;

                }

            }
            System.out.println(cells.get(0).toString().substring(0,cells.get(0).toString().indexOf("\t"))+ " cells inserted!");

        }else{
            System.out.println( "Cells is null!");
        }

    }
}
