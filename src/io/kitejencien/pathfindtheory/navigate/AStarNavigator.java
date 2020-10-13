package io.kitejencien.pathfindtheory.navigate;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.Block;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * a version of the navigator created by kitejencien
 * @author KiteJencien
 */
public class AStarNavigator implements IPlayerNavigator {

    private BlockMap blockMap;

    private LinkedList<Node> closedList;
    private LinkedList<Node> openList;

    private ArrayList<NavigationMovement> movements;

    private Block searchCenter;

    @Override
    public void loadMap(BlockMap blockMap) {
        this.blockMap = blockMap;
        this.closedList = new LinkedList<>();
        this.openList = new LinkedList<>();
    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {

    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        return null;
    }
}
