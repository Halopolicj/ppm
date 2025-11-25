package example.Content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class PermaLiquids {

    public static Liquid
        liquidBismuth;

    public static void load()
    {
        liquidBismuth = new Liquid("liquidBismuth") {{
           coolant = false;
           viscosity = 0.6f;
           heatCapacity = 0.2f;
        }};
    }
}
