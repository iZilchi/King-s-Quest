package Game.Object;

import Game.minigame.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BitterAmulet extends SuperObject{
    public BitterAmulet(GamePanel gp) {
        name = "Bitter Amulet";
        artifact = "Cursed";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Minigame/Objects/bitter_amulet.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }

        collision = true;
    }
}
