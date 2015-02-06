package cook.tasks.cook;

import cook.core.Node;
import cook.data.Settings;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodContext;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.wrappers.interactive.Entity;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 9:40 PM
 */
public class Cook extends Node {

    public Cook(AbstractScript script) {
        super(script);
    }

    @Override
    public String status() {
        return "Cooking";
    }

    @Override
    public boolean validate() {
        if(!script.getLocalPlayer().isStandingStill()){
            return !MethodContext.sleepWhile(() ->
                            script.getInventory().contains(Settings.cookItemName) && script.getLocalPlayer().getAnimation() != -1, Calculations.random(25000, 30000));
        }
        return Settings.rangeArea.contains(script.getLocalPlayer());
    }

    @Override
    public void execute() {
        if(!script.getTabs().isOpen(Tab.INVENTORY))
            script.getTabs().open(Tab.INVENTORY);
        final Entity range = script.getGameObjects().closest(g -> g != null && (g.getName().equals("Range") || g.getName().equals("Clay oven") || g.getName().equals("Fire")));
        List<WidgetChild> children = getFoodChildren();
        if(children.isEmpty() && clickEntity(range)) {
            MethodContext.sleepUntil(() -> !getFoodChildren().isEmpty(), Calculations.random(1000, 1400));
            children = getFoodChildren();
        }
        if(!children.isEmpty()){
            if(!children.isEmpty()){
                WidgetChild first = children.get(0);
                if(first != null && first.interact("Cook All")) {
                    MethodContext.sleepWhile(() -> script.getLocalPlayer().getAnimation() != -1, Calculations.random(1000, 1400));
                }
            }
        }
    }

    public List<WidgetChild> getFoodChildren () {
        return script.getWidgets().getWidgets(w -> w != null && w.getText().contains(Settings.cookItemName));
    }

    private boolean clickEntity(Entity entity) {
        return script.getInventory().getItem(Settings.cookItemName).useOn(entity);
    }
}
