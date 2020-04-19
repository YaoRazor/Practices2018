package ninechapter;


import java.util.ArrayList;

public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
};
