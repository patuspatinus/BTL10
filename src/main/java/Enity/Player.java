package Enity;

import Main.GamePanel;
import Main.Input;

import javax.imageio.ImageIO;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Player extends Enity{
    GamePanel gp;
    Input input;
    public Player(GamePanel gp, Input input){
        this.gp=gp;
        this.input=input;
        setDefault();
        getPlayerImage();
    }
    public void setDefault(){
        x=100;
        y=100;
        speed=4;
        direction="right";
    }



    public void getPlayerImage(){
        try{
//            up= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_up.png")));
//            up1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_up_1.png")));
//            up2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_up_2.png")));
//            down= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_down.png")));
//            down1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_down_1.png")));
//            down2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_down_2.png")));
//            left= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_left.png")));
//            left1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_left_1.png")));
//            left2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_left_2.png")));
//            right= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_right.png")));
//            right1= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_right_1.png")));
//            right2= ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("res/sprites/player_right_2.png")));
            File f_up=new File("res/sprites/player_up.png");
            File f_up_1=new File("res/sprites/player_up_1.png");
            File f_up_2=new File("res/sprites/player_up_2.png");
            File f_down=new File("res/sprites/player_down.png");
            File f_down_1=new File("res/sprites/player_down_1.png");
            File f_down_2=new File("res/sprites/player_down_2.png");
            File f_left=new File("res/sprites/player_left.png");
            File f_left_1=new File("res/sprites/player_left_1.png");
            File f_left_2=new File("res/sprites/player_lef_2.png");
            File f_right=new File("res/sprites/player_right.png");
            File f_right_1=new File("res/sprites/player_right_1.png");
            File f_right_2=new File("res/sprites/player_right_2.png");
            up=ImageIO.read(f_up);
            up1=ImageIO.read(f_up_1);
            up2=ImageIO.read(f_up_2);
            down=ImageIO.read(f_down);
            down1=ImageIO.read(f_down_1);
            down2=ImageIO.read(f_down_2);
            left=ImageIO.read(f_left);
            left1=ImageIO.read(f_left_1);
//            left2=ImageIO.read(f_left_2);
            right=ImageIO.read(f_right);
            right1=ImageIO.read(f_right_1);
            right2=ImageIO.read(f_right_2);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void update() {
        if(input.up_key|| input.down_key||
                input.left_key|| input.right_key){
            if(input.up_key){
                direction="up";
                y-=speed;
            }
            if(input.down_key){
                direction="down";
                y+=speed;
            }
            if(input.left_key){
                direction="left";
                x-=speed;
            }
            if(input.right_key){
                direction="right";
                x+=speed;
            }
            SpriteCount++;
            if(SpriteCount==5){
                if(SpriteNum==0){
                    SpriteNum=1;
                }
                else if(SpriteNum==1){
                    SpriteNum=2;
                }
                else if(SpriteNum==2){
                    SpriteNum=0;
                }
                SpriteCount=0;
            }
        }


    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.pink);
//        g2.fillRect(x,y,gp.TileSize,gp.TileSize);

        BufferedImage image= null;
        switch (direction) {
            case "up" -> {
                if (SpriteNum == 0) {
                    image = up;
                }
                if (SpriteNum == 1) {
                    image = up1;
                }
                if (SpriteNum == 2) {
                    image = up2;
                }
            }
            case "down" -> {
                if (SpriteNum == 0) {
                    image = down;
                }
                if (SpriteNum == 1) {
                    image = down1;
                }
                if (SpriteNum == 2) {
                    image = down2;
                }
            }
            case "left" -> {
                if (SpriteNum == 0) {
                    image = left;
                }
                if (SpriteNum == 1) {
                    image = left1;
                }
                if (SpriteNum == 2) {
                    image = left1;
                }
            }
            case "right" -> {
                if (SpriteNum == 0) {
                    image = right;
                }
                if (SpriteNum == 1) {
                    image = right1;
                }
                if (SpriteNum == 2) {
                    image = right2;
                }
            }
            default -> {
            }
        }
        g2.drawImage(image,x,y,gp.TileSize,gp.TileSize,null);
    }

}
