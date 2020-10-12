package io.kitejencien.pathfindtheory.blocks;

/**
 * the barrier block, the player can't pass this
 * @author KiteJencien
 */

public class BarrierBlock extends Block {

    public BarrierBlock(int x, int y){

        super(x, y);
        this.setTimeOnPass(-1);
        this.setCanPass(false);

    }
}
