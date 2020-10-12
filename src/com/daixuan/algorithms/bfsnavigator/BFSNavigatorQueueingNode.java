package com.daixuan.algorithms.bfsnavigator;

import io.kitejencien.pathfindtheory.Vector2i;

import java.util.Comparator;

public class BFSNavigatorQueueingNode implements Comparable<BFSNavigatorQueueingNode> {
    public int currentCost;
    public Vector2i position;
    public BFSNavigatorQueueingNode(Vector2i position, int currentCost) {
        this.position = position;
        this.currentCost = currentCost;
    }

    @Override
    public int compareTo(BFSNavigatorQueueingNode o) {
        return this.currentCost - o.currentCost;
    }
}
