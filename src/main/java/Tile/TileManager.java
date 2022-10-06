package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[10];
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
//"res/sprites/grass.png"
            tile[0].image= ImageIO.read(Objects.requireNonNull(TileManager.class.getResource("res/sprites/grass.png")));

            tile[1]=new Tile();
            File f2=new File("res/sprites/brick.png");
            tile[1].image= ImageIO.read(f2);

            tile[2]=new Tile();
            File f3=new File("res/sprites/wall.png");
            tile[2].image= ImageIO.read(f3);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(tile[0].image,0,0,gp.TileSize,gp.TileSize,null);
    }
}
