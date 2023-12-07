package Game.Entity;

import Game.minigame.UtilityTool;
import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {
    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public BufferedImage up0, up1, up2, up3, up4, up5, up6;
    public BufferedImage down0, down1, down2, down3, down4, down5, down6;
    public BufferedImage left0, left1, left2, left3, left4, left5, left6;
    public BufferedImage right0, right1, right2, right3, right4, right5, right6;
    public BufferedImage image;
    public String name;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 0;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collision = false;
    public boolean collisionOn = false;
    UtilityTool uTool = new UtilityTool();
    public String[] dialogues = new String[20];
    public int dialogueIndex = 0;

    public Entity(GamePanel gp){ //ABSTRACT CLASS
        this.gp = gp;
    }

    public void speak(){
        if (dialogues[dialogueIndex] == null){
            dialogueIndex = 0;
        }

        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }

    public void draw(Graphics2D g2){
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, screenX, screenY, null);
        }
    }

    public BufferedImage setup(String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
