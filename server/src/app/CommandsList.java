package app;

import commands.*;
import util.Request;

import java.util.HashMap;

/**
 * CommandsList class
 */
public class CommandsList {
    public final HashMap<String, Command> commands = new HashMap<>();

    /**
     * initializing the list of commands
     *
     * @param collectionManager the collection manager
     */
    public CommandsList(CollectionManager collectionManager) {
        commands.put("add", new Add(collectionManager));
        commands.put("info", new Info(collectionManager));
        commands.put("show", new Show(collectionManager));
        commands.put("update", new Update(collectionManager));
        commands.put("remove_by_id", new RemoveById(collectionManager));
        commands.put("clear", new Clear(collectionManager));
        commands.put("remove_first", new RemoveFirst(collectionManager));
        commands.put("print_ascending", new PrintAscending(collectionManager));
        commands.put("filter_starts_with_soundtrack_name", new FilterStartsWithSoundtrackName(collectionManager));
        commands.put("count_less_than_weapon_type", new CountLessThanWeaponType(collectionManager));
        commands.put("remove_greater", new RemoveGreater(collectionManager));
        commands.put("add_if_min", new AddIfMin(collectionManager));
        commands.put("save", new Save(collectionManager));
        commands.put("help", new Help(commands, collectionManager));
        commands.put("exit", new Exit());
    }

    public void execute(Request request) {
        commands.get(request.getCommand()).execute(request.getArg(), request.getObject());
    }

}
