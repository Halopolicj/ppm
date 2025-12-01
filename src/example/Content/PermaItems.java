package example.Content;

import arc.graphics.Color;
import mindustry.type.Item;

public class PermaItems {

    //Load Mod Items

    public static Item
            nickel, gallium, zirconium, bismuth;

    public static void load() {
        nickel = new Item("nickel") {{
            cost = 0.4f;
            color = Color.valueOf("cbbd8a99");//So the color in my pixelart program is different in every other program? What the fuck do you want me to do with it?
            hardness=1;
        }};
        gallium = new Item("gallium") {{
            cost = 1.8f;
            color = Color.gray;
            hardness = 3;
        }};
        bismuth = new Item("bismuth") {{
            cost = 1f;
            hardness = 2;
            charge = 1f;
            //how the hell do i make the color rainbow
            color = Color.coral;//I got no idea how the coral color looks
        }};
        zirconium = new Item("zirconium") {{
           cost =  1.4f;
            charge = 0.7f;
            //TODO add cool color probably blue-ish
        }};
    }
}
