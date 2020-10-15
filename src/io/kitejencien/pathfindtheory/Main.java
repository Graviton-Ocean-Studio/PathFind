package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import com.daixuan.algorithms.bfsnavigator.BFSNavigator;
import io.kitejencien.pathfindtheory.navigate.AStarNavigator;
import io.kitejencien.pathfindtheory.visual.Frame;
import io.kitejencien.pathfindtheory.visual.Panel;

public class Main {

    public Main() throws InterruptedException{
        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(80, 40)
                .buildRandom(0.3, 0.7)
                .build();

        blockMap.setGoal(78, 38);


        Player player = new Player(0, 0, blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();

        player.setNavigator(new AStarNavigator());

        NavigationPath path = player.navigate(new Vector2i(78, 38));
        if (path == null){ System.out.println("IMPOSSIBLE"); }
        else {
            frame.getPanel().registerRenderer(path::render);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Main();
    }
}
