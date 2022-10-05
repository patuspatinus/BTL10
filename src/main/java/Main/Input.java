package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    public boolean up_key,down_key,left_key,right_key;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            up_key=true;
        }
        if(code==KeyEvent.VK_DOWN){
            down_key=true;
        }
        if(code==KeyEvent.VK_LEFT){
            left_key=true;
        }
        if(code==KeyEvent.VK_RIGHT){
            right_key=true;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_UP){
            up_key=false;
        }
        if(code==KeyEvent.VK_DOWN){
            down_key=false;
        }
        if(code==KeyEvent.VK_LEFT){
            left_key=false;
        }
        if(code==KeyEvent.VK_RIGHT){
            right_key=false;
        }

    }
}
