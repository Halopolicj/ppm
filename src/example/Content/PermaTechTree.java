package example.Content;

import mindustry.content.*;
import mindustry.game.Objectives.*;

import static arc.struct.Seq.with;
import static mindustry.content.TechTree.*;
import static example.Content.PermaItems.*;
import static example.Content.PermaBlocks.*;

public class PermaTechTree {
    public static void load() {
        PermaPlanets.Ice.techTree = nodeRoot("ss", coreStasis, () -> {
            node(coreStasis);
        });
    }
}