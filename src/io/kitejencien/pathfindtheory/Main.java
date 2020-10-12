package io.kitejencien.pathfindtheory;

public class Main {

    public static void main(String[] args) {

        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(5,5)
                .buildRandom(0.5,0.7)
                .build();
    }
}

