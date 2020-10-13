package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import com.daixuan.algorithms.bfsnavigator.BFSNavigator;
import io.kitejencien.pathfindtheory.navigate.AStarNavigator;
import io.kitejencien.pathfindtheory.visual.Frame;
import io.kitejencien.pathfindtheory.visual.Panel;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class Main {



    public Main() {
        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(256, 256)
                .buildRandom(0.4, 0.7)
                .build();

        Player player = new Player(0, 0, blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();

        player.setNavigator(new AStarNavigator());
        NavigationPath path = player.navigate(new Vector2i(240, 180));
        if (path == null) System.out.println("IMPOSSIBLE");
        else {
            frame.getPanel().registerRenderer(path::render);
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

