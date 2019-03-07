package Work;

public abstract class Cells {
    protected String site;
    protected String latitude;
    protected String longitude;
    protected String cell;
    protected String channel;
    protected String cid;
    protected String direction;
    protected String beam;
    protected String height;
    protected String tilt;

    public Cells(String site, String latitude, String longitude,
                 String cell, String channel, String cid, String direction,
                 String beam, String height, String tilt) {
        this.site = site;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cell = cell;
        this.channel = channel;
        this.cid = cid;
        this.direction = direction;
        this.beam = roundValue(beam);
        this.height = roundValue(height);
        this.tilt = tilt;
    }

    String roundValue(String value){
        String roundedValue;
        if(value!=null && value!=""){
            roundedValue=String.valueOf((int)Math.round(Double.parseDouble(height)));
        }else{
            return value;
        }
        return roundedValue;
    }

    @Override
    public String toString() {
        return (site+"\t"+latitude+"\t"+longitude+"\t"+cell+"\t"+channel+"\t"+cid+"\t"+
                direction+"\t"+beam+"\t"+height+"\t"+tilt+"\t");
    }
}
