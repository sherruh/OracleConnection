package Work;

public class CellsLTE extends Cells {

    private final String system="LTE";
    private String pci;
    private String tac;

    public CellsLTE(String site, String latitude, String longitude, String cell,
                    String channel, String cid, String direction, String beam,
                    String height, String tilt,String pci,String tac) {
        super(site, latitude, longitude, cell, channel, cid, direction, beam, height, tilt);
        this.pci=pci;
        this.tac=tac;
    }

    @Override
    public String toString() {
        return "\n"+system+"\t"+super.toString()+pci+"\t"+tac;
    }
}
