package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Vector2i;

/**
 * @author QueueHuo
 */
public interface NavigationMovement {
    Vector2i nextPosition(Vector2i currentPosition);
}
