package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Player;
import io.kitejencien.pathfindtheory.*;

public interface IPlayerNavigator {
    public void loadMap(BlockMap blockMap);
    public void loadMovements(NavigationMovement[] movements);
    public NavigationPath find(Vector2i from, Vector2i to);

}
