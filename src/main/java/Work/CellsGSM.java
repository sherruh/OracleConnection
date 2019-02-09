package Work;

public class CellsGSM extends Cells{

    private final String system="GSM";
    private String bsic;
    private String lac;

    public CellsGSM(String site, String latitude, String longitude,
                    String cell, String channel, String cid, String direction,
                    String beam, String height, String tilt,String bsic,String lac) {
        super(site, latitude, longitude, cell, channel, cid, direction, beam, height, tilt);
        this.bsic=bsic;
        this.lac=lac;
    }

    @Override
    public String toString() {
        return "\n"+system+"\t"+super.toString()+bsic+"\t"+lac;
    }

}
