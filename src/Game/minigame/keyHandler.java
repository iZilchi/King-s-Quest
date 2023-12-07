package Game.minigame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    GamePanel gp;
    public boolean goUp, goDown, goLeft, goRight, enterPressed;
    public keyHandler (GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        //PLAY STATE
        if (gp.gameState == gp.playState) {

            if (code == KeyEvent.VK_W) {
                goUp = true;
            }
            if (code == KeyEvent.VK_S) {
                goDown = true;
            }
            if (code == KeyEvent.VK_D) {
                goRight = true;
            }
            if (code == KeyEvent.VK_A) {
                goLeft = true;
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            if (code == KeyEvent.VK_ESCAPE) {
                if (gp.gameState == gp.playState) {
                    gp.gameState = gp.pauseState;
                }
            }

        }
        //PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_ESCAPE) {
                if (gp.gameState == gp.pauseState) {
                    gp.gameState = gp.playState;
                }
            }
        }

        //DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W){
            goUp = false;
        }
        if (code == KeyEvent.VK_S){
            goDown = false;
        }
        if (code == KeyEvent.VK_D){
            goRight = false;
        }
        if (code == KeyEvent.VK_A){
            goLeft = false;
        }
    }
}
