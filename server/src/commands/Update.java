package commands;

import app.CollectionManager;
import data.HumanBeing;

/**
 * Update class
 */
public class Update implements Command {
    private final CollectionManager collectionManager;

    public Update(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execute(String args, HumanBeing object) {
        final Long id = Long.parseLong(args);
        collectionManager.updateById(id, object);
    }

    @Override
    public String toString() {
        return "update - обновить значение элемента коллекции, id которого совпадает с исходным";
    }
}
