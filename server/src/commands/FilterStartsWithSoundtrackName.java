package commands;

import app.*;
import data.HumanBeing;

/**
 * FilterStartsWithSoundtrackName class
 */
public class FilterStartsWithSoundtrackName implements Command {
    private final CollectionManager collectionManager;

    public FilterStartsWithSoundtrackName(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * @param args   contains the substring to find
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        String SubString = String.join(" ", args);
        collectionManager.filterStartsWithSoundtrackName(SubString);
    }

    @Override
    public String toString() {
        return "filter_starts_with_soundtrack_name - выводит элементы, имя песни которых начинается с заданной подстроки";
    }

}
