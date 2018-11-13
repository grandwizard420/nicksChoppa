package scripts.lumbridgeNormalChopper;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.*;
import org.tribot.api2007.types.RSObject;
import scripts.NicksAPI.Node;
import scripts.NicksAPI.Woodcutting;

import java.util.function.BooleanSupplier;

public class Chopping extends Node {

    @Override
    public void execute() {
        System.out.println("Chop");
        if(Interfaces.get(595, 37) != null)
            Interfaces.get(595, 37).click("Close");
        RSObject[] trees = Objects.findNearest(10,"Tree");
        if(trees.length < 1)
            return;
        for(RSObject tree : trees){
            if(tree != null)
                if(!tree.click("Chop down")) {
                    Camera.setCameraAngle(90);
                    Camera.turnToTile(tree);
                    tree.click("Chop down");
                }
                else{
                    Timing.waitCondition(new BooleanSupplier() {
                        @Override
                        public boolean getAsBoolean() {
                            return Player.getAnimation() == 879;
                        }
                    }, General.random(4000, 6000));

                    Timing.waitCondition(new BooleanSupplier() {
                        @Override
                        public boolean getAsBoolean() {
                            return Player.getAnimation() == -1;
                        }
                    }, General.random(20000, 25000));
                    return;
                }
        }
    }

    @Override
    public boolean validate() {
        if(Equipment.isEquipped("Bronze axe") && !Inventory.isFull() && Woodcutting.isAtTrees()){
            return true;
        }
        else{
            return false;
        }
    }
}
