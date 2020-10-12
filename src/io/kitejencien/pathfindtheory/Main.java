package io.kitejencien.pathfindtheory;

import io.kitejencien.pathfindtheory.visual.Frame;

public class Main {

    public static void main(String[] args) {

        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(50,50)
                .buildRandom(0.2,0.6)
                .build();

        Player player = new Player(0,0,blockMap);

        Frame frame = new Frame(player);

    }
}

