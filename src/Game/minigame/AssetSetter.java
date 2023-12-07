package Game.minigame;

import Game.Entity.NPC_Witch;
import Game.Object.Door;
import Game.Object.EmpathyMirror;
import Game.Object.GenerosityCandle;
import Game.Object.ForgivingAmulet;
import Game.Object.CompassionHeart;

import Game.Object.ApathyMirror;
import Game.Object.SelfishCandle;
import Game.Object.BitterAmulet;
import Game.Object.IndifferenceStone;


public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject(){

        //ROOM 1
        gp.obj[0] = new EmpathyMirror(gp);
        gp.obj[0].worldX = 28 * gp.tileSize;
        gp.obj[0].worldY = 4 * gp.tileSize;

        gp.obj[1] = new ApathyMirror(gp);
        gp.obj[1].worldX = 30 * gp.tileSize;
        gp.obj[1].worldY = gp.tileSize;

        gp.obj[2] = new ApathyMirror(gp);
        gp.obj[2].worldX = 30 * gp.tileSize;
        gp.obj[2].worldY = 2 * gp.tileSize;

        gp.obj[3] = new ApathyMirror(gp);
        gp.obj[3].worldX = 30 * gp.tileSize;
        gp.obj[3].worldY = 3 * gp.tileSize;

        gp.obj[4] = new ApathyMirror(gp);
        gp.obj[4].worldX = 30 * gp.tileSize;
        gp.obj[4].worldY = 4 * gp.tileSize;

        gp.obj[5] = new EmpathyMirror(gp);
        gp.obj[5].worldX = 32 * gp.tileSize;
        gp.obj[5].worldY = 4 * gp.tileSize;

        gp.obj[6] = new ApathyMirror(gp);
        gp.obj[6].worldX = 34 * gp.tileSize;
        gp.obj[6].worldY = 4 * gp.tileSize;

        gp.obj[7] = new ApathyMirror(gp);
        gp.obj[7].worldX = 34 * gp.tileSize;
        gp.obj[7].worldY = 5 * gp.tileSize;

        gp.obj[8] = new ApathyMirror(gp);
        gp.obj[8].worldX = 34 * gp.tileSize;
        gp.obj[8].worldY = 6 * gp.tileSize;

        gp.obj[9] = new ApathyMirror(gp);
        gp.obj[9].worldX = 34 * gp.tileSize;
        gp.obj[9].worldY = 7 * gp.tileSize;

        //ROOM 2
        gp.obj[10] = new SelfishCandle(gp);
        gp.obj[10].worldX = 26 * gp.tileSize;
        gp.obj[10].worldY = 22 * gp.tileSize;

        gp.obj[11] = new SelfishCandle(gp);
        gp.obj[11].worldX = 27 * gp.tileSize;
        gp.obj[11].worldY = 22 * gp.tileSize;

        gp.obj[12] = new GenerosityCandle(gp);
        gp.obj[12].worldX = 23 * gp.tileSize;
        gp.obj[12].worldY = 22 * gp.tileSize;

        gp.obj[13] = new SelfishCandle(gp);
        gp.obj[13].worldX = 24 * gp.tileSize;
        gp.obj[13].worldY = 25 * gp.tileSize;

        gp.obj[14] = new SelfishCandle(gp);
        gp.obj[14].worldX = 30 * gp.tileSize;
        gp.obj[14].worldY = 25 * gp.tileSize;

        gp.obj[15] = new GenerosityCandle(gp);
        gp.obj[15].worldX = 30 * gp.tileSize;
        gp.obj[15].worldY = 26 * gp.tileSize;

        gp.obj[16] = new SelfishCandle(gp);
        gp.obj[16].worldX = 32 * gp.tileSize;
        gp.obj[16].worldY = 22 * gp.tileSize;

        gp.obj[17] = new SelfishCandle(gp);
        gp.obj[17].worldX = 33 * gp.tileSize;
        gp.obj[17].worldY = 22 * gp.tileSize;

        //ROOM 3
        gp.obj[18] = new BitterAmulet(gp);
        gp.obj[18].worldX = 53 * gp.tileSize;
        gp.obj[18].worldY = 21 * gp.tileSize;

        gp.obj[19] = new BitterAmulet(gp);
        gp.obj[19].worldX = 53 * gp.tileSize;
        gp.obj[19].worldY = 22 * gp.tileSize;

        gp.obj[20] = new ForgivingAmulet(gp);
        gp.obj[20].worldX = 53 * gp.tileSize;
        gp.obj[20].worldY = 24 * gp.tileSize;

        gp.obj[21] = new ForgivingAmulet(gp);
        gp.obj[21].worldX = 53 * gp.tileSize;
        gp.obj[21].worldY = 25 * gp.tileSize;

        gp.obj[22] = new BitterAmulet(gp);
        gp.obj[22].worldX = 48 * gp.tileSize;
        gp.obj[22].worldY = 27 * gp.tileSize;

        gp.obj[23] = new BitterAmulet(gp);
        gp.obj[23].worldX = 50 * gp.tileSize;
        gp.obj[23].worldY = 27 * gp.tileSize;

        gp.obj[24] = new BitterAmulet(gp);
        gp.obj[24].worldX = 53 * gp.tileSize;
        gp.obj[24].worldY = 28 * gp.tileSize;

        gp.obj[25] = new BitterAmulet(gp);
        gp.obj[25].worldX = 55 * gp.tileSize;
        gp.obj[25].worldY = 28 * gp.tileSize;

        gp.obj[26] = new BitterAmulet(gp);
        gp.obj[26].worldX = 57 * gp.tileSize;
        gp.obj[26].worldY = 26 * gp.tileSize;

        gp.obj[27] = new BitterAmulet(gp);
        gp.obj[27].worldX = 57 * gp.tileSize;
        gp.obj[27].worldY = 24 * gp.tileSize;

        gp.obj[28] = new BitterAmulet(gp);
        gp.obj[28].worldX = 58 * gp.tileSize;
        gp.obj[28].worldY = 22 * gp.tileSize;

        gp.obj[29] = new BitterAmulet(gp);
        gp.obj[29].worldX = 58 * gp.tileSize;
        gp.obj[29].worldY = 20 * gp.tileSize;

        gp.obj[30] = new BitterAmulet(gp);
        gp.obj[30].worldX = 52 * gp.tileSize;
        gp.obj[30].worldY = 24 * gp.tileSize;

        gp.obj[31] = new BitterAmulet(gp);
        gp.obj[31].worldX = 54 * gp.tileSize;
        gp.obj[31].worldY = 24 * gp.tileSize;

        gp.obj[32] = new BitterAmulet(gp);
        gp.obj[32].worldX = 52 * gp.tileSize;
        gp.obj[32].worldY = 25 * gp.tileSize;

        gp.obj[33] = new BitterAmulet(gp);
        gp.obj[33].worldX = 54 * gp.tileSize;
        gp.obj[33].worldY = 25 * gp.tileSize;

        //ROOM 4
        gp.obj[34] = new IndifferenceStone(gp);
        gp.obj[34].worldX = 53 * gp.tileSize;
        gp.obj[34].worldY = 8 * gp.tileSize;

        gp.obj[35] = new IndifferenceStone(gp);
        gp.obj[35].worldX = 53 * gp.tileSize;
        gp.obj[35].worldY = 10 * gp.tileSize;

        gp.obj[36] = new CompassionHeart(gp);
        gp.obj[36].worldX = 54 * gp.tileSize;
        gp.obj[36].worldY = 10 * gp.tileSize;

        gp.obj[37] = new IndifferenceStone(gp);
        gp.obj[37].worldX = 45 * gp.tileSize;
        gp.obj[37].worldY = 8 * gp.tileSize;

        gp.obj[38] = new IndifferenceStone(gp);
        gp.obj[38].worldX = 46 * gp.tileSize;
        gp.obj[38].worldY = 6 * gp.tileSize;

        gp.obj[39] = new IndifferenceStone(gp);
        gp.obj[39].worldX = 45 * gp.tileSize;
        gp.obj[39].worldY = 4 * gp.tileSize;

        gp.obj[40] = new IndifferenceStone(gp);
        gp.obj[40].worldX = 46 * gp.tileSize;
        gp.obj[40].worldY = 2 * gp.tileSize;

        gp.obj[41] = new IndifferenceStone(gp);
        gp.obj[41].worldX = 49 * gp.tileSize;
        gp.obj[41].worldY = gp.tileSize;

        gp.obj[42] = new IndifferenceStone(gp);
        gp.obj[42].worldX = 48 * gp.tileSize;
        gp.obj[42].worldY = 3 * gp.tileSize;

        gp.obj[43] = new IndifferenceStone(gp);
        gp.obj[43].worldX = 49 * gp.tileSize;
        gp.obj[43].worldY = 5 * gp.tileSize;

        gp.obj[44] = new IndifferenceStone(gp);
        gp.obj[44].worldX = 52 * gp.tileSize;
        gp.obj[44].worldY = 6 * gp.tileSize;

        gp.obj[45] = new IndifferenceStone(gp);
        gp.obj[45].worldX = 51 * gp.tileSize;
        gp.obj[45].worldY = 4 * gp.tileSize;

        gp.obj[46] = new IndifferenceStone(gp);
        gp.obj[46].worldX = 52 * gp.tileSize;
        gp.obj[46].worldY = 2 * gp.tileSize;

        gp.obj[47] = new IndifferenceStone(gp);
        gp.obj[47].worldX = 55 * gp.tileSize;
        gp.obj[47].worldY = gp.tileSize;

        gp.obj[48] = new IndifferenceStone(gp);
        gp.obj[48].worldX = 54 * gp.tileSize;
        gp.obj[48].worldY = 3 * gp.tileSize;

        gp.obj[49] = new IndifferenceStone(gp);
        gp.obj[49].worldX = 55 * gp.tileSize;
        gp.obj[49].worldY = 5 * gp.tileSize;

        gp.obj[50] = new CompassionHeart(gp);
        gp.obj[50].worldX = 56 * gp.tileSize;
        gp.obj[50].worldY = 6 * gp.tileSize;

        gp.obj[51] = new Door(gp);
        gp.obj[51].worldX = 75 * gp.tileSize;
        gp.obj[51].worldY = 5 * gp.tileSize;
    }

    public void setNPC(){
        gp.npc[0] = new NPC_Witch(gp);
        gp.npc[0].worldX = 8 * gp.tileSize;
        gp.npc[0].worldY = 5 * gp.tileSize;
    }
}
