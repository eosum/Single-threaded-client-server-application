package commands;

import app.*;
import data.HumanBeing;

/**
 * RemoveFirst class
 */
public class RemoveFirst implements Command {
    private final CollectionManager collectionManager;

    public RemoveFirst(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.removeFirst();
    }

    @Override
    public String toString() {
        return "remove_first - удаляет первый элемент в коллекции";
    }
}
