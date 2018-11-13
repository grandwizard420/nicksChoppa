package scripts.nickschoppa;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api2007.Camera;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Objects;
import org.tribot.api2007.Player;
import org.tribot.api2007.types.RSObject;
import org.tribot.api2007.types.RSTile;
import scripts.NicksAPI.Node;
import scripts.NicksAPI.Woodcutting;

import java.util.function.BooleanSupplier;

public class Chopping extends Node {

    private String treeType;
    private RSTile location;



    public Chopping(String tree, Woodcutting.Locations loc){
        this.treeType = tree;
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
        System.out.println("Chop");
        if(Interfaces.get(595, 37) != null)
            Interfaces.get(595, 37).click("Close");
        RSObject[] trees = Objects.findNearest(10,treeType);
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
        if(Player.getPosition().distanceTo(location) < 15)
            return true;
        else
            return false;
    }
}
