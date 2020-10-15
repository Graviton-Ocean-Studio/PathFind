package io.kitejencien.pathfindtheory;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.blocks.Block;

import java.awt.*;

/**
 * the player of the system
 */
public class Player {

    private Vector2i position;

    private BlockMap map;
    private IPlayerNavigator navigator;

    final static NavigationMovement up = (e) -> e.add(0,-1);
    final static NavigationMovement down = (e) -> e.add(0,1);
    final static NavigationMovement right = (e) -> e.add(1,0);
    final static NavigationMovement left = (e) -> e.add(-1,0);
    final static NavigationMovement upLeft = (e) -> e.add(-1,-1);
    final static NavigationMovement upRight = (e) -> e.add(1,-1);
    final static NavigationMovement downLeft = (e) -> e.add(-1,1);
    final static NavigationMovement downRight = (e) -> e.add(1,1);

    public Player(int initX, int initY, BlockMap map){
        this.position = new Vector2i(initX, initY);
        this.map = map;
    }
    public void setNavigator(IPlayerNavigator navigator) {
        this.navigator = navigator;
        this.navigator.loadMap(map);
        this.navigator.loadMovements(new NavigationMovement[]{
                up,down,left,right//,upLeft,upRight,downLeft,downRight
        });

    }
    public NavigationPath navigate(Vector2i destination) {
        return navigator.find(position, destination);
    }
    public boolean moveTo(Vector2i newPosition) {
        if(newPosition.getX() < 0 || newPosition.getX() >= map.xl) return false;
        if(newPosition.getY() < 0 || newPosition.getY() >= map.yl) return false;
        this.position.set(newPosition);
        return true;

    }
    public Vector2i getPosition() {return position;}
    public Block getBlock(){
        return this.map.blocks[this.position.getX()][this.position.getY()];
    }

    public BlockMap getMap() {
        return map;
    }
}
