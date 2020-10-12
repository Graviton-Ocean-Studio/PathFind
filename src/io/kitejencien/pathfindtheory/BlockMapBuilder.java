package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.Noise;
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
    public BlockMapBuilder buildRandom(double breakable, double barrier, String seed){

        Random rd = new Random();

        for(int i = 0; i < blockMap.blocks.length; i++){
            System.out.println();
            for(int j = 0; j < blockMap.blocks[0].length; j++){
                double noise = Noise.noise((double)i * 2.0 / this.blockMap.xl,(double)j * 2.0 /this.blockMap.yl) * 10;
                System.out.print(""+noise+'\t');
                if(noise < -0.707 + 0.4 * 0.707){
                    this.blockMap.blocks[i][j] = new BarrierBlock(i,j);

                }
                else if(noise < -0.707 + 0.5 * 0.707){
                    this.blockMap.blocks[i][j] = new BreakableBlock(i,j);

                }else {
                    this.blockMap.blocks[i][j] = new Block(i,j);
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
