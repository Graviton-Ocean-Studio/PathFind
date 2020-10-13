package io.kitejencien.pathfindtheory.visual;

/**
 * a thread to update the frame
 * @author KiteJencien
 */
public class FrameUpdator extends Thread{

    private Frame frame;

    public FrameUpdator(Frame frame){
        this.frame = frame;
    }

    @Override
    public void run() {
        while(true){
            this.frame.repaint();
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
