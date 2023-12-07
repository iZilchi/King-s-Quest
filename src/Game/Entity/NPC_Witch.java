package Game.Entity;

import Game.minigame.GamePanel;


public class NPC_Witch extends Entity {

    public NPC_Witch(GamePanel gp) {
        super(gp);

        name = "Witch";
        image = setup("/Minigame/NPC/Witch");
        uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        setDialogue();
    }

    public void setDialogue(){
            dialogues[0] = "Ah, King, thou hast descended to face this trial. \nWelcome to my Dungeon! \nHerein lies a quest of great valor";
            dialogues[1] = "...Wh-What's that? What happened to your equipment?\nOh... I took it! HIHIHIHIHI~~~~\nOvercome this trial if you want them back!";
            dialogues[2] = "Thou must seek 8 Blessed Artifacts within the labyrinth.\nEach artifact carries the essence of: \nEMPATHY, GENEROSITY, FORGIVENESS, \nand COMPASSION.";
            dialogues[3] = "But beware, King, for there also exist Cursed Artifacts: \nAPATHY, SELFISHNESS, BITTER, INDIFFERENCE\nTouch them not for they will hinder thy quest.";
            dialogues[4] = "Collect all of the Blessed Artifacts\nand thou shalt awaken from your slumber.";
            dialogues[5] = "The door at the end of this labyrinth\nshall be unlocked once you posses the 8 artifacts.";
            dialogues[6] = "Fail to do so and thou shalt be TRAPPED\nin this dungeon FOREVERRR!! HIHIHIHIHIHI~~~";
    }

    public void speak(){
        super.speak();
    }
}
