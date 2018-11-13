package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import scripts.NicksAPI.Node;
import scripts.NicksAPI.Woodcutting;
import scripts.NicksChoppa.Chopping;
import scripts.NicksChoppa.Dropping;
import scripts.NicksChoppa.WalkToTrees;

public class nicksCHOPPA extends Script {
    @Override
    public void run() {
        Chopping Chop = new Chopping("Oak");
        Dropping Drop = new Dropping();
        WalkToTrees Walk = new WalkToTrees(Woodcutting.Locations.LUM_OAK);
        while (true){
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
    }
}
