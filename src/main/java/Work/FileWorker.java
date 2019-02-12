package Work;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileWorker {

    private String[] technologies;
    private String[] regions;
    private String gsmHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tCID\tDIR\tBEAM\tHEIGHT\tTILT\tBSIC\tLAC";
    private String umtsHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tCID\tDIR\tBEAM\tHEIGHT\tTILT\tSCR\tLAC";
    private String lteHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tCID\tDIR\tBEAM\tHEIGHT\tTILT\tPCI\tTAC";
    private HashMap<String,FileWriter> files;
    private String resultFolder;

    public FileWorker(String[] technologies, String[] regions, String currentDate) throws IOException {
        this.technologies=technologies;
        this.regions=regions;
        files=new HashMap<>();
        resultFolder="BTS files "+currentDate;
        File file = new File(resultFolder);
        file.mkdir();
        for(String technology:technologies){
            for(String region:regions){
                files.put(technology+region,new FileWriter( resultFolder+"\\"+ technology+region+currentDate+".nbf"));
                String head="";
                switch (technology){
                    case "GSM_":
                        head=gsmHead;
                        break;
                    case  "UMTS_":
                        head=umtsHead;
                        break;
                    case "LTE_":
                        head=lteHead;
                        break;
                }
                files.get(technology+region).write(head);
            }
        }
    }

    public HashMap<String,FileWriter> getFiles(){
        return files;
    }

    public void closeFiles() throws IOException {
        for(String technology:technologies){
            for(String region:regions){
                files.get(technology+region).close();
            }
        }
    }
}
