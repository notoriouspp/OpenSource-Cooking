package cook.tasks.bank;

import cook.core.Node;
import cook.data.Settings;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodProvider;
import org.dreambot.api.script.AbstractScript;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 9:40 PM
 */
public class WalkBank extends Node {

    public WalkBank(AbstractScript script) {
        super(script);
    }

    @Override
    public String status() {
        return "Walking";
    }
    @Override
    public boolean validate(){
        return !Settings.bankArea.contains(script.getLocalPlayer());
    }

    @Override
    public void execute() {
        if(script.getWalking().walk(Settings.bankArea.getRandomTile())) {
            MethodProvider.sleepWhile(() -> script.getLocalPlayer().isMoving(), (int)Calculations.gRandom(600, 200));
            MethodProvider.sleep((int) Calculations.gRandom(500, 100)); //Default reaction time.
        }
    }
}
