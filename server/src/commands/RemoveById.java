package commands;

import app.*;
import data.HumanBeing;

/**
 * RemoveById class
 */
public class RemoveById implements Command {

    private final CollectionManager collectionManager;

    public RemoveById(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.removeById(Long.parseLong(args));
    }

    @Override
    public String toString() {
        return "remove_by_id - удаляет элемент из коллекции по его id";
    }
}
