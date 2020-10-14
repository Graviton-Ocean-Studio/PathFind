package com.daixuan.algorithms.bfsnavigator;

import com.daixuan.algorithms.IPlayerNavigator;
import com.daixuan.algorithms.NavigationMovement;
import com.daixuan.algorithms.NavigationPath;
import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.Block;

import java.util.*;

/**
 * @author QueueHuo
 */
public class BFSNavigator implements IPlayerNavigator {

    public BFSNavigator() {
        _movements = new ArrayList<>();
        queue = new PriorityQueue<>();

    }
    BlockMap _map;
    ArrayList<NavigationMovement> _movements;
    Queue<BFSNavigatorQueueingNode> queue;
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
        _map.setGoal(to.getX(),to.getY());
        queue.clear();

        queue.add(new BFSNavigatorQueueingNode(from, 0));
        integratedVisit(from, from);
        BFSNavigatorQueueingNode currentHead;
        while(!queue.isEmpty()) {
            currentHead = queue.poll();
            try {
                Thread.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //arrived
            if(currentHead.position.equals(to)) {
                Stack<Vector2i> path = new Stack<>();
                Vector2i current = new Vector2i(0,0);
                current.set(to);

                while(!_nodeMap.from[current.getX()][current.getY()].equals(current)) {
                    System.out.println(current);
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
                Vector2i nextPosition = m.nextPosition(currentHead.position);
                Block block = _map.getBlock(nextPosition.getX(), nextPosition.getY());
                if(block != null) {
                    // reachable
                    System.out.printf("visit Block(canPass: %s, position: (%s,%s), isVisited: %s) \n",block.isCanPass(), block.getX(),block.getY(), _nodeMap.isVisited[nextPosition.getX()][nextPosition.getY()]);
                    if(_nodeMap.isVisited[nextPosition.getX()][nextPosition.getY()]) continue;
                    if(!block.isCanPass()) continue;
                    queue.add(new BFSNavigatorQueueingNode(nextPosition, currentHead.currentCost + block.getTimeOnPass() + (int)Math.pow((currentHead.position.distanceTo(to)), 3)));
                    integratedVisit(nextPosition, currentHead.position);
                }
            }
        }
        return null;
    }
}
