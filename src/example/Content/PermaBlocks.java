package example.Content;

import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.meta.Attribute;
import example.Content.PermaAttributes;

import static example.Content.PermaItems.nickel;

public class PermaBlocks {
    public static Block
    // floors
    floorNickel,

    // walls
    wallGallium;
    public static  void load(){
        floorNickel = new Floor("floor-nickel-ore", 3) {{
            itemDrop = nickel;
            attributes.set(Attribute.get("Nickel"), .075f);
            }};

        //walls
        wallGallium = new StaticWall("wall-gallium-ore") {{
            variants = 3;
           itemDrop = PermaItems.gallium;
           attributes.set(Attribute.get("Gallium"), .09f);
        }};

    }
}
