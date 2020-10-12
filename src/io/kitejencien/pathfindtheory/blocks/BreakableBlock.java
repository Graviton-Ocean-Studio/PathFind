package io.kitejencien.pathfindtheory.blocks;

/**
 * the block the player can pass
 * but time is needed to break this block
 * @author KiteJencien
 */

public class BreakableBlock extends Block {

    public BreakableBlock(int x, int y){
        super(x,y);
        this.setCanPass(true);
        this.setTimeOnPass(5);
    }
}
