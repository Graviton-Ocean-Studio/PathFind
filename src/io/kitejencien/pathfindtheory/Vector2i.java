package io.kitejencien.pathfindtheory;

public class Vector2i {
    private int _x, _y;
    public Vector2i(int x, int y) {
        this._x = x;
        this._y = y;
    }
    public int getX() {
        return this._x;
    }
    public int getY() {
        return this._y;
    }

    public void setX(int x) {
        this._x = x;
    }

    public void setY(int y) {
        this._y = y;
    }

    public Vector2i add(Vector2i movement) {
        return new Vector2i(this._x + movement.getX(),this._y + movement.getY());

    }
    public Vector2i add(int x, int y) {
        return add(new Vector2i(x,y));
    }

    public void set(Vector2i newValue) {
        this._x = newValue.getX();
        this._y = newValue.getY();
    }

    public double distanceTo(Vector2i point) {
        return Math.sqrt(Math.pow(this._x - point.getX(), 2) + Math.pow(this._y - point.getY(), 2));
    }

}