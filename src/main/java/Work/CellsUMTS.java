package Work;

public class CellsUMTS extends Cells {

    private final String system="UMTS";
    private String scrambling;

    public CellsUMTS(String site, String latitude, String longitude, String cell,
                     String channel, String cid, String direction, String beam, String height,
                     String tilt,String scrambling) {
        super(site, latitude, longitude, cell, channel, cid, direction, beam, height, tilt);
        this.scrambling=scrambling;
    }

    @Override
    public String toString() {
        return system+"\t"+super.toString()+scrambling;
    }
}
