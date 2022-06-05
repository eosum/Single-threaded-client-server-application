package commands;

import app.CollectionManager;
import data.HumanBeing;

/**
 * Command Add class
 */
public class Add implements Command {
    private final CollectionManager collectionManager;

    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Add an element to collection
     *
     * @param args   arguments for command
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.add(object);
    }

    @Override
    public String toString() {
        return "add - добавляет новый элемент в коллекцию";
    }
}
