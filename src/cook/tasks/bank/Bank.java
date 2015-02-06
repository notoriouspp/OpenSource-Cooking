package cook.tasks.bank;

import cook.core.Node;
import cook.data.Settings;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.container.ItemContainer;
import org.dreambot.api.script.AbstractScript;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 9:40 PM
 */
public class Bank extends Node {

    public Bank(AbstractScript script) {
        super(script);
    }

    @Override
    public boolean validate(){
        return Settings.bankArea.contains(script.getLocalPlayer());
    }

    @Override
    public String status() {
        return "Banking";
    }
    @Override
    public void execute() {
        ItemContainer container = script.getItemContainer();
        if(container.getBank().open()){
            if(!container.getInventory().isEmpty()){
                if(container.getBank().depositAllItems()){
                    MethodContext.sleepWhile(container.getInventory()::isEmpty, (int)Calculations.gRandom(800, 300));
                }
            }
            if(!container.getInventory().isFull()){
                if(container.getBank().contains(Settings.cookItemName)){
                    if(container.getBank().withdrawAll(container.getBank().get(Settings.cookItemName).getID())){
                        MethodContext.sleepUntil(() -> container.getInventory().contains(Settings.cookItemName), (int) Calculations.gRandom(800, 300));
                    }
                } else {
                    container.getBank().close();
                    MethodContext.log("No more food in bank! Stopping in 10 seconds...");
                    long wait = System.currentTimeMillis() + 10000L;
                    while(wait > System.currentTimeMillis()){
                        MethodContext.sleep(40);
                    }
                    script.stop();
                }
            }
            if(container.getInventory().contains(Settings.cookItemName)){
                if(container.getBank().close()){
                    MethodContext.sleepWhile(container.getBank()::isOpen, (int)Calculations.gRandom(800, 300));
                }
            }
        }
    }
}
