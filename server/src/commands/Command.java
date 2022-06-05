package commands;

import data.HumanBeing;

public interface Command {
    void execute(String args, HumanBeing object);
}
