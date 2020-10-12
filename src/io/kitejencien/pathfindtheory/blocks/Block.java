package io.kitejencien.pathfindtheory.blocks;

/**
 * every cell in the pathfind graph
 */
public class Block {

    private int timeOnPass;
    private boolean canPass;
    private int x;
    private int y;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
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
}
