package io.kitejencien.pathfindtheory.navigate;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.BarrierBlock;

import java.util.*;

/**
 * a version of the navigator created by kitejencien
 * @author KiteJencien
 */
public class AStarNavigator implements IPlayerNavigator {

    private BlockMap blockMap;

    private Queue<Node> openList;
    private Stack<Node> closedSearchCenters;

    private ArrayList<NavigationMovement> movements = new ArrayList<>();
    private boolean[][] visited;
    private Vector2i[][] from;
    private boolean IMPOSSIBLE = false;
    private Vector2i to;

    private Node searchCenter;

    @Override
    public void loadMap(BlockMap blockMap) {
        this.blockMap = blockMap;
        this.openList = new LinkedList<>();
        this.closedSearchCenters = new Stack<>();
        this.visited = new boolean[blockMap.xl][blockMap.yl];
        this.from = new Vector2i[blockMap.xl][blockMap.yl];
    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {
        this.movements.addAll(Arrays.asList(movements));
    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        Stack<Vector2i> path = new Stack<>();
        this.searchCenter = new Node(calcWeight(blockMap,from,from,to),blockMap.getBlock(from));

        if(blockMap.getBlock(to) instanceof BarrierBlock) return null;

        while(searchCenter != null && !searchCenter.getPos().equals(to) && !IMPOSSIBLE){
            searchSurrounding(this.searchCenter,to);

            try{
                Thread.sleep(30);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if (searchCenter == null){
            IMPOSSIBLE = true;
            return null;
        }


        Node current = closedSearchCenters.pop();
        path.add(current.getPos());

        while(!closedSearchCenters.isEmpty()){
            Node next = closedSearchCenters.pop();
            if(this.from[current.getPos().getX()][current.getPos().getY()] == next.getPos()){
                path.add(next.getPos());
                current = next;
            }
        }

        ArrayList<NavigationMovement> navigationMovements = new ArrayList<>();

        while(!path.isEmpty()) {
            Vector2i temporary = path.pop();
            navigationMovements.add((e) -> (e.add(temporary.subtract(e))));
            System.out.printf("(%s, %s) -> ", temporary.getX(), temporary.getY());
        }
        return new NavigationPath(from, navigationMovements.toArray(NavigationMovement[]::new));
    }

    public void searchSurrounding(Node searchCenter, Vector2i to){

        openList.remove(searchCenter);
        closedSearchCenters.add(searchCenter);
        searchCenter.getBlock().setVisiting(false);
        System.out.printf("SearchCenter: Position - %s \n",searchCenter.getPos());

        for (NavigationMovement movement : movements) {

            Vector2i posHere = movement.nextPosition(searchCenter.getPos());
            if(posHere.getX()<0 || posHere.getX() >= blockMap.xl || posHere.getY() < 0 || posHere.getY()>=blockMap.yl
                    || visited[posHere.getX()][posHere.getY()])
                continue;

            Node add = new Node(calcWeight(blockMap,searchCenter.getPos(),posHere,to),blockMap.getBlock(posHere));
            this.from[add.getPos().getX()][add.getPos().getY()] = searchCenter.getPos();

            visited[posHere.getX()][posHere.getY()] = true;
            add.getBlock().setVisited(true);
            if(!add.getBlock().isCanPass()){continue;}
            openList.add(add);
        }

        openList = organizeByWeight(openList);
    }



    //this will automatically set the node in the queue with the list
    public Queue<Node> organizeByWeight(Queue<Node> in){
        double leastWeight = 2147483647;
        Node least = null;
        Queue<Node> out = new LinkedList<>();
        while(!in.isEmpty()){
            Node current = in.poll();
            if(current.get_weight() < leastWeight){
                if(least != null) out.add(least);
                least = current;
                leastWeight = current.get_weight();
                continue;
            }
            out.add(current);
        }
        this.searchCenter = least;
        if(searchCenter != null) {
            this.searchCenter.getBlock().setVisiting(true);
            this.searchCenter.getBlock().setDeepVisited(true);
        }
        return out;
    }

    //calculate the value of the weight
    //adjust the constants here might influence the behavior of the pathfinding
    public static double calcWeight(BlockMap blockMap,Vector2i pos0,Vector2i pos, Vector2i to){
        return pos0.distanceTo(pos)*blockMap.getBlock(pos).getTimeOnPass() + (pos.distanceTo(to));
    }

    public ArrayList<NavigationMovement> getMovements() {
        return movements;
    }

    public BlockMap getBlockMap() {
        return blockMap;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public Node getSearchCenter() {
        return searchCenter;
    }

    public Queue<Node> getOpenList() {
        return openList;
    }

    public Stack<Node> getClosedSearchCenters() {
        return closedSearchCenters;
    }

    public Vector2i[][] getFrom() {
        return from;
    }

    public void setTo(Vector2i to) {
        this.to = to;
    }

    public void setSearchCenter(Node searchCenter) {
        this.searchCenter = searchCenter;
    }

    public void setFrom(Vector2i[][] from) {
        this.from = from;
    }

    public Vector2i getTo() {
        return to;
    }
}
