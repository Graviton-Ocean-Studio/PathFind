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
    public void moveTo(Vector2i newPosition) {
        this.position.set(newPosition);

    }
    public Block getBlock(){
        return this.map.blocks[this.position.getX()][this.position.getY()];
    }

    public BlockMap getMap() {
        return map;
    }
}
