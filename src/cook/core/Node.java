package cook.core;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 8:09 PM
 */
 
public abstract class Node {

	//Script instance to use inside of your workers
    public AbstractScript script;
	//Default Constructor
    public Node(AbstractScript script){
        this.script = script;
    }

	//Dynamic sleep
    public int delay() {
        return (int)Calculations.gRandom(500, 100);
    }

    public String status(){
        return "";
    }
    public int priority(){
        return 0;
    }
	//Abstract methods
    public abstract boolean validate();
    public abstract void execute();
}
