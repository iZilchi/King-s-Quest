package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ForgivingAmulet extends SuperObject {
    public ForgivingAmulet(GamePanel gp) {
        name = "Forgiving Amulet";
        artifact = "Blessed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/forgiving_amulet.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
