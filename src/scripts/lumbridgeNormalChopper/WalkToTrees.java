package scripts.lumbridgeNormalChopper;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.WebWalking;
import org.tribot.api2007.types.RSTile;
import scripts.NicksAPI.Node;
import scripts.NicksAPI.Woodcutting;

import java.util.function.BooleanSupplier;

public class WalkToTrees extends Node {

    @Override
    public void execute() {
        System.out.println("Walk to trees");
        WebWalking.walkTo(new RSTile(3197, 3245), new BooleanSupplier() {
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
        return !Woodcutting.isAtTrees();
    }
}
