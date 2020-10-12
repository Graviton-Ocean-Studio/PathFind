package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Vector2i;


public interface NavigationMovement {
    Vector2i nextPosition(Vector2i currentPosition);
}
