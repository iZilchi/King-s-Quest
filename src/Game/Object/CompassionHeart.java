package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class CompassionHeart extends SuperObject{

    public CompassionHeart(GamePanel gp){
        name = "Heart of Compassion";
        artifact = "Blessed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/heart_of_compassion.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
