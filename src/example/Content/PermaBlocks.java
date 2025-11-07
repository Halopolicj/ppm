package example.Content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.MendProjector;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;
import mindustry.content.UnitTypes;



public class PermaBlocks {
    public static Block
    // floors
    floorNickel,

    // def walls
    nickelWall, nickelWallBig, nanoWall, nanoWallBig,

    // env walls
    wallGallium,

    //distribution
    nickelConveyor, nickelRouter, nickelJunction, nickelBridge,

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

        //Defense
        nickelWall = new Wall("nickel-wall") {{
            health=200;
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 6));
        }};
        nickelWallBig = new Wall("nickel-wall-big") {{
            health=1000;
            size=2;
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 24));
        }};

        nanoWall = new MendProjector("nano-wall") {{
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 100, PermaItems.gallium, 10));
           health=1000;
           hasItems = false;
           healPercent = 3f;
           outputsPower=true;
           range=1f;
        }};

        nanoWallBig = new MendProjector("nano-wall-big") {{
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 100, PermaItems.gallium, 10));
            health=4000;
            hasItems = false;
            healPercent = 3f;
            outputsPower=true;
            range=1f;
        }};

        //Distribution
        nickelConveyor = new Conveyor("nickel-conveyor") {{
           speed = 0.05f;
           health = 50;
           itemCapacity = 2;
           buildCostMultiplier = 2f;
           requirements(Category.distribution, ItemStack.with(PermaItems.nickel, 1));
        }};

        nickelRouter = new Router("nickel-router"){{
            //requirements(Category.distribution, with(Items.beryllium, 10));
            health = 90;
            researchCost = ItemStack.with(PermaItems.nickel, 30, Items.lead, 20);
            requirements(Category.distribution, ItemStack.with(PermaItems.nickel, 10, Items.lead, 5));
        }};

        nickelJunction = new Junction("nickel-junction"){{
           requirements(Category.distribution, ItemStack.with(PermaItems.nickel, 3));
           health = 90;

        }};
        nickelBridge = new DirectionBridge("nickel-bridge"){{
            requirements(Category.distribution, ItemStack.with(PermaItems.nickel, 20, Items.lead, 10));
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
