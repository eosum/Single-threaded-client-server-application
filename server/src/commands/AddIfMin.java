package commands;

import app.CollectionManager;
import data.HumanBeing;

/**
 * AddIfMin class
 */
public class AddIfMin implements Command{
    private final CollectionManager collectionManager;

    public AddIfMin(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Add an element if it is smaller than the smallest existing one
     *
     * @param args   arguments for command
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.addIfMin(object);
    }

    @Override
    public String toString() {
        return "add_if_min - добавляет элемент, если он меньше чем наименьший элемент коллекции";
    }

}
