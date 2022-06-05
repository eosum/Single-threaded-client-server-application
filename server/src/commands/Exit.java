package commands;

import data.HumanBeing;

/**
 * Exit class
 */
public class Exit implements Command {

    /**
     * Exit the program
     *
     * @param args   arguments
     * @param object
     */
    @Override
    public void execute(String args, HumanBeing object) {
        System.exit(0);
    }

    @Override
    public String toString() {
        return "exit - завершение программы";
    }
}
