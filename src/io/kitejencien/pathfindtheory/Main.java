package io.kitejencien.pathfindtheory;

import io.kitejencien.pathfindtheory.visual.Frame;

public class Main {

    public static void main(String[] args) {

        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(30,30)
                .buildRandom(0.55,0.9)
                .build();

        Player player = new Player(0,0,blockMap);

        Frame frame = new Frame(player);

    }
}

