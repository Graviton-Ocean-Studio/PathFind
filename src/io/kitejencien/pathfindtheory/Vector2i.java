package io.kitejencien.pathfindtheory;

/**
<<<<<<< HEAD
 * @author Queue Huo
=======
 * @author QueueHuo
>>>>>>> b9e9f51433ae83173d739a8605135ba395baf5d7
 */
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

    public Vector2i subtract(Vector2i movement) {
        return new Vector2i(this._x - movement.getX(),this._y - movement.getY());

    }

    public Vector2i add(int x, int y) {
        return add(new Vector2i(x,y));
    }

    public boolean equals(Vector2i anotherValue) {
        return this._x == anotherValue.getX() && this._y == anotherValue.getY();
    }

    public void set(Vector2i newValue) {
        this._x = newValue.getX();
        this._y = newValue.getY();
    }

    public double distanceTo(Vector2i point) {
        return Math.sqrt(Math.pow(this._x - point.getX(), 2) + Math.pow(this._y - point.getY(), 2));
    }

    //calculate the distance in blocks
    public int manhattanDistanceTo(Vector2i point){
        return Math.abs(this.getX() - point.getX()) + Math.abs(this.getY() - point.getY());
    }

    @Override
    public String toString() {
        return getX() + "," + getY();
    }
}
