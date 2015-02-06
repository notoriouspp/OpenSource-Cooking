package cook.data;


import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 2/14/14
 * Time: 8:51 AM
 */
public enum  Areas {

    AL_KHARID_BANK(new Area(
            new Tile(3268, 3174, 0),
            new Tile(3272, 3174, 0),
            new Tile(3272, 3161, 0),
            new Tile(3268, 3161, 0)
    )),
    AL_KHARID_RANGE(new Area(
            new Tile(3270, 3179, 0),
            new Tile(3275, 3179, 0),
            new Tile(3275, 3183, 0),
            new Tile(3270, 3183, 0)
    )),
    NARDAH_RANGE(new Area(
            new Tile(3431,2888,0),
            new Tile(3431,2883,0),
            new Tile(3437,2883,0),
            new Tile(3437,2888,0)
    )),
    NARDAH_BANK(new Area(
            new Tile(3427,2888,0),
            new Tile(3427,2895,0),
            new Tile(3430,2895,0),
            new Tile(3430,2888,0)
    )),
    ROUGES_DEN(new Area(
            new Tile(3039,4965,1),
            new Tile(3053,4965,1),
            new Tile(3053,4979,1),
            new Tile(3039,4979,1)
    ));

    Area a;

    public Area getArea(){
        return a;
    }

    private Areas(Area a){
        this.a = a;
    }
}
