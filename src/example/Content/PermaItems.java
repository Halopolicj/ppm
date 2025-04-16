package example.Content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PermaItems {

    //Load Mod Items

    public static Item
            nickel, gallium;

    public static void load() {
        nickel = new Item("nickel") {{
            cost = 5;
            color = Color.valueOf("cbbd8a");
        }};
        gallium = new Item("gallium") {{
            cost = 10;
            color = Color.gray;
        }};
    }
}
