package example.Content;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.*;
import mindustry.world.meta.Attribute;

import static example.Content.PermaItems.nickel;

public class PermaBlocks {
    public static Block
    // floors
    floorNickel,

    // walls
    wallGallium,

    basicDrill;
    public static  void load(){
        floorNickel = new OreBlock("floor-nickel-ore") {{
            itemDrop = nickel;
            oreDefault = true;
            variants = 3;
            oreScale = 10f;
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

        basicDrill = new Drill("basic-drill") {{
            drillTime = 10f;
            health = 100;
            tier = 2;
            squareSprite = true;
            drawSpinSprite = true;
            requirements(Category.production, ItemStack.with(nickel, 10));
        }};
    }
}
