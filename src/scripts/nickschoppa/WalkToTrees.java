package scripts.nickschoppa;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Player;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSTile;
import scripts.NicksAPI.Node;
import scripts.NicksAPI.Woodcutting;

import java.util.function.BooleanSupplier;

public class WalkToTrees extends Node {

    private RSTile location;

    public WalkToTrees(Woodcutting.Locations loc){
        if(loc == Woodcutting.Locations.LUM_OAK){
            location = new RSTile(3190, 3250);
        }
        else if(loc == Woodcutting.Locations.LUM_NORMAL){
            location = new RSTile(3197, 3245);
        }
        else if(loc == Woodcutting.Locations.LUM_WILLOW){
            location = new RSTile(3162,3269);

        }
    }

    @Override
    public void execute() {
        System.out.println("Walk to trees");
        WebWalking.walkTo(location, new BooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                if(Interfaces.get(595, 37) != null)
                    return true;
                else
                    return false;
            }
        }, 500);
        if(Interfaces.get(595, 37) != null)
            Interfaces.get(595, 37).click("Close");
    }

    @Override
    public boolean validate() {
        if(Player.getPosition().distanceTo(location) > 15)
            return true;
        else
            return false;
    }
}
