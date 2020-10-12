package io.kitejencien.pathfindtheory.visual;

import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Player;
import io.kitejencien.pathfindtheory.Vector2i;
import io.kitejencien.pathfindtheory.blocks.BarrierBlock;
import io.kitejencien.pathfindtheory.blocks.BreakableBlock;
import io.kitejencien.pathfindtheory.blocks.GoalBlock;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * the panel part of the display
 * @author KiteJencien
 */
public class Panel extends JPanel {

    private Player player;
    private Frame frame;
    private int blockSize;
    private ArrayList<Consumer<Graphics>> renderers;
    public Panel(Frame frame, Player player){
        renderers = new ArrayList<>();
        this.frame = frame;
        this.player = player;

        setSize(frame.getSize());
        this.blockSize = frame.getBlockSize();

    }
    public void registerRenderer(Consumer<Graphics> renderer) {
        renderers.add(renderer);
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0,0,getSize().width,getSize().height);

        paintMap(g);
        paintPlayer(g);
        renderers.forEach((renderer) ->  renderer.accept(g));
    }
    public void paintPlayer(Graphics g) {
        Vector2i position = player.getPosition();
        g.setColor(Color.black);
        g.fillOval(position.getX() * blockSize + 3, position.getX() * blockSize + 3, blockSize - 4, blockSize - 4);
        g.setColor(Color.red);
        g.fillOval(position.getX() * blockSize + 5, position.getX() * blockSize + 5, blockSize - 8, blockSize - 8);
    }

    public void paintMap(Graphics g){

        BlockMap map = player.getMap();

        for (int i = 0; i < map.xl; i++) {
            for (int j = 0; j < map.yl; j++) {

                g.setColor(Color.black);
                g.fillRect(blockSize*(i), blockSize*(j),
                        blockSize,blockSize);

                if(map.getBlock(i,j) instanceof BarrierBlock){
                    g.setColor(Color.white);
                }else if(map.getBlock(i,j) instanceof BreakableBlock){
                    g.setColor(Color.GRAY);
                }else if(map.getBlock(i,j) instanceof GoalBlock){
                    g.setColor(Color.red);
                }else{
                    g.setColor(Color.black);
                }


                g.fillRect(blockSize*(i) + 2, blockSize*(j) + 2,
                        blockSize - 2,blockSize - 2);

                if(map.getBlock(i,j).isVisited()) {
                    g.setColor(new Color(128,128,228,128));
                    g.fillOval(blockSize*(i) + 2, blockSize*(j) + 2,
                            blockSize -2, blockSize - 2);
                }

            }
        }
    }
}
