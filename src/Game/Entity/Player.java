package Game.Entity;

import Game.Menu;
import Game.Scene4;
import Game.minigame.Database;
import Game.minigame.GamePanel;
import Game.minigame.keyHandler;
import Game.minigame.minigame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{
    keyHandler keyH;
    public int screenX;
    public int screenY;
    public int Mirror = 0;
    public int Candle = 0;
    public int Amulet = 0;
    public int Heart = 0;
    public int BlessedArtifacts = 0;
    public String cursedText;

    public Player(GamePanel gp, keyHandler keyH){
        super(gp);
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 24;
        solidArea.y = 38;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 16;
        solidArea.height = 24;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        worldX = gp.tileSize * 2; //Player position
        worldY = gp.tileSize * 5;
        speed = 4;
        direction = "down";

        BlessedArtifacts = 0;
        Mirror = 0;
        Candle = 0;
        Amulet = 0;
        Heart = 0;
    }

    public void getPlayerImage(){
        up0 = setup("/Minigame/Player/Back0");
        up1 = setup("/Minigame/Player/Back1");
        up2 = setup("/Minigame/Player/Back2");
        up3 = setup("/Minigame/Player/Back3");
        up4 = setup("/Minigame/Player/Back4");
        up5 = setup("/Minigame/Player/Back5");
        up6 = setup("/Minigame/Player/Back6");
        down0 = setup("/Minigame/Player/Front0");
        down1 = setup("/Minigame/Player/Front1");
        down2 = setup("/Minigame/Player/Front2");
        down3 = setup("/Minigame/Player/Front3");
        down4 = setup("/Minigame/Player/Front4");
        down5 = setup("/Minigame/Player/Front5");
        down6 = setup("/Minigame/Player/Front6");
        left0 = setup("/Minigame/Player/Left0");
        left1 = setup("/Minigame/Player/Left1");
        left2 = setup("/Minigame/Player/Left2");
        left3 = setup("/Minigame/Player/Left3");
        left4 = setup("/Minigame/Player/Left4");
        left5 = setup("/Minigame/Player/Left5");
        left6 = setup("/Minigame/Player/Left6");
        right0 = setup("/Minigame/Player/Right0");
        right1 = setup("/Minigame/Player/Right1");
        right2 = setup("/Minigame/Player/Right2");
        right3 = setup("/Minigame/Player/Right3");
        right4 = setup("/Minigame/Player/Right4");
        right5 = setup("/Minigame/Player/Right5");
        right6 = setup("/Minigame/Player/Right6");
    }

    public void update(){
        if (keyH.goUp || keyH.goDown || keyH.goLeft || keyH.goRight) {
            if (keyH.goUp) {
                direction = "up";
            } if (keyH.goDown) {
                direction = "down";
            } if (keyH.goLeft) {
                direction = "left";
            } if (keyH.goRight) {
                direction = "right";
            }

            //Check Tile Collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            objInteract(objIndex);

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkNPC(this, true);
            npcInteract(npcIndex);

            if (collisionOn == false){
                switch(direction){
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 9) {
                spriteNum = (spriteNum % 6) + 1;
                spriteCounter = 0;
            }
        } else {
            spriteNum = 0;
        }
    }

    public void objInteract(int index){
        if (index != 999) {

            String objectName = gp.obj[index].name;
            String objectArtifact = gp.obj[index].artifact;

            if (objectArtifact == "Blessed"){
                gp.playSFX(0);
                BlessedArtifacts++;

                switch(objectName) {
                    case "Mirror of Empathy":
                        Mirror++;
                        gp.obj[index] = null;
                        gp.ui.showMessage("You obtained an Empathy Mirror!");
                        break;
                    case "Forgiving Amulet":
                        Amulet++;
                        gp.obj[index] = null;
                        gp.ui.showMessage("You obtained a Forgiving Amulet!");
                        break;
                    case "Candle of Generosity":
                        Candle++;
                        gp.obj[index] = null;
                        gp.ui.showMessage("You obtained a Generosity Candle!");
                        break;
                    case "Heart of Compassion":
                        Heart++;
                        gp.obj[index] = null;
                        gp.ui.showMessage("You obtained a Compassion Heart!");
                        break;
                }
            } else if (objectArtifact == "Cursed") {
                switch(objectName) {
                    case "Mirror of Apathy":
                        cursedText = "You're cursed by an Apathy Mirror!";
                        break;
                    case "Bitter Amulet":
                        cursedText = "You're cursed by a Bitter Amulet!";
                        break;
                    case "Selfish Candle":
                        cursedText = "You're cursed by a Selfish Candle!";
                        break;
                    case "Stone of Indifference":
                        cursedText = "You're cursed by an Indifference Stone!";
                        break;
                }
                gp.ui.showMessage(cursedText);
                gp.playSFX(2);
                gp.restart();
            }
            if (objectName == "Door"){
                if (BlessedArtifacts == 8){
                    gp.obj[index] = null;
                    gp.ui.minigameFinished = true;
                    gp.stopMusic();
                    gp.playSFX(3);

                    String username = minigame.getUsername();
                    String record = gp.ui.getRecord();
                    Database db = new Database();
                    int userID = db.getuserID(username);
                    db.setTime(record, userID);
                }else{
                    gp.ui.showMessage("You have not yet obtained the 8 artifacts. Go back.");
                }
            }
        }
    }

    public void npcInteract(int index){
        if (index != 999) {
            collisionOn = true;

            String npcName = gp.npc[index].name;
            if (npcName == "Witch"){
                if (gp.keyH.enterPressed) {
                    gp.gameState = gp.dialogueState;
                    gp.npc[index].speak();
                }
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                if (spriteNum == 3){
                    image = up3;
                }
                if (spriteNum == 4){
                    image = up4;
                }
                if (spriteNum == 5){
                    image = up5;
                }
                if (spriteNum == 6){
                    image = up6;
                }
                if (spriteNum == 0){
                    image = up0;
                }
                break;
            case "down":
                if (spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                if (spriteNum == 3){
                    image = down3;
                }
                if (spriteNum == 4){
                    image = down4;
                }
                if (spriteNum == 5){
                    image = down5;
                }
                if (spriteNum == 6){
                    image = down6;
                }
                if (spriteNum == 0){
                    image = down0;
                }
                break;
            case "left":
                if (spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                if (spriteNum == 3){
                    image = left3;
                }
                if (spriteNum == 4){
                    image = left4;
                }
                if (spriteNum == 5){
                    image = left5;
                }
                if (spriteNum == 6){
                    image = left6;
                }
                if (spriteNum == 0){
                    image = left0;
                }
                break;
            case "right":
                if (spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                if (spriteNum == 3){
                    image = right3;
                }
                if (spriteNum == 4){
                    image = right4;
                }
                if (spriteNum == 5){
                    image = right5;
                }
                if (spriteNum == 6){
                    image = right6;
                }
                if (spriteNum == 0){
                    image = right0;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, null);
    }
}
