package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.visual.Frame;
import io.kitejencien.pathfindtheory.visual.Panel;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class Main {

    final NavigationMovement up = (e) -> e.add(0,-1);
    final NavigationMovement down = (e) -> e.add(0,1);
    final NavigationMovement right = (e) -> e.add(1,0);
    final NavigationMovement left = (e) -> e.add(-1,0);
    final NavigationMovement upLeft = (e) -> e.add(-1,-1);
    final NavigationMovement upRight = (e) -> e.add(1,-1);
    final NavigationMovement downLeft = (e) -> e.add(-1,1);
    final NavigationMovement downRight = (e) -> e.add(1,1);

    public Main() {
        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(50,50)
                .buildRandom(0.2,0.6)
                .build();

        Player player = new Player(0,0,blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();
        NavigationPath navigationPath = new NavigationPath(player.getPosition(), new NavigationMovement[]{down,down,down,right,down, right,downRight, upRight, right, down, right}, frame.getBlockSize());

        p.registerRenderer(navigationPath::render);
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

