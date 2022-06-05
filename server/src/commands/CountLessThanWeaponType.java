package commands;

import app.CollectionManager;
import data.HumanBeing;
import data.WeaponType;

/**
 * CountLessThanWeaponType class
 */
public class CountLessThanWeaponType implements Command {
    private final CollectionManager collectionManager;

    public CountLessThanWeaponType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Counts the number of element that has smaller weapon type
     *
     * @param args   arguments for command
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.countLessThanWeaponType(args);
    }

    @Override
    public String toString() {
        return "count_less_than_weapon_type - выводит кол - во элементов, weapon type которых меньше заданного";
    }

}
