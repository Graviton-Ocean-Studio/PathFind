package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Vector2i;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class NavigationPath implements Iterator {
    private NavigationMovement[] _movements;
    public NavigationPath(Vector2i start, NavigationMovement[] movements) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
