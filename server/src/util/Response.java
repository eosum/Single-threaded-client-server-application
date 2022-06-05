package util;

import data.HumanBeing;
import sun.awt.image.ImageWatched;

import java.io.Serializable;
import java.util.LinkedList;

public class Response implements Serializable {
    private static final long serialVersionUID = 12345678910L;
    private String message = " - выполнение команды прошло успешно";
    private String command;
    private LinkedList<? extends Serializable> object;
    public void setMessage(String message) {
        this.message = message;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setObject(LinkedList<? extends Serializable> object) {
        this.object = object;
    }
}
