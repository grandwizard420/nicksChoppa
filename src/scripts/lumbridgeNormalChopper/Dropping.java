package scripts.lumbridgeNormalChopper;

import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;
import scripts.NicksAPI.Node;

public class Dropping extends Node {

    @Override
    public void execute() {
        System.out.println("Drop");
        if(Interfaces.get(595, 37) != null)
            Interfaces.get(595, 37).click("Close");
        String[] dontdrop = {"Bronze axe"};
        Inventory.dropAllExcept(dontdrop);
    }

    @Override
    public boolean validate() {
        if(Inventory.isFull()){
            return true;
        }
        else{
            return false;
        }
    }
}
