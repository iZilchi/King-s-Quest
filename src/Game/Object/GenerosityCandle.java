package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GenerosityCandle extends SuperObject{
    public GenerosityCandle(GamePanel gp){
        name = "Candle of Generosity";
        artifact = "Blessed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/candle_of_generosity.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
