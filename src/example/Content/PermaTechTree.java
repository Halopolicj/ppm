package example.Content;

import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static arc.struct.Seq.with;
import static mindustry.content.TechTree.*;
import static example.Content.PermaItems.*;
import static example.Content.PermaBlocks.*;

public class PermaTechTree {
    public static void load() {
        PermaPlanets.Gleo.techTree = nodeRoot("Gleo", coreStasis, () -> {
            //distribution
            node(nickelConveyor, () -> {
                node(nickelJunction, () -> {
                   node(nickelRouter, () ->{
                      node(nickelBridge, () ->{

                      });
                      //TODO add sorterts and gates

                   });
                });
            });

            //walls
            node(nickelWall, () ->{
                node(nickelWallBig, () -> {
                });
                //TODO add more walls & make nano walls branch off of the strongest normal wall
            });

            //drills
            node(basicDrill, () -> {
               //TODO add pre gallium wall drill & better drills, possibly post gallium
            });

            //storage
            node(coreStasis, () -> {
                node(coreFairness, () -> {
                   node(coreParity, () -> {
                       node(coreJustice, () -> {

                       });
                   });
                });
            });



            //items
            nodeProduce(nickel, () -> {
                nodeProduce(Items.lead, () -> {
                    //TODO add something between lead and gallium, maybe bismuth?
                });
            });
        });
    }
}