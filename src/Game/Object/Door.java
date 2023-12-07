package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends SuperObject{

    public Door(GamePanel gp){
        name = "Door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/Door.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;

    }
}
