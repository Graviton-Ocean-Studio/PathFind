package io.kitejencien.pathfindtheory.navigate;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;

/**
 * the A* navigator with the 4-block-radius scanning region and allows 3-block jump
 * @author KiteJencien
 */
public class SprintMapNavigator implements IPlayerNavigator {
    @Override
    public void loadMap(BlockMap blockMap) {

    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {

    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        return null;
    }
}
