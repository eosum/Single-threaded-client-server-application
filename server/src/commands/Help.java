package commands;

import app.CollectionManager;
import data.HumanBeing;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Help class
 */
public class Help implements Command {
    private final HashMap<String, Command> commands;
    private CollectionManager collectionManager;


    public Help(HashMap<String, Command> commands, CollectionManager collectionManager) {
        this.commands = commands;
        this.collectionManager = collectionManager;
    }

    /**
     * Prints references for commands
     *
     * @param args   arguments
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        LinkedList<String> descriptionCommands = new LinkedList<>();
        for (Command description: commands.values()) {
            descriptionCommands.add(description.toString());
        }
        collectionManager.help(descriptionCommands);
    }

    @Override
    public String toString() {
        return "help - выводит справку по доступным командам";
    }
}
