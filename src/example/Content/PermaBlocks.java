package example.Content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;
import mindustry.content.UnitTypes;



public class PermaBlocks {
    public static Block
    // floors
    floorNickel,

    // walls
    wallGallium,

    //distribution
    nickelConveyor,

    // drills
    basicDrill,
    //storage
    coreStasis;

    public static  void load(){
        floorNickel = new OreBlock("floor-nickel-ore") {{
            itemDrop = PermaItems.nickel;
            oreDefault = true;
            variants = 3;
            oreScale = 2f;
            oreThreshold = 0.5f;
            attributes.set(Attribute.get("Nickel"), .075f);
            }};

        //walls
        wallGallium = new OreBlock("wall-gallium-ore") {{
            variants = 1;
           itemDrop = PermaItems.gallium;
           oreThreshold = 0.4f;
           oreScale = 1.5f;
           wallOre = true;
           //attributes.set(Attribute.get("Gallium"), .09f);
        }};
        //Distribution
        nickelConveyor = new Conveyor("nickel-conveyor") {{
           speed = 0.05f;
           health = 50;
           itemCapacity = 2;
           buildCostMultiplier = 2f;
        }};
        //Drills
        basicDrill = new Drill("basic-drill") {{
            drillTime = 160f;
            health = 100;
            tier = 2;
            squareSprite = true;
            drawSpinSprite = true;
            requirements(Category.production, ItemStack.with(PermaItems.nickel, 10));
        }};
        //Storage
        coreStasis = new CoreBlock("core-stasis") {{
           isFirstTier = true;
           size = 3;
           itemCapacity = 2000;
           health = 2000;
           unitCapModifier = 15;
           unitType = UnitTypes.poly;
           drawTeamOverlay = true;

        }};
    }
}
