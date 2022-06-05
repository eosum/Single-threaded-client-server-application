package util;
import data.HumanBeing;

import java.io.Serializable;

public class Request implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String command = null;
    private String arg;
    private HumanBeing object;

    public String getCommand() {
        return command;
    }
    public String getArg() {
        return arg;
    }

    public HumanBeing getObject() {
        return object;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
