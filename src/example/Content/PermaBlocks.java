package example.Content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;

import mindustry.graphics.*;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.liquid.LiquidBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.content.UnitTypes;

import example.expand.blocks.defense.RegenWall;

import static mindustry.type.ItemStack.with;
import static mindustry.world.meta.Stat.buildTime;
import static mindustry.world.meta.Stat.input;


public class PermaBlocks {
    public static Block
            // floors
            floorNickel,

    //liquids
    liquidBismuth,

    // def
    nickelWall, nickelWallBig, zircWall, zircWallBig,

    //Turrets
    Hedgehog, aaTurret,

    //regen wall
    nanoWall, nanoWallBig,

    // env walls
    wallGallium,

    //distribution
    nickelConveyor, nickelRouter, nickelJunction, nickelBridge, nickelSorter, nickelSorterInv,
    nickelOverflow, nickelUnderflow,

    // production
    greenfactory, bismuthCristilizer,

    // drills
    basicDrill,
    //storage
    coreStasis, coreParity, coreFairness, coreJustice;



    public static void load() {
        floorNickel = new OreBlock("floor-nickel-ore") {{
            itemDrop = PermaItems.nickel;
            variants = 3;
            oreScale = 2f;
            oreThreshold = 0.5f;
            attributes.set(Attribute.get("Nickel"), .075f);
        }};
        //liquids
        liquidBismuth = new Floor("liquid-bismuth") {{
            isLiquid = true;
            albedo = 0.8f;
            drownTime = 240f;
            //TODO add status effect
            liquidDrop = PermaLiquids.moltenBismuth;
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
            health = 200;
            requirements(Category.defense, with(PermaItems.nickel, 6));
        }};
        nickelWallBig = new Wall("nickel-wall-big") {{
            health = 1000;
            size = 2;
            requirements(Category.defense, with(PermaItems.nickel, 24));
        }};

        zircWall = new Wall("zirc-wall") {{
           health = 500;
           requirements(Category.defense, with(PermaItems.zirconium, 6));
        }};

        zircWallBig = new Wall("zirc-wall-big") {{
            health = 2500;
            requirements(Category.defense, with(PermaItems.zirconium, 24));
        }};
        //Regen walls
        nanoWall = new RegenWall("nano-wall") {{
            requirements(Category.defense, with(PermaItems.nickel, 100, PermaItems.gallium, 10));
            health = 1000;
            hasItems = false;
            healPercent = 12f;
            conductivePower = true;
            connectedPower = true;
            consumesPower = true;
            consumePower(300f);

        }};

        nanoWallBig = new RegenWall("nano-wall-big") {{
            requirements(Category.defense, with(PermaItems.nickel, 100, PermaItems.gallium, 10));
            health = 4000;
            hasItems = false;
            healPercent = 12f;
            conductivePower = true;
            connectedPower = true;
            consumesPower = true;
            size = 2;
            consumePower(1200f);
        }};

        //Distribution
        nickelConveyor = new Conveyor("nickel-conveyor") {{
            speed = 4f / 60f;
            health = 50;
            itemCapacity = 2;
            buildCostMultiplier = 2f;
            requirements(Category.distribution, with(PermaItems.nickel, 1));
            junctionReplacement = nickelJunction;
            bridgeReplacement = nickelBridge;
        }};

        nickelRouter = new Router("nickel-router") {{
            health = 90;
            requirements(Category.distribution, with(PermaItems.nickel, 5, Items.lead, 3));
        }};

        nickelJunction = new Junction("nickel-junction") {{
            requirements(Category.distribution, with(PermaItems.nickel, 3));
            health = 90;
            speed = 3;
            capacity = 4;

        }};
        nickelBridge = new DuctBridge("nickel-bridge") {{
            requirements(Category.distribution, with(PermaItems.nickel, 10, Items.lead, 5));
            itemCapacity = 5;
            health = 100;
        }};

        nickelSorter = new Sorter("nickel-sorter") {{
            requirements(Category.distribution, with(PermaItems.nickel, 10, Items.lead, 5));
            itemCapacity = 2;
            health = 90;
        }};

        nickelSorterInv = new Sorter("nickel-sorter-inverted") {{
            requirements(Category.distribution, with(PermaItems.nickel, 10, Items.lead, 5));
            itemCapacity = 2;
            health = 90;
            invert = true;
        }};

        nickelOverflow = new OverflowGate("nickel-overflow"){{
           requirements(Category.distribution, with(PermaItems.nickel, 5, Items.lead, 5));
           itemCapacity = 2;
           health = 90;
        }};

        nickelUnderflow = new OverflowGate("nickel-underflow"){{
            requirements(Category.distribution, with(PermaItems.nickel, 5, Items.lead, 5));
            itemCapacity = 2;
            health = 90;
            invert = true;
        }};
        //Production
        greenfactory = new GenericCrafter("greenfactory") {{
            requirements(Category.crafting, with(PermaItems.gallium, 3));
            outputLiquids = LiquidStack.with(Liquids.gallium, 20f/60f);
            size = 2;
            consumeItem(PermaItems.gallium, 2);
            craftTime = 60f;

        }};

        bismuthCristilizer = new GenericCrafter("bismuth-crystalizer") {{
                requirements(Category.crafting, with(PermaItems.nickel, 50, Items.lead, 35));
                itemCapacity = 10;
                outputItems = with(PermaItems.bismuth, 2);
                consumeItem(Items.lead, 2);
                consumeLiquid(Liquids.water, 8f /60f);
                craftTime = 90f;
                ignoreLiquidFullness = true;
                hasPower = false;
                consumesPower = false;
                size = 2;

                drawer = new DrawMulti(
                        new DrawRegion("-bottom"),
                        new DrawLiquidTile(Liquids.water, 2f),
                        new DrawBubbles(Color.valueOf("7693e3")) {{
                            sides = 10;
                            recurrence = 3f;
                            spread = 6;
                            radius = 1.5f;
                            amount = 20;
                        }},
                        new DrawRegion(),
                        new DrawLiquidOutputs(),
                        new DrawGlowRegion() {{
                            alpha = 0.7f;
                            color = Color.valueOf("#ff73ab");
                            glowIntensity = 0.3f;
                            glowScale = 6f;
                        }},
                        new DrawRegion("-bis"),
                        new DrawLiquidTile(PermaLiquids.moltenBismuth, 2f)

                );
            }};
                //Drills
                basicDrill = new Drill("basic-drill") {{
                    drillTime = 800f;
                    health = 200;
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
                Hedgehog = new ItemTurret("Hedgehog") {{
                    requirements(Category.turret, with(PermaItems.nickel, 150, Items.lead, 100));
                    ammo(
                            PermaItems.nickel, new BasicBulletType(13f, 15) {{
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

                aaTurret = new ItemTurret("aaTurret") {{

                }};

            }

        }
