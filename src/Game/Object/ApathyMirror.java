package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ApathyMirror extends SuperObject{

    public ApathyMirror(GamePanel gp){
        name = "Mirror of Apathy";
        artifact = "Cursed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/mirror_of_apathy.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;

    }
}