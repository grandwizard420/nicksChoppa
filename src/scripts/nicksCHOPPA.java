package scripts;

import org.tribot.api.General;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Objects;
import org.tribot.api2007.types.RSObject;
import org.tribot.script.Script;
import scripts.NicksAPI.Node;
import scripts.lumbridgeNormalChopper.Chopping;
import scripts.lumbridgeNormalChopper.Dropping;
import scripts.lumbridgeNormalChopper.WalkToTrees;

public class nicksCHOPPA extends Script {
    @Override
    public void run() {
        Chopping Chop = new Chopping();
        Dropping Drop = new Dropping();
        WalkToTrees Walk = new WalkToTrees();
        while (true){
            if(Chop.validate())
                Chop.execute();
            if(Drop.validate())
                Drop.execute();
            if(Walk.validate())
                Walk.execute();
            if(Interfaces.get(595, 37) != null)
                Interfaces.get(595, 37).click("Close");
            General.sleep(1000);
        }
    }
}
