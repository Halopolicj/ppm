package example.Content;

import mindustry.game.Team;
import arc.graphics.Color;


import arc.Core;
import arc.graphics.g2d.*;
import arc.math.geom.Vec2;
import arc.struct.*;
import arc.util.*;
import mindustry.ui.Fonts;

public class PermaTeams {

    public static Team
    Stalgares, Glarstes, Fluvcorea;
    // i fucking forgot what words stalgares was a combo of
    // Glarstes glacies   superstes
    // fluviales scoriae  slag riversfolk

    // Yea no shit theres a mistake in faction names, i made them the fuck up
    // Thanks IntelliJ
    // Fucking hell now its trying to correct my swearing
    public static void load(){

        //TODO add team colors (green, blue, orange/red)
        Stalgares = newTeam(97, "Stalgares", Color.valueOf("ffffff"));
        Glarstes = newTeam(87, "Glarstes", Color.valueOf("aaaaaa"));
        Fluvcorea = newTeam(83, "Fluvcorea", Color.valueOf("bbbbbb"));
    }

    //modify any of 256 teams' properties <-taken from FOS mod (EXCUSE ME HOW MUCH?!)
    private static Team newTeam(int id, String name, Color color) {
        Team team = Team.get(id);
        team.name = name;
        team.color.set(color);

        team.palette[0] = color;
        team.palette[1] = color.cpy().mul(0.75f);
        team.palette[2] = color.cpy().mul(0.5f);

        for(int i = 0; i < 3; i++){
            team.palettei[i] = team.palette[i].rgba();
        }

        //attempt to load the team icon <- Taken from FOS mod,
        //i got no fucking idea what this does, might get rid of this
        Seq<Font> fonts = Seq.with(Fonts.def, Fonts.outline);

        var ch = 65000 + id;
        Reflect.<ObjectIntMap<String>>get(Fonts.class, "unicodeIcons").put(name, ch);
        var stringIcons = Reflect.<ObjectMap<String, String>>get(Fonts.class, "stringIcons");
        stringIcons.put(name, ((char)ch) + "");//i got no idea nor time to know & learn what this does and what to change

        int size = (int)(Fonts.def.getData().lineHeight/Fonts.def.getData().scaleY);
        TextureRegion region = Core.atlas.find("fos-team-" + name);
        Vec2 out = Scaling.fit.apply(region.width, region.height, size, size);
        Font.Glyph glyph = new Font.Glyph(){{
            id = ch;
            srcX = 0;
            srcY = 0;
            width = (int)out.x;
            height = (int)out.y;
            u = region.u;
            v = region.v2;
            u2 = region.u2;
            v2 = region.v;
            xoffset = 0;
            yoffset = -size;
            xadvance = size;
            kerning = null;
            fixedWidth = true;
            page = 0;
        }};
        fonts.each(f -> f.getData().setGlyph(ch, glyph));

        //now put whatever the heck we get for an emoji <- also from FOS mod,
        //and again i got no fucking idea what it does
        team.emoji = stringIcons.get(team.name, "");

        return team;
    }
}


