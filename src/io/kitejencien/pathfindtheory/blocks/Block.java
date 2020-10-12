package io.kitejencien.pathfindtheory.blocks;

import io.kitejencien.pathfindtheory.Vector2i;

/**
 * every cell in the pathfind graph
 */
public class Block {

    private int timeOnPass;
    private boolean canPass;
    private boolean visited = false;
    private boolean visiting = false;
    private Vector2i pos;
    private int x;
    private int y;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
        this.pos = new Vector2i(x,y);
        this.timeOnPass  =1;
        this.canPass = true;
    }

    public int getTimeOnPass() {
        return timeOnPass;
    }

    public boolean isCanPass() {
        return canPass;
    }

    public void setTimeOnPass(int timeOnPass) {
        this.timeOnPass = timeOnPass;
    }

    public void setCanPass(boolean canPass) {
        this.canPass = canPass;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isVisiting() {
        return visiting;
    }

    public Vector2i getPos() {
        return pos;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
