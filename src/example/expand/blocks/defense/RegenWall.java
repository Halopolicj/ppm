package example.expand.blocks.defense;

import arc.graphics.g2d.TextureRegion;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.*;
import arc.Core;
import static mindustry.Vars.*;

public class RegenWall extends Wall {
    public TextureRegion[] atlasRegion;
    public float healPercent = 12f / 60f;
    public RegenWall(String name) {
        super(name);
        size = 1;
        insulated = true;
        absorbLasers = true;
        crushDamageMultiplier = 1f;
        clipSize = tilesize * 2 + 2;
    }



    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.repairTime, (int)(1f / (healPercent / 100f) / 60f), StatUnit.seconds);
    }
}


