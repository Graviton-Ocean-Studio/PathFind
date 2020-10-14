package com.daixuan.algorithms.bfsnavigator;

import io.kitejencien.pathfindtheory.Vector2i;

/**
 * @author QueueHuo
 */
public class BFSNavigationNodeMap {

    public boolean[][] isVisited;
    public Vector2i[][] from;

    public BFSNavigationNodeMap(int xl, int yl) {
        isVisited = new boolean[xl][yl];
        from = new Vector2i[xl][yl];
        for(int i = 0; i < xl; i++) {
            from[i] = new Vector2i[yl];
            isVisited[i] = new boolean[yl];
            for (int j = 0; j < yl; j++) {
                from[i][j] = new Vector2i(i,j);
                isVisited[i][j] = false;
            }
        }
    }
}
