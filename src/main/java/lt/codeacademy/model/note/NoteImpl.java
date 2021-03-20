package lt.codeacademy.model.note;

import lt.codeacademy.model.note.Note;

/*
* Represents a single note
* */
public abstract class NoteImpl implements Note {
    private static int idCounter = 0;
    private int id;
    private String text;
    private boolean completed = false;

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
