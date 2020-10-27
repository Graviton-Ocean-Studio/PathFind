package io.kitejencien.pathfindtheory;

//import com.daixuan.algorithms.Noise;
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
    static final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

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
                if(rd.nextDouble()>barrier){
                    this.blockMap.blocks[i][j] = new BarrierBlock(i,j);
                }
                else if(rd.nextDouble() > breakable){
                    this.blockMap.blocks[i][j] = new BreakableBlock(i,j);
                }else {
                    this.blockMap.blocks[i][j] = new Block(i,j);
                }
            }
        }

        return this;
    }

    public static int[][] generateBetter(Vector2i size) {
        int fx,fy;
        float cumulative;
        int[][] map = generateRandom(size, 0.52f);
        for(int i = 0; i < size.getX(); i++) {
            for(int j = 0; j < size.getY(); j++) {
                cumulative = map[i][j];
                for(int k = 0; k < 8; k++) {
                    fx = i + directions[k][0];
                    fy = j + directions[k][1];

                    fx = fx >= size.getX() ? size.getX() - 1 : fx;
                    fx = fx < 0 ? 0 : fx;

                    fy = fy >= size.getY() ? size.getY() - 1 : fy;
                    fy = fy < 0 ? 0 : fy;

                    cumulative += map[fx][fy];
                }
                map[i][j] = cumulative > 4 ? 1 : 0;
            }
        }
        return map;
    }

    public static int[][] generateRandom(Vector2i size, float prob) {
        int[][] map = new int[size.getX()][size.getY()];
        for(int i = 0; i < size.getX(); i++) {
            for(int j = 0; j < size.getY(); j++) {
                map[i][j] = Math.random() > prob ? 1 : 0;
            }
        }
        return map;
    }

    public BlockMapBuilder buildCaves(){
        int[][] map = generateBetter(new Vector2i(blockMap.xl,blockMap.yl));
        for(int i = 0; i < blockMap.blocks.length; i++){
            for(int j = 0; j < blockMap.blocks[0].length; j++){
                if(map[i][j] ==1 ) blockMap.blocks[i][j] = new BreakableBlock(i,j);
                else blockMap.blocks[i][j] = new Block(i,j);
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
