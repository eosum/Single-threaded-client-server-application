package commands;

import app.*;
import data.HumanBeing;

/**
 * PrintAscending class
 */
public class PrintAscending implements Command {
    private final CollectionManager collectionManager;

    public PrintAscending(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args   arguments
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.printAscending();
    }

    @Override
    public String toString() {
        return "print_ascending - выводит элементы в порядке возрастания";
    }

}
