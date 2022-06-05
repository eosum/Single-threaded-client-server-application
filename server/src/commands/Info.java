package commands;

import app.*;
import data.HumanBeing;

/**
 * Info class
 */
public class Info implements Command {

    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Prints the collection info
     *
     * @param args   arguments
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.info();
    }

    @Override
    public String toString() {
        return "info - выводит информацию о коллекции (тип, дата инициализации и тд)";
    }
}
