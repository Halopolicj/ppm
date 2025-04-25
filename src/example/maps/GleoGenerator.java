package example.maps;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import arc.util.noise.*;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.maps.generators.*;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class GleoGenerator extends ErekirPlanetGenerator {

    Block[] terrain = {Blocks.redStone, Blocks.yellowStone, Blocks.redStone, Blocks.denseRedStone, Blocks.yellowStonePlates};

    {
        baseSeed = 2;

    }
}