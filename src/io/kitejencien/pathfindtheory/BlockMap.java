package io.kitejencien.pathfindtheory;


import io.kitejencien.pathfindtheory.blocks.Block;
import io.kitejencien.pathfindtheory.blocks.GoalBlock;

/**
 * the map for the path finder
 * @author KiteJencien
 */
public class BlockMap {

    public Block[][] blocks;
    public int xl;
    public int yl;

    public Block[][] getBlocks() {
        return blocks;
    }

    //get the block on the cord
    public Block getBlock(int x, int y){

        if(x >= 0 && y>= 0 && x < getBlocks().length && y < getBlocks()[0].length){
             return blocks[x][y];
        }
        return null;
    }

    public Block getBlock(Vector2i pos){
        return getBlock(pos.getX(),pos.getY());
    }

    public void setGoal(int x, int y){
        blocks[x][y] = new GoalBlock(x,y);
    }
}
