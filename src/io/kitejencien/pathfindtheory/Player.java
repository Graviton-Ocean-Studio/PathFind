package io.kitejencien.pathfindtheory;

import io.kitejencien.pathfindtheory.blocks.Block;

/**
 * the player of the system
 */
public class Player {

    private int x,y;
    private BlockMap map;

    public Player(int initX, int initY, BlockMap map){
        this.x = initX;
        this.y = initY;
        this.map = map;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Block getBlock(){
        return this.map.blocks[x][y];
    }

    public BlockMap getMap() {
        return map;
    }
}
