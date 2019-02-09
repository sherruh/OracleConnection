package Work;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWorker {

    private String[] technologies;
    private String[] regions;
    private String gsmHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tBSIC\tCID\tLAC\tDIR\tBEAM\tHEIGHT\tTILT";
    private String umtsHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tCID\tSCR\tDIR\tBEAM\tHEIGHT\tTILT";//TODO add lac
    private String lteHead="SYSTEM\tSITE\tLAT\tLON\tCELL\tCH\tCID\tPCI\tDIR\tBEAM\tHEIGHT\tTILT";//TODO add tac
    private HashMap<String,FileWriter> files;

    public FileWorker(String[] technologies, String[] regions, String currentDate) throws IOException {
        this.technologies=technologies;
        this.regions=regions;
        files=new HashMap<>();
        for(String technology:technologies){
            for(String region:regions){
                files.put(technology+region,new FileWriter(technology+region+currentDate+".nbf"));
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
