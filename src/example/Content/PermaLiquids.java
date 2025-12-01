package example.Content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class PermaLiquids {

    public static Liquid
        moltenBismuth;

    public static void load()
    {
          moltenBismuth = new Liquid("moltenBismuth") {{
           coolant = false;
           viscosity = 0.6f;
           heatCapacity = 0.2f;
        }};
    }
}
