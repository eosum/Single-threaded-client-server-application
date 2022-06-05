package app;

import exceptions.*;
import parser.ParserFromXml;
import util.Request;
import util.Response;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.util.*;

/**
 * Main class
 */
public class Main {
    private final static String SAVE_COLLECTION = "save";
    /**
     * Program entry point
     *
     * @param args the input arguments
     */
    public static void main(String args[]) throws IOException {

        CollectionManager collectionManager = new CollectionManager();
        try {
            ParserFromXml parserFromXml = new ParserFromXml();
            parserFromXml.parser(args);
            collectionManager.mergeCollections(parserFromXml.getCollection(), parserFromXml.getLastIdFromFile());
        }
        catch (ProcessingFileException | PermissionFileException e) {
            System.out.println("Сервер не смог запуститься. Проверьте корректность парсера.");
            return;
        }
        CommandsList commandsList = new CommandsList(collectionManager);
        Server server = new Server();

        System.out.println("Сервер запущен");

        while(true) {

            if (System.in.available() > 0) {
                String requestFromConsole;
                try {
                    requestFromConsole = (new Scanner(System.in)).nextLine();
                }
                catch (NullPointerException e) {
                    return;
                }

                if (requestFromConsole.equals(SAVE_COLLECTION)) {
                    Request request = new Request();
                    request.setCommand(requestFromConsole);
                    commandsList.execute(request);
                    System.out.println("Все прошло успешно");
                } else {
                    System.out.println("Вы ввели что - то странное. Коллекция не сохранена");
                }

            }

            server.getSelector().select(3000);
            Set<SelectionKey> keys = server.getSelector().selectedKeys();
            Iterator iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = (SelectionKey) iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    server.register();
                    System.out.println(key);
                }
                else if (key.isReadable()) {
                    Request request = server.readRequest(key);
                    if (request != null) {
                        commandsList.execute(request);
                        Response response = collectionManager.getResponse();
                        collectionManager.clearResponse();
                        response.setCommand(request.getCommand());
                        server.sendResponse(response, key);
                    }
                }
            }
        }
    }
}
