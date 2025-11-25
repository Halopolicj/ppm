package example.Content;

import arc.struct.ObjectFloatMap;
import mindustry.content.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;


import static arc.struct.Seq.with;
import static mindustry.content.TechTree.*;
import static example.Content.PermaItems.*;
import static example.Content.PermaBlocks.*;

public class PermaTechTree {

    static ObjectFloatMap<Item> costs = new ObjectFloatMap<>();

    public static void load() {

        costs.put(nickel, 0.05f);
        costs.put(Items.lead, 0.06f);
        costs.put(gallium, 0.9f);


        PermaPlanets.Gleo.techTree = nodeRoot("Gleo", coreStasis, () -> {
            context().researchCostMultipliers = costs;

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

                //Turrets
                node(Hedgehog, () ->{
                   node(aaTurret, () -> {

                   });
                });
                //TODO add more walls & make nano walls branch off of the strongest normal wall
            });

            //drills
            node(basicDrill, () -> {
               //TODO add pre gallium wall drill & better drills, possibly post gallium
            });

            //Crafting
            node(bismuthCristilizer, () -> {

            });


            //storage

            node(coreFairness, () -> {
                node(coreParity, () -> {
                    node(coreJustice, () -> {

                    });
                });
            });




            //items
            nodeProduce(nickel, () -> {
                nodeProduce(Items.lead, () -> {
                    nodeProduce(bismuth, () -> {
                       nodeProduce(gallium, () -> {

                       }) ;
                    });
                    //TODO add something between lead and gallium, maybe bismuth?
                });

                //Liquids
                nodeProduce(Liquids.water, () -> {
                   nodeProduce(Liquids.gallium, () -> {

                   });
                });
            });
        });
    }
}