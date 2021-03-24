package lt.codeacademy.model.note;

import java.time.LocalDate;

/*
* Represents a single note
* */
public abstract class NoteImpl implements Note {

    private static int idCounter = 0;
    private final int id;
    private String text;
    private boolean completed = false;
    private final LocalDate date = LocalDate.now();

    public NoteImpl(String text) {
        this.text = text;
        id = idCounter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }
}
