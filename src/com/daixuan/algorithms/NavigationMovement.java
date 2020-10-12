package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Vector2i;

import java.util.concurrent.Callable;
import java.util.function.Consumer;

public interface NavigationMovement {
    Vector2i nextPosition(Vector2i currentPosition);
}
