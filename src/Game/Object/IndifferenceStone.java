package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class IndifferenceStone extends SuperObject{
    public IndifferenceStone(GamePanel gp){
        name = "Stone of Indifference";
        artifact = "Cursed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/stone_of_indifference.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
