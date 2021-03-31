package lt.codeacademy.model.note;

import lt.codeacademy.model.note.Note;

import java.io.Serializable;
import java.time.LocalDate;

/*
* Represents a single note
* */
public abstract class NoteImpl implements Note, Serializable {
    private final int id;
    private String text;
    private boolean completed = false;
    private final LocalDate date = LocalDate.now();

    // constructor
    public NoteImpl(String text, int id) {
        this.text = text;
        this.id = id;
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

    /*
    * Creates text in format "id   part of text...    date"
    * */
    @Override
    public String toString() {
        String beginningOfText = text;
        if (beginningOfText.length() > 37) {
            beginningOfText = beginningOfText.substring(0, 37) + "...";
        }
        return String.format("%4d   %-40s   %s", id, beginningOfText, date);
    }
}
