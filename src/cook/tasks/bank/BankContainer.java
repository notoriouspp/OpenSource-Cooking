package cook.tasks.bank;

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
public class BankContainer extends NodeContainer {

    public BankContainer(AbstractScript script, Node... n){
        super(script,n);
    }

    @Override
    public boolean activate() {
        return !script.getInventory().contains(Settings.cookItemName);
    }
}
