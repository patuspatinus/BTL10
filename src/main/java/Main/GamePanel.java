package Main;

import Enity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTitleSize = 16;//16*16 Tile
    final int scale = 3;

    public final int TileSize = originalTitleSize * scale;//48*48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = TileSize * maxScreenCol;//48*16 pixels;
    final int screenHeight = TileSize * maxScreenRow;//48&12 pixels;

    //FPS
    int FPS=60;

    Input input=new Input();
    Thread gameThread;
    Player player = new Player(this,input);
    //set default position
    int playerX=100;
    int playerY=100;
    int playerSpeed=4;

    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);

    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();

    }
    @Override
    public void run() {

        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        long drawCount=0;
        while (gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            lastTime=currentTime;

            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            //System.out.println("the game loop ois running");
            //1:update:update information

            //2 draw : draw the screen with uploaded information
            if(timer>=1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount=0;
                timer=0;
            }
        }
    }
    public void update() {
        player.update();


    }

    public void paintComponent( Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}