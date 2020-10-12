package io.kitejencien.pathfindtheory;

import io.kitejencien.pathfindtheory.blocks.Block;

/**
 * the player of the system
 */
public class Player {

    private Vector2i position;

    private BlockMap map;

    public Player(int initX, int initY, BlockMap map){
        this.position = new Vector2i(initX, initY);
        this.map = map;
    }
    public boolean moveTo(Vector2i newPosition) {
        if(newPosition.getX() < 0 || newPosition.getX() >= map.xl) return false;
        if(newPosition.getY() < 0 || newPosition.getY() >= map.yl) return false;
        this.position.set(newPosition);
        return true;

    }
    public Vector2i getPosition() {return position;}
    public Block getBlock(){
        return this.map.blocks[this.position.getX()][this.position.getY()];
    }

    public BlockMap getMap() {
        return map;
    }
}
