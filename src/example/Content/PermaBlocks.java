package example.Content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;

import mindustry.graphics.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.*;
import mindustry.content.UnitTypes;


import example.expand.blocks.defense.RegenWall;

import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.Stat.buildTime;


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
    coreStasis, coreParity, coreFairness, coreJustice,

    //Turrets
    turret, aaTurret;

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
            requirements(Category.defense, with(PermaItems.nickel, 6));
        }};
        nickelWallBig = new Wall("nickel-wall-big") {{
            health=1000;
            size=2;
            requirements(Category.defense, with(PermaItems.nickel, 24));
        }};

        //Regen walls
        nanoWall = new RegenWall("nano-wall") {{
            requirements(Category.defense, with(PermaItems.nickel, 100, PermaItems.gallium, 10));
           health=1000;
           hasItems = false;
           healPercent = 12f;
           conductivePower=true;
           connectedPower=true;
           consumesPower=true;
           consumePower(300f);

        }};

        nanoWallBig = new RegenWall("nano-wall-big") {{
            requirements(Category.defense, with(PermaItems.nickel, 100, PermaItems.gallium, 10));
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
           speed = 2f / 60f;
           health = 50;
           itemCapacity = 2;
           buildCostMultiplier = 2f;
           requirements(Category.distribution, with(PermaItems.nickel, 1));
        }};

        nickelRouter = new Router("nickel-router"){{
            health = 90;
            requirements(Category.distribution, with(PermaItems.nickel, 10, Items.lead, 5));
        }};

        nickelJunction = new Junction("nickel-junction"){{
           requirements(Category.distribution, with(PermaItems.nickel, 3));
           health = 90;
           speed = 3;
           capacity = 4;

        }};
        nickelBridge = new DuctBridge("nickel-bridge"){{
            requirements(Category.distribution, with(PermaItems.nickel, 20, Items.lead, 10));
            itemCapacity = 5;
        }};


        //Drills
        basicDrill = new Drill("basic-drill") {{
            drillTime = 400f;
            health = 100;
            tier = 1;
            size = 2;
            squareSprite = true;
            drawSpinSprite = true;
            drawMineItem = true;
            requirements(Category.production, with(PermaItems.nickel, 16));
        }};

        //Storage
        coreStasis = new CoreBlock("core-stasis") {{
           isFirstTier = true;
           alwaysUnlocked = true;
           size = 3;
           itemCapacity = 2000;
           health = 2000;
           unitCapModifier = 15;
           unitType = UnitTypes.poly;
           drawTeamOverlay = true;
           requirements(Category.effect, with(PermaItems.nickel, 2000, Items.lead, 2000));
        }};

        coreFairness = new CoreBlock("core-fairness") {{
           size = 4;
           itemCapacity = 4000;
           health = 3500;
           unitCapModifier = 20;
           drawTeamOverlay = true;
           unitType = UnitTypes.mega;
           requirements(Category.effect, with(PermaItems.nickel, 3000, Items.lead, 3000));
        }};

        coreParity = new CoreBlock("core-parity") {{
           size = 4;
           itemCapacity = 6000;
           health = 4500;
           unitCapModifier = 25;
           drawTeamOverlay = true;
           unitType = UnitTypes.quad;
           requirements(Category.effect, with(PermaItems.nickel, 4000, Items.lead, 4000));
        }};

        coreJustice = new CoreBlock("core-justice") {{
           size = 5;
           description = "Justice shall be served. Final core upgrade";
           itemCapacity = 10000;
           health = 8000;
           unitCapModifier = 30;
           drawTeamOverlay = true;
           unitType = UnitTypes.oct;
           requirements(Category.effect, with(PermaItems.nickel, 5000, Items.lead, 5000));
        }};

        //Turrets
        turret = new ItemTurret("turret"){{
            requirements(Category.turret, with(PermaItems.nickel, 150, Items.lead, 100));
            ammo(
                    PermaItems.nickel,  new BasicBulletType(13f, 15){{
                        width = 5f;
                        height = 7f;
                        lifetime = 60f;
                        ammoMultiplier = 1;
                        pierce = false;


                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = PermaItems.nickel.color;
                        frontColor = PermaItems.nickel.color;
                    }}
                    /*Items.graphite, new BasicBulletType(3.5f, 18){{
                        width = 9f;
                        height = 12f;
                        ammoMultiplier = 4;
                        lifetime = 60f;
                        rangeChange = 16f;

                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.accentBack;
                        frontColor = Pal.plastaniumFront;
                    }},*/
                    /*Items.silicon, new BasicBulletType(3f, 12){{
                        width = 7f;
                        height = 9f;
                        homingPower = 0.2f;
                        reloadMultiplier = 1.5f;
                        ammoMultiplier = 5;
                        lifetime = 60f;

                        trailLength = 5;
                        trailWidth = 1.5f;

                        hitEffect = despawnEffect = Fx.hitBulletColor;
                        hitColor = backColor = trailColor = Pal.bulletYellowBack;
                        frontColor = Pal.lightishGray;
                    }}*/
            );


            recoils = 2;
            /*drawer = new DrawTurret("normal"){{
                for(int i = 0; i < 2; i ++){
                    int f = i;
                    parts.add(new RegionPart("-barrel" + (i == 0 ? "l" : "r")){{
                        progress = PartProgress.recoil;
                        outline = true;
                        under = true;
                        moveY = -1.5f;
                    }});
                }
            }};*/

            recoil = 0.5f;
            shootY = 3f;
            reload = 20f;
            range = 160;
            shootCone = 15f;
            ammoUseEffect = Fx.casing1;
            health = 670;
            rotateSpeed = 10f;
            coolant = consumeCoolant(0.1f);
            researchCostMultiplier = 0.05f;
            size = 2;


            limitRange(5f);
        }};

        aaTurret = new ItemTurret("aaTurret"){{

        }};
                
    }
    
}
