package com.daixuan.algorithms;

import io.kitejencien.pathfindtheory.Vector2i;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author QueueHuo
 */
public class NavigationPath implements Iterator {
    private ArrayList<NavigationMovement> _movements;
    private int _pointer;
    private Vector2i start, _currentPosision;
    float blockSize;
    public NavigationPath(Vector2i start, NavigationMovement[] movements, float blockSize) {
        _pointer = 0;
        this.start = start;
        this._currentPosision = new Vector2i(start.getX(), start.getY());
        this._movements = new ArrayList<>();
        this._movements.addAll(Arrays.asList(movements));
        this.blockSize = blockSize;
    }

    public void addMovement(NavigationMovement navigationMovement) {
        this._movements.add(navigationMovement);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.green);
        Vector2i position, nextPosition;
        position = start;
        for (NavigationMovement movement: _movements) {
            nextPosition = movement.nextPosition(position);
            g2d.drawLine((int)((position.getX() + 0.5) * blockSize) + 1, (int)(( position.getY() + 0.5) * blockSize) + 1, (int)((nextPosition.getX() + 0.5) * blockSize) + 1, (int)((nextPosition.getY() + 0.5) * blockSize) + 1);
            position = nextPosition;
        }
    }

    @Override
    public boolean hasNext() {
        return (_pointer < _movements.size());
    }

    @Override
    public Vector2i next() {
        _currentPosision.set(_movements.get(_pointer++).nextPosition(_currentPosision));
        return _currentPosision;
    }


}
