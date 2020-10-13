package io.kitejencien.pathfindtheory.navigate;

import io.kitejencien.pathfindtheory.blocks.Block;

/**
 * the node for the block
 * @author kiteJencien
 */
public class Node {

    private int _weight;
    private Block block;

    public Node(int _weight, Block block){
        this._weight = _weight;
        this.block = block;
    }
}
