package scripts.NicksAPI;

import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSTile;

public class Woodcutting {

    public enum Locations{
        LUM_OAK,
        LUM_NORMAL,
        LUM_WILLOW;
    }

    public static boolean isAtTrees(){
        RSTile tree_loc = new RSTile(3197, 3245);
        if(Player.getPosition().distanceTo(tree_loc) < 15)
            return true;
        else
            return false;
    }
}
