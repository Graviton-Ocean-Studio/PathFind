package com.daixuan.algorithms.bfsnavigator;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.Block;

import java.util.*;

public class BFSNavigator implements IPlayerNavigator {

    public BFSNavigator() {
        _movements = new ArrayList<>();
        queue = new LinkedList<Vector2i>();

    }
    BlockMap _map;
    ArrayList<NavigationMovement> _movements;
    Queue<Vector2i> queue;
    BFSNavigationNodeMap _nodeMap;
    @Override
    public void loadMap(BlockMap blockMap) {
        _map = blockMap;
        _nodeMap = new BFSNavigationNodeMap(blockMap.xl, blockMap.yl);
    }

    @Override
    public void loadMovements(NavigationMovement[] movements) {
        _movements.addAll(Arrays.asList(movements));

    }
    private void integratedVisit(Vector2i position, Vector2i from) {
        _map.getBlock(position.getX(), position.getY()).setVisited(true);
        _nodeMap.isVisited[position.getX()][position.getY()] = true;
        _nodeMap.from[position.getX()][position.getY()] = from;
    }

    @Override
    public NavigationPath find(Vector2i from, Vector2i to) {
        queue.clear();

        queue.add(from);
        integratedVisit(from, from);
        Vector2i currentHead;
        while(!queue.isEmpty()) {
            currentHead = queue.poll();

            if(currentHead.equals(to)) {
                Stack<Vector2i> path = new Stack<>();
                Vector2i current = new Vector2i(0,0);
                current.set(to);

                while(!_nodeMap.from[current.getX()][current.getY()].equals(current)) {
                    path.add(new Vector2i(current.getX(), current.getY()));
                    current.set(_nodeMap.from[current.getX()][current.getY()]);
                }
                path.add(current);
                ArrayList<NavigationMovement> navigationMovements = new ArrayList<>();

                while(!path.isEmpty()) {
                    Vector2i temporary = path.pop();
                    navigationMovements.add((e) -> (e.add(temporary.subtract(e))));
                    System.out.printf("(%s, %s) -> ", temporary.getX(), temporary.getY());
                }
                return new NavigationPath(from, navigationMovements.toArray(NavigationMovement[]::new));
            }

            for (NavigationMovement m: _movements
                 ) {
                Vector2i nextPosition = m.nextPosition(currentHead);
                Block block = _map.getBlock(nextPosition.getX(), nextPosition.getY());
                if(block != null) {
                    // reachable
                    System.out.printf("visit Block(canPass: %s, position: (%s,%s), isVisited: %s) \n",block.isCanPass(), block.getX(),block.getY(), _nodeMap.isVisited[nextPosition.getX()][nextPosition.getY()]);
                    if(_nodeMap.isVisited[nextPosition.getX()][nextPosition.getY()]) continue;
                    if(!block.isCanPass()) continue;
                    queue.add(nextPosition);
                    integratedVisit(nextPosition, currentHead);
                }
            }
        }
        return null;
    }
}
