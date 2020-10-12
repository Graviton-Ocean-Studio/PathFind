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
                .setDimensions(50,50)
                .buildRandom(0.15,0.9)
                .build();

        Player player = new Player(0,0,blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();

        player.setNavigator(new BFSNavigator());
        NavigationPath path = player.navigate(new Vector2i(30,22));
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

