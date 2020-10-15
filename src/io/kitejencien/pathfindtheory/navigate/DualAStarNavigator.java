package io.kitejencien.pathfindtheory.navigate;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;

import java.util.*;

import static io.kitejencien.pathfindtheory.navigate.AStarNavigator.calcWeight;

/**
 * a algorithm that runs A star from both the start and the end
 * @author KiteJencien
 */
public class DualAStarNavigator implements IPlayerNavigator {

    private BlockMap blockMap;

    private Queue<Node> openListP;
    private Queue<Node> openListG;

    private Stack<Node> closedSearchCentersP;
    private Stack<Node> closedSearchCentersG;

    private ArrayList<NavigationMovement> movements = new ArrayList<>();
    private boolean[][] visited;
    private Vector2i[][] from;
    private boolean IMPOSSIBLE = false;

    private Node searchCenterP;  //searchCenter of the player
    private Node searchCenterG;   //searchCenter of the Goal


    @Override
    public void loadMap(BlockMap blockMap) {
        this.blockMap = blockMap;

        this.openListP = new LinkedList<>();
        this.openListG = new LinkedList<>();

        this.closedSearchCentersP = new Stack<>();
        this.closedSearchCentersG = new Stack<>();

        this.visited = new boolean[blockMap.xl][blockMap.yl];
        this.from = new Vector2i[blockMap.xl][blockMap.yl];
    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {
        this.movements.addAll(Arrays.asList(movements));
    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        return null;
    }





}
