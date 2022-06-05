package commands;

import app.CollectionManager;
import data.HumanBeing;

/**
 * RemoveGreater class
 */
public class RemoveGreater implements Command {
    private final CollectionManager collectionManager;

    public RemoveGreater(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.removeGreater(object);
    }

    @Override
    public String toString() {
        return "remove_greater - удаляет все элементы, превышающий заданный";
    }

}
