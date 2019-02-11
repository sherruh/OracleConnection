package Work;

public class CellsUMTS extends Cells {

    private final String system="UMTS";
    private String scrambling;
    private String lac;

    public CellsUMTS(String site, String latitude, String longitude, String cell,
                     String channel, String cid, String direction, String beam, String height,
                     String tilt,String scrambling,String lac) {
        super(site, latitude, longitude, cell, channel, cid, direction, beam, height, tilt);
        this.scrambling=scrambling;
        this.lac=lac;
    }

    @Override
    public String toString() {
        return "\n"+system+"\t"+super.toString()+scrambling+"\t"+lac;
    }
}
