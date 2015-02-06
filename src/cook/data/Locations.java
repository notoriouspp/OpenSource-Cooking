package cook.data;


/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 2/18/14
 * Time: 9:54 PM
 */
public enum Locations {

    AL_KHARID(Areas.AL_KHARID_RANGE, Areas.AL_KHARID_BANK),
    NARDAH(Areas.NARDAH_RANGE, Areas.NARDAH_BANK),
    ROUGES_DEN(Areas.ROUGES_DEN, Areas.ROUGES_DEN);

    private Areas rangeArea;
    private Areas bankArea;

    public Areas getRangeArea(){
        return rangeArea;
    }
    public Areas getBankArea(){
        return bankArea;
    }

    private Locations(Areas rangeArea, Areas bankArea){
        this.bankArea = bankArea;
        this.rangeArea = rangeArea;
    }

    @Override
    public String toString() {
        final String s = super.toString().replace('_', ' ');
        return s.charAt(0) + s.substring(1, s.length()).toLowerCase();
    }
}
