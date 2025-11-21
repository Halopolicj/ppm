package example.Content;

import mindustry.type.SectorPreset;

public class PermaSectorPresets {
    public static SectorPreset Beginning;

    public static void load(){

        Beginning = new SectorPreset("Beginning", PermaPlanets.Gleo, 15){{
            captureWave = 10;
            difficulty = 1;
            overrideLaunchDefaults = true;
            alwaysUnlocked = true;
            addStartingItems = true;

            rules = r -> {
                r.winWave = captureWave;
            };
        }};
    }
}
