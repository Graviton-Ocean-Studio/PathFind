package io.kitejencien.pathfindtheory;

import io.kitejencien.pathfindtheory.blocks.BarrierBlock;
import io.kitejencien.pathfindtheory.blocks.Block;
import io.kitejencien.pathfindtheory.blocks.BreakableBlock;

import java.util.Random;

/**
 * a builder to initialize a blockMap
 * @author KiteJencien
 */
public class BlockMapBuilder {

    private BlockMap blockMap;

    public BlockMapBuilder(){
        this.blockMap = new BlockMap();
    }

    //to initialize the dimensions
    public BlockMapBuilder setDimensions(int xRange, int yRange){
        this.blockMap.blocks = new Block[xRange][yRange];
        this.blockMap.xl = xRange;
        this.blockMap.yl = yRange;
        return this;
    }

    //initialize a random map
    public BlockMapBuilder buildRandom(double breakable, double barrier){

        Random rd = new Random();

        for(int i = 0; i < blockMap.blocks.length; i++){
            for(int j = 0; j < blockMap.blocks[0].length; j++){

                if(rd.nextDouble() < breakable){
                    this.blockMap.blocks[i][j] = new Block(i,j);
                }
                else if(rd.nextDouble() > barrier){
                    this.blockMap.blocks[i][j] = new BarrierBlock(i,j);
                }else {
                    this.blockMap.blocks[i][j] = new BreakableBlock(i,j);
                }
            }
        }

        return this;
    }

    public BlockMap build(){
        if(blockMap.blocks != null)
        return this.blockMap;
        else {
            System.out.println("ERROR: NULL BLOCKS");
            return null;
        }
    }
}
