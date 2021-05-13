package lt.codeacademy;

import lt.codeacademy.exception.NoSuchIDException;
import lt.codeacademy.model.Note;
import lt.codeacademy.service.CategoryService;
import lt.codeacademy.service.NoteService;

import java.util.List;

/**
 * Represents a notebook, saving to
 * and loading from a DB.
 */
public class NotebookHibernate {

    private CategoryService categoryService;
    private NoteService noteService;

    public NotebookHibernate() {
        categoryService = new CategoryService();
        noteService = new NoteService();
    }

    public void addNote(Note note) {

    }

    public Note getNote(int id) {
        return null;
    }

    public void deleteNote(int id) throws NoSuchIDException {

    }

    public List<Note> getUncompletedNotes() {
        return null;
    }

    public List<Note> getPersonalNotes() {
        return null;
    }

    public List<Note> getStudiesNotes() {
        return null;
    }

    public List<Note> getWorkNotes() {
        return null;
    }

    public List<Note> getCompletedNotes() {
        return null;
    }
}
