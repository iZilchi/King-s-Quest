package Game.minigame;
import Game.Entity.Entity;
import Game.Entity.Player;
import Game.Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import Game.Object.SuperObject;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 32;
    final int scale = 2;

    public final int tileSize = originalTileSize * scale; //64 x 64
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = (tileSize * maxScreenCol); // 1024
    public int screenHeight = (tileSize * maxScreenRow); // 768
    JFrame frame;

    //WORLD SETTINGS
    public final int maxWorldCol = 82;
    public final int maxWorldRow = 30;


   //FPS
    int FPS = 60;

    //SYSTEM
    TileManager tileM = new TileManager(this);
    public keyHandler keyH = new keyHandler(this);
    public Entity e = new Entity(this);
    Sound music = new Sound();
    Sound sfx = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //ENTITY AND OBJECT
    public Player player = new Player(this,keyH);
    public SuperObject[] obj = new SuperObject[70];
    public Entity[] npc = new Entity[2];

    //GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;



    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();

        playMusic(1);

        gameState = playState;
    }

    public void restart (){
        player.setDefaultValues();
        aSetter.setObject();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){

        if (gameState == playState) {
            //PLAYER
            player.update();
        }
        if (gameState == pauseState){
            // nothing
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //TILE
        tileM.draw(g2);

        //OBJECT
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        //OBJECT
        for (int i = 0; i < npc.length; i++){
            if (npc[i] != null){
                npc[i].draw(g2);
            }
        }

        //PLAYER
        player.draw(g2);

        //UI
        ui.draw(g2);

        g2.dispose();
    }

    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(){
        music.stop();
    }

    public void playSFX(int i){
        sfx.setFile(i);
        sfx.play();
    }
}
