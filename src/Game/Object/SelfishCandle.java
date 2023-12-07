package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SelfishCandle extends SuperObject {
    public SelfishCandle(GamePanel gp){
        name = "Selfish Candle";
        artifact = "Cursed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/candle_of_selfishness.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
