package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class EmpathyMirror extends SuperObject{
    public EmpathyMirror(GamePanel gp){
        name = "Mirror of Empathy";
        artifact = "Blessed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/mirror_of_empathy.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
