package lt.codeacademy.service;

import java.io.Serializable;

public class IdCounter implements Serializable {
    private int counter = 0;

    public int getCounter() {
        return counter++;
    }
}
