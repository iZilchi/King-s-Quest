package Game.minigame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import Game.Object.EmpathyMirror;
import Game.Object.GenerosityCandle;
import Game.Object.ForgivingAmulet;
import Game.Object.CompassionHeart;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40, arial_80B;
    BufferedImage mirrorImage, candleImage, amuletImage, heartImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean minigameFinished = false;
    public String currentDialogue = "";

    public double Time;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 30);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        EmpathyMirror mirror = new EmpathyMirror(gp);
        mirrorImage = mirror.image;

        GenerosityCandle candle = new GenerosityCandle(gp);
        candleImage = candle.image;

        ForgivingAmulet amulet = new ForgivingAmulet(gp);
        amuletImage = amulet.image;

        CompassionHeart heart = new CompassionHeart(gp);
        heartImage = heart.image;
    }


    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;
        if (minigameFinished == true){
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            String text;
            int textLength;
            int x;
            int y;

            text = "You managed to escape!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*2);
            g2.drawString(text, x, y);

            text = "Your Time is: " + dFormat.format(Time) + "!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*4);
            g2.drawString(text, x, y);

            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);
            text = "Congratulations!";
            textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }else {

            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);

            if (gp.gameState == gp.playState) {
                g2.drawImage(mirrorImage, 10, 20, gp.tileSize, gp.tileSize, null);
                g2.drawString("x " + gp.player.Mirror, 74, 55);

                g2.drawImage(candleImage, 10, 104, gp.tileSize, gp.tileSize, null);
                g2.drawString("x " + gp.player.Candle, 74, 145);

                g2.drawImage(amuletImage, 10, 188, gp.tileSize, gp.tileSize, null);
                g2.drawString("x " + gp.player.Amulet, 74, 230);

                g2.drawImage(heartImage, 10, 272, gp.tileSize, gp.tileSize, null);
                g2.drawString("x " + gp.player.Heart, 74, 310);

                //TIME
                Time += (double) 1 / 60;
                g2.drawString("Time: " + dFormat.format(Time), gp.tileSize * 13, 55);

                //MESSAGE
                if (messageOn == true) {
                    g2.setFont(g2.getFont().deriveFont(20F));
                    g2.drawString(message, 10, gp.tileSize * 6);

                    messageCounter++;

                    if (messageCounter > 100) {
                        messageCounter = 0;
                        messageOn = false;
                    }
                }
            }
            if (gp.gameState == gp.pauseState) {
                pauseScreen();
            }
            if (gp.gameState == gp.dialogueState) {
                drawDialogueScreen();
            }
        }
    }
    public void pauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80F));
        String text = "PAUSED";
        int x = getCenteredTextX(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen(){
        //WINDOW
        int x = gp.tileSize * 2;
        int y = gp.tileSize * 7;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize * 4;

        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 27F));
        x += gp.tileSize;
        y += gp.tileSize;
        for (String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y+=40;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height ){
        Color c = new Color(0,0,0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
    }

    public int getCenteredTextX(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    public String convertSecondsToTime(double seconds) {
        int hours = (int) (seconds / 3600);
        int minutes = (int) ((seconds % 3600) / 60);
        int remainingSeconds = (int) (seconds % 60);

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }

    public String getRecord (){
        String record = convertSecondsToTime(Time);
        return record;
    }
}