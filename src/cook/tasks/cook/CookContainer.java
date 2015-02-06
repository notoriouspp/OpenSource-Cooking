package cook.tasks.cook;

import cook.core.Node;
import cook.core.NodeContainer;
import cook.data.Settings;
import org.dreambot.api.script.AbstractScript;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 9:33 PM
 */
public class CookContainer extends NodeContainer {

    public CookContainer(AbstractScript script, Node... n){
        super(script,n);
    }

    @Override
    public boolean activate() {
        return script.getInventory().contains(Settings.cookItemName);
    }
}
