package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.*;

/**
 * the template for the Player Navigator
 * @author QueueHuo
 */
public interface IPlayerNavigator {
    /**
     * load the maps needed for the navigation
     * @param blockMap the original blockMap
     * @see BlockMap
     */
     void loadMap(BlockMap blockMap);

    /**
     * load the basic movements the player is allowed to do
     * @param movements template for movements
     */
     void loadMovements(NavigationMovement[] movements);

    /**
     * find the path
     * @param from the start
     * @param to the end
     * @return the NavigationPath
     */
     NavigationPath find(Vector2i from, Vector2i to);

}
