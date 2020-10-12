package io.kitejencien.pathfindtheory.visual;

import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Player;
import io.kitejencien.pathfindtheory.blocks.BarrierBlock;
import io.kitejencien.pathfindtheory.blocks.BreakableBlock;
import io.kitejencien.pathfindtheory.blocks.GoalBlock;

import javax.swing.*;
import java.awt.*;

/**
 * the panel part of the display
 * @author KiteJencien
 */
public class Panel extends JPanel {

    private Player player;
    private Frame frame;
    private int blockSize;

    public Panel(Frame frame, Player player){

        this.frame = frame;
        this.player = player;

        setSize(frame.getSize());
        this.blockSize = frame.getBlockSize();

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0,0,getSize().width,getSize().height);

        paintMap(g);
    }

    public void paintMap(Graphics g){

        BlockMap map = player.getMap();

        for (int i = 0; i < map.xl; i++) {
            for (int j = 0; j < map.yl; j++) {

                g.setColor(Color.black);
                g.fillRect(blockSize*(i), blockSize*(j),
                        blockSize*(i+1),blockSize*(j+1));

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
                        blockSize*(i+1) -2,blockSize*(j+1)-2);

            }
        }
    }
}
