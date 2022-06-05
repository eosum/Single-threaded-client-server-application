package commands;

import app.*;
import data.HumanBeing;

/**
 * Clear class
 */
public class Clear implements Command {

    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Clear existing collection
     *
     * @param args   arguments for command
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.clear();
    }

    @Override
    public String toString() {
        return "clear - отчистить коллекцию";
    }
}
