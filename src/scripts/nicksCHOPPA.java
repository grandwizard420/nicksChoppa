package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Skills;
import org.tribot.script.Script;
import scripts.NicksAPI.Woodcutting;
import scripts.nickschoppa.Chopping;
import scripts.nickschoppa.Dropping;
import scripts.nickschoppa.WalkToTrees;

public class nicksCHOPPA extends Script {
    @Override
    public void run() {
        Chopping Chop = new Chopping("Tree", Woodcutting.Locations.LUM_NORMAL);
        Dropping Drop = new Dropping();
        WalkToTrees Walk = new WalkToTrees(Woodcutting.Locations.LUM_NORMAL);
        while (Skills.getActualLevel(Skills.SKILLS.WOODCUTTING) < 20){
            if(Chop.validate())
                Chop.execute();
            if(Drop.validate())
                Drop.execute();
            if(Walk.validate())
                Walk.execute();
            if(Interfaces.get(595, 37) != null)
                Interfaces.get(595, 37).click("Close");
            General.sleep(100);
        }

        Chop = new Chopping("Oak", Woodcutting.Locations.LUM_OAK);
        Drop = new Dropping();
        Walk = new WalkToTrees(Woodcutting.Locations.LUM_OAK);
        while (Skills.getActualLevel(Skills.SKILLS.WOODCUTTING) < 30){
            if(Chop.validate())
                Chop.execute();
            if(Drop.validate())
                Drop.execute();
            if(Walk.validate())
                Walk.execute();
            if(Interfaces.get(595, 37) != null)
                Interfaces.get(595, 37).click("Close");
            General.sleep(100);
        }

        Chop = new Chopping("Willow", Woodcutting.Locations.LUM_WILLOW);
        Drop = new Dropping();
        Walk = new WalkToTrees(Woodcutting.Locations.LUM_WILLOW);
        while (Skills.getActualLevel(Skills.SKILLS.WOODCUTTING) < 99) {
            if (Chop.validate())
                Chop.execute();
            if (Drop.validate())
                Drop.execute();
            if (Walk.validate())
                Walk.execute();
            if (Interfaces.get(595, 37) != null)
                Interfaces.get(595, 37).click("Close");
            General.sleep(100);
        }
    }
}
