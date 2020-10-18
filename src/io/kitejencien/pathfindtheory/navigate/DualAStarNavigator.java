package io.kitejencien.pathfindtheory.navigate;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Player;
import io.kitejencien.pathfindtheory.Vector2i;

import java.rmi.MarshalledObject;
import java.util.*;

import static io.kitejencien.pathfindtheory.navigate.AStarNavigator.calcWeight;

/**
 * a algorithm that runs A star from both the start and the end
 * @author KiteJencien
 */
public class DualAStarNavigator implements IPlayerNavigator {

    private BlockMap blockMap;
    private ArrayList<NavigationMovement> movements = new ArrayList<>();

    private AStarNavigator navigatorP;
    private AStarNavigator navigatorG;

    private Vector2i[][] from;


    @Override
    public void loadMap(BlockMap blockMap) {

        this.from = new Vector2i[blockMap.xl][blockMap.yl];

        navigatorP = new AStarNavigator();
        navigatorG = new AStarNavigator();

        this.blockMap = blockMap;
        navigatorP.loadMap(blockMap);
        navigatorG.loadMap(blockMap);
    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {
        this.movements.addAll(Arrays.asList(movements));
        navigatorG.loadMovements(movements);
        navigatorP.loadMovements(movements);
    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        navigatorP.setTo(to);
        navigatorG.setTo(from);

        navigatorP.setFrom(this.from);
        navigatorG.setFrom(this.from);

        navigatorP.setSearchCenter(new Node(AStarNavigator.calcWeight(blockMap,from,from,to),blockMap.getBlock(from)));
        navigatorG.setSearchCenter(new Node(AStarNavigator.calcWeight(blockMap,to,to,from),blockMap.getBlock(to)));

        return null;
    }





}
