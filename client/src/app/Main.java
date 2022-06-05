package app;

import java.util.Iterator;
import java.util.LinkedList;
import util.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String STOP_PROGRAM = "exit";

    public static void main(String[] args) {
        CommandList commandsList = new CommandList();
        Client client = new Client();
        client.setClient(client);
        client.connect();

        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.print("Введите команду: ");
                String command = input.nextLine();

                String arg = "";
                String[] commandCut = command.trim().split("\\s+");
                String commandName = commandCut[0];

                if (commandCut.length > 1) {
                    arg = commandCut[1];
                }

                if (commandName.equals(STOP_PROGRAM)) {
                    client.close();
                    return;
                }

                Request request = commandsList.requestFormation(commandName, arg, false);

                if (client.isConnected()) {
                    if (request == null) continue;

                    client.sendRequest(request);

                    Response response = client.getResponse();

                    if (response == null) continue;
                    System.out.println(response.getCommand() + " " + response.getMessage());
                    if (response.getObject() == null) continue;

                    LinkedList<?> object = response.getObject();
                    Iterator iterator = object.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                }
                else {
                    client.reconnect();
                }
            }
        }
        catch (NoSuchElementException e) {
            System.out.println("Завершение программы.");
        }
    }
}