package cook.core;

import cook.gui.StartFrame;
import cook.tasks.bank.Bank;
import cook.tasks.bank.BankContainer;
import cook.tasks.bank.WalkBank;
import cook.tasks.cook.Cook;
import cook.tasks.cook.CookContainer;
import cook.tasks.cook.WalkRange;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.widgets.message.Message;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 9:01 PM
 */

@ScriptManifest(name = "Open Dream Cooking", author = "Notorious", version = 1D, description="Cook while you dream!", category = Category.COOKING)

public class MyScript extends AbstractScript {

	//Create list to store container
    private final List<NodeContainer> nodeContainer = new ArrayList<>();

    private final Color color1 = new Color(51, 51, 51, 147);
    private final Color color2 = new Color(0, 233, 165);
    private final Color color3 = new Color(255, 255, 255);

    private final BasicStroke stroke1 = new BasicStroke(5);

    private final Font font1 = new Font("Century Gothic", 0, 24);
    private final Font font2 = new Font("Century Gothic", 0, 12);
    private final Font font3 = new Font("Century Gothic", 0, 16);

    private Timer timer;
    private int cooked = 0, burned = 0;
    private String status = "";
    StartFrame startFrame;

    @Override
    public void onStart() {
        getSkillTracker().start(Skill.COOKING);
        startFrame = new StartFrame();
        while(startFrame.isVisible()){
           sleep(40);
        }
		//Store workers with the companies you wish them to be in, along with a script instance to use.
        Collections.addAll(nodeContainer,
                new CookContainer(this, new Cook(this), new WalkRange(this)),
                new BankContainer(this, new Bank(this), new WalkBank(this)));
    }

    @Override
    public void onMessage(Message message) {
        super.onMessage(message);
        if(message.getMessage() != null && (message.getMessage().toLowerCase().contains("you roast") || message.getMessage().toLowerCase().contains("you successfully"))){
            cooked++;
        }
        else if(message.getMessage() != null && message.getMessage().toLowerCase().contains("burn")){
            burned++;
        }
    }

    @Override
    public int onLoop() {
            for(NodeContainer container : nodeContainer) {
            if (container.activate()) {
                Node w = container.get();
                    if(w != null){
                        status = w.status();
                        w.execute();
                        return w.delay();
                    }
                }
            }
        return (int)Calculations.gRandom(500, 150);
    }
    public void onPaint(Graphics g1) {
        if(timer == null){
            timer = new Timer(0);
        }
        Graphics2D g = (Graphics2D)g1;
        Stroke stroke = g.getStroke();
        g.setColor(color1);
        g.fillRect(3, 4, 199, 159);
        g.setColor(color2);
        g.setStroke(stroke1);
        g.drawRect(3, 4, 199, 159);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString(getManifest().name(), 554, 465);
        g.setFont(font2);
        g.drawString("v" + getManifest().version(), 710, 465);
        g.setFont(font3);
        g.drawString("Timer: " + Timer.formatTime(timer.elapsed()), 9, 29);
        g.drawString("Status: " + status, 8, 49);
        g.drawString("Cooked: " + cooked, 7, 70);
        g.drawString("Burned: " + burned, 7, 91);
        g.drawString("Exp: " + getSkillTracker().getGainedExperience(Skill.COOKING), 7, 112);
        g.drawString("Exp/Hr: " + getSkillTracker().getGainedExperiencePerHour(Skill.COOKING), 8, 134);
        g.drawString("Levels: " + getSkillTracker().getGainedLevels(Skill.COOKING), 7, 153);
        g.setStroke(stroke);


    }

}
