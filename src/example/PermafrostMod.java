package example;

import arc.*;
import arc.util.*;
import example.Content.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class PermafrostMod extends Mod{

    public PermafrostMod(){
        Log.info("Loaded PermafrostMod constructor.");


    }

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
        // stolen from BetaMindy hehehe :troll:
        //OverWriter.load();
        //MindyStatusEffects.load();
        //MindyLiquids.load();
        // MindyItems.load();
        //MindyBullets.load();
        //ShopItems.load();
        //FireColor.load();
        //MindyBlocks.load();
        //MindyWeathers.load();
        //MindyPlanets.load();
        //MindySectors.load();
        //MindyTechTree.load();
        PermaAttributes.load();//When the fuck did i make this file, also i like the word fuck
        PermaItems.load();
        PermaBlocks.load();
        PermaPlanets.load();
        PermaSectorPresets.load();
        PermaTechTree.load();
        PermaTeams.load();
    }

}
