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
        int col=0;
        int row=0;
        int x=0;
        int y=0;
        while(col <= gp.maxScreenCol && row <= gp.maxScreenRow){
            g2.drawImage(tile[0].image,x,y,gp.TileSize,gp.TileSize,null);
            col++;
            x+=gp.TileSize;
            if(col==gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y+=gp.TileSize;
            }
        }
    }
}
