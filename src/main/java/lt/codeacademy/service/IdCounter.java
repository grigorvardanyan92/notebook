package lt.codeacademy.service;

public class IdCounter {
    private int counter = 0;

    public int getCounter() {
        return counter++;
    }
}
