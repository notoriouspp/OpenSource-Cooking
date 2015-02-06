package cook.core;

import org.dreambot.api.script.AbstractScript;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: NotoriousPP
 * Date: 12/20/13
 * Time: 8:09 PM
 */

public abstract class NodeContainer implements Comparator<Node> {

	//Workers and Script instance variables
    public List<Node> nodeList = new ArrayList<Node>();
	public AbstractScript script;

	//Default Constructor
    public NodeContainer(AbstractScript script, Node... workerList) {
        this.script = script;
        submit(workerList);
    }
    //Summits the array into a sorted list
    public void submit(final Node... workers) {
        for (Node w : workers) {
            if (!nodeList.contains(w)) {
                nodeList.add(w);
            }
        }
        Collections.sort(nodeList, this);
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o2.priority() - o1.priority();
    }

    public void clear() {
        nodeList.clear();
    }
    //Grabs appropriate worker for current situation
    public Node get() {
        for (Node n : nodeList) {
            if (n.validate()) {
                return n;
            }
        }
        return null;
    }


        //Abstract methods
    public abstract boolean activate();

}
