package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TileManager extends Tile{
    GamePanel gp;
    Tile[] tile = new Tile[1000];
    public TileManager(GamePanel gp){
        this.gp=gp;
        //tile=new Tile[10];
        getTileImage();
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();

            File grass=new File("res/sprites/grass.png");
            tile[0].image= ImageIO.read(grass);

            tile[1]=new Tile();
            File brick=new File("res/sprites/brick.png");
            tile[1].image= ImageIO.read(brick);

            tile[2]=new Tile();
            File wall=new File("res/sprites/wall.png");
            tile[2].image= ImageIO.read(wall);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){

        g2.drawImage(tile[0].image,0,0,gp.TileSize,gp.TileSize,null);
    }
}
