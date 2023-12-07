package Game.Tile;

import Game.minigame.UtilityTool;
import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[30];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/Minigame/Maps/n4map.txt");
    }

     public void getTileImage(){

            setup(0, "Floor", false);
            setup(1, "Walltop", true);
            setup(2, "Wallleft", true);
            setup(3, "Wallright", true);
            setup(4, "Wallbot", true);
            setup(5, "Walltopleft", true);
            setup(6, "Walltopright", true);
            setup(9, "Void", false);
            setup(10, "Wallbotleft", true);
            setup(11, "Wallbotright", true);
            setup(12, "Corrtopleft", true);
            setup(13, "Corrtopright", true);
            setup(14, "Corrbotleft", true);
            setup(15, "Corrbotright", true);
            setup(16, "Vertiwall", true);
            setup(17, "Horiwall", true);
            setup(18, "Downleftwall", true);
            setup(19, "Downrightwall", true);
            setup(20, "Upleftwall", true);
            setup(21, "Uprightwall", true);

     }

     public void setup(int index, String imagePath, boolean collision){
         UtilityTool uTool = new UtilityTool();

         try {
             tile[index] = new Tile();
             tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Tiles/" + imagePath + ".png"));
             tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
             tile[index].collision = collision;
         }catch (IOException e){
             e.printStackTrace();
         }
     }

     public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();

                while (col < gp.maxWorldCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
     }

     public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
     }
}
