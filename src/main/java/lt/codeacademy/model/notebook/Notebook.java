package lt.codeacademy.model.notebook;

import lt.codeacademy.exception.NoSuchIDException;
import lt.codeacademy.model.note.Note;

import java.util.List;

public interface Notebook {

    void addNote(Note note);
    Note getNote(int id);
    void deleteNote(int id) throws NoSuchIDException;
    List<Note> getUncompletedNotes();
    List<Note> getPersonalNotes();
    List<Note> getStudiesNotes();
    List<Note> getWorkNotes();
    List<Note> getCompletedNotes();
    int giveId();
}
