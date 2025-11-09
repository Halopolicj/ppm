package example.Content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;
import mindustry.content.UnitTypes;

import example.expand.blocks.defense.RegenWall;


public class PermaBlocks {
    public static Block
    // floors
    floorNickel,

    // def
    nickelWall, nickelWallBig,

    //regen wall
    nanoWall, nanoWallBig,

    // env walls
    wallGallium,

    //distribution
    nickelConveyor, nickelRouter, nickelJunction, nickelBridge,

    // drills
    basicDrill,
    //storage
    coreStasis, coreParity, coreFairness, coreJustice;

    public static  void load(){
        floorNickel = new OreBlock("floor-nickel-ore") {{
            itemDrop = PermaItems.nickel;
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

        //Regen walls
        nanoWall = new RegenWall("nano-wall") {{
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 100, PermaItems.gallium, 10));
           health=1000;
           hasItems = false;
           healPercent = 12f;
           conductivePower=true;
           connectedPower=true;
           consumesPower=true;
           consumePower(300f);

        }};

        nanoWallBig = new RegenWall("nano-wall-big") {{
            requirements(Category.defense, ItemStack.with(PermaItems.nickel, 100, PermaItems.gallium, 10));
            health=4000;
            hasItems = false;
            healPercent = 12f;
            conductivePower=true;
            connectedPower=true;
            consumesPower=true;
            consumePower(1200f);
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
            health = 90;
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
            drillTime = 120f;
            health = 100;
            tier = 1;
            size = 2;
            squareSprite = true;
            drawSpinSprite = true;
            drawMineItem = true;
            requirements(Category.production, ItemStack.with(PermaItems.nickel, 16));
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
           requirements(Category.effect, ItemStack.with(PermaItems.nickel, 2000, Items.lead, 2000));
        }};

        coreFairness = new CoreBlock("core-fairness") {{
           size = 4;
           itemCapacity = 4000;
           health = 3500;
           unitCapModifier = 20;
           drawTeamOverlay = true;
           unitType = UnitTypes.mega;
           requirements(Category.effect, ItemStack.with(PermaItems.nickel, 3000, Items.lead, 3000));
        }};

        coreParity = new CoreBlock("core-parity") {{
           size = 4;
           itemCapacity = 6000;
           health = 4500;
           unitCapModifier = 25;
           drawTeamOverlay = true;
           unitType = UnitTypes.quad;
           requirements(Category.effect, ItemStack.with(PermaItems.nickel, 4000, Items.lead, 4000));
        }};

        coreJustice = new CoreBlock("core-justice") {{
           size = 5;
           itemCapacity = 10000;
           health = 8000;
           unitCapModifier = 30;
           drawTeamOverlay = true;
           unitType = UnitTypes.oct;
           requirements(Category.effect, ItemStack.with(PermaItems.nickel, 5000, Items.lead, 5000));
        }};
    }
}
