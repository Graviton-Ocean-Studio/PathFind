package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import com.daixuan.algorithms.bfsnavigator.BFSNavigator;
import io.kitejencien.pathfindtheory.visual.Frame;
import io.kitejencien.pathfindtheory.visual.Panel;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class Main {



    public Main() {
        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(256,256)
                .buildRandom(0.996,0.9, "some other stuff")
                .build();

        Player player = new Player(0,0,blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();

        player.setNavigator(new BFSNavigator());
        NavigationPath path = player.navigate(new Vector2i(130,130));
        if(path == null) System.out.println("IMPOSSIBLE");
        else {
            frame.getPanel().registerRenderer(path::render);
        }
        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                frame.getPanel().repaint();
            }
        }, 0, 1000 / 144);

    }

    public static void main(String[] args) {
        new Main();
    }
}

