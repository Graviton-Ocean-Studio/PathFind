package io.kitejencien.pathfindtheory.navigate;

import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.Block;



/**
 * the node for the block
 * @author kiteJencien
 */
public class Node {

    private int _weight;
    private Block block;
    private Vector2i pos;


    public Node(int _weight, Block block){
        this._weight = _weight;
        this.block = block;
        this.pos = block.getPos();
    }

    public Vector2i getPos() {
        return pos;
    }

    public Block getBlock() {
        return block;
    }


    public int get_weight() {
        return _weight;
    }

    @Override
    public String toString() {
        return getPos() + " " + getBlock().getClass().getSimpleName();
    }
}
