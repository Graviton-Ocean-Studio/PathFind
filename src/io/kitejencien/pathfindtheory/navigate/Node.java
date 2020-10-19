package io.kitejencien.pathfindtheory.navigate;

import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.Block;



/**
 * the node for the block
 * @author kiteJencien
 */
public class Node {

    private double _weight;
    private Block block;
    private Vector2i pos;


    public Node(double _weight, Block block){
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


    public double get_weight() {
        return _weight;
    }

    @Override
    public String toString() {
        return getPos() + " " + getBlock().getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object obj) {
        return this.getBlock().equals(((Node)obj).getBlock()) && this.getPos().equals(((Node)obj).getPos());
    }
}
