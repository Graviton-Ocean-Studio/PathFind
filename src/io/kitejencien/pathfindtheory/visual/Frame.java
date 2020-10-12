package io.kitejencien.pathfindtheory.visual;

import io.kitejencien.pathfindtheory.BlockMap;
import io.kitejencien.pathfindtheory.Player;

import javax.swing.*;
import java.awt.*;

/**
 * the panel for display
 * @author KiteJencien
 */
public class Frame extends JFrame {

    private BlockMap map;
    private Player player;
    private Panel panel;
    private int blockSize;

    public Frame(Player player) throws HeadlessException {

        super("PathFinderTest");

        this.map = player.getMap();
        this.player = player;

        setSize(initFrameSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.panel = new Panel(this,player);

        this.add(panel);

        this.setVisible(true);
    }

    public Dimension initFrameSize(){
        Dimension screenSize = getToolkit().getScreenSize();
        if(map.xl >= map.yl){
            this.blockSize = (int)(screenSize.getWidth()/(2*map.xl)) + 4;
        }else{
            this.blockSize = (int)((screenSize.getHeight()*1.5)/(2*map.yl)) + 4;
        }
        return new Dimension(map.xl*blockSize,map.yl*blockSize);
    }

    public void updateBlockSize(){
        this.blockSize = getSize().width / map.xl;
    }

    public BlockMap getMap() {
        return map;
    }

    public Panel getPanel() {
        return this.panel;
    }

    public Player getPlayer() {
        return player;
    }

    public int getBlockSize() {
        return blockSize;
    }
}
