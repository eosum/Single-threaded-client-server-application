package commands;

import app.CollectionManager;
import data.HumanBeing;

/**
 * Save class
 */
public class Save implements Command {

    private final CollectionManager collectionManager;

    public Save(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String args, HumanBeing object) {
        collectionManager.save();
    }

    @Override
    public String toString() {
        return "save - сохраняет коллекцию в файл";
    }
}
