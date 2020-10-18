package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import com.daixuan.algorithms.bfsnavigator.BFSNavigator;
import io.kitejencien.pathfindtheory.navigate.AStarNavigator;
import io.kitejencien.pathfindtheory.navigate.DualAStarNavigator;
import io.kitejencien.pathfindtheory.visual.Frame;
import io.kitejencien.pathfindtheory.visual.Panel;

public class Main {

    public Main() throws InterruptedException{
        BlockMap blockMap = new BlockMapBuilder()
                .setDimensions(80, 40)
                .buildRandom(1, 1)
                .build();

        blockMap.setGoal(76, 32);


        Player player = new Player(0, 0, blockMap);

        Frame frame = new Frame(player);

        Panel p = frame.getPanel();

        player.setNavigator(new AStarNavigator());

        NavigationPath path = player.navigate(new Vector2i(76, 32));
        if (path == null){ System.out.println("IMPOSSIBLE"); }
        else {
            frame.getPanel().registerRenderer(path::render);
            double time = 0;
            Vector2i current = new Vector2i(0,0);
            System.out.println("\n");
            for(NavigationMovement movement: path.get_movements()){
                Vector2i next = movement.nextPosition(current);
                System.out.printf("[%s : %s] ->",current , next);
                time += blockMap.getBlock(next).getTimeOnPass() * current.distanceTo(next);
                current = next;
            }
            System.out.println("\n FINAL TIME ON PASS : " + time);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Main();
    }
}
