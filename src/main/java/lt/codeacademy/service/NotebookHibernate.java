package lt.codeacademy.service;

import lt.codeacademy.exception.NoSuchCategoryExcepiton;
import lt.codeacademy.exception.NoSuchIDException;
import lt.codeacademy.model.Note;
import lt.codeacademy.util.CategoryFactory;

import java.util.ArrayList;
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

    public void saveNote(Note note) {
        noteService.save(note);
    }

    public Note getNote(int id) {
        try {
            return noteService.getById(id);
        } catch (NoSuchIDException e) {
            System.out.println("no notes with such id");
            return null;
        }
    }

    public void deleteNote(int id) {
        try {
            Note note = noteService.getById(id);
            note.setDeleted(true);
            noteService.save(note);
        } catch (NoSuchIDException e) {
            System.out.println("no notes with such id");
        }
    }

    public void setNoteCompleted(int id, boolean bool) {
        try {
            Note note = noteService.getById(id);
            note.setCompleted(bool);
            noteService.save(note);
        } catch (NoSuchIDException e) {
            System.out.println("no notes with such id");
        }
    }

    public void updateNoteText(int id, String text) {
        try {
            Note note = noteService.getById(id);
            note.setText(text);
            noteService.save(note);
        } catch (NoSuchIDException e) {
            System.out.println("no notes with such id");
        }
    }

    public List<Note> getUncompletedNotes() {
        return getNotes("completed", false);
    }

    public List<Note> getPersonalNotes() {
        try {
            return getNotes("category_id", CategoryFactory.getCategory("personal").getId());
        } catch (NoSuchCategoryExcepiton e) {
            return new ArrayList<>();
        }
    }

    public List<Note> getStudiesNotes() {
        try {
            return getNotes("category_id", CategoryFactory.getCategory("study").getId());
        } catch (NoSuchCategoryExcepiton e) {
            return new ArrayList<>();
        }
    }

    public List<Note> getWorkNotes() {
        try {
            return getNotes("category_id", CategoryFactory.getCategory("work").getId());
        } catch (NoSuchCategoryExcepiton e) {
            return new ArrayList<>();
        }
    }

    public List<Note> getCompletedNotes() {
        return getNotes("completed", true);
    }

    private List<Note> getNotes(String col, Object val) {
        return noteService.getAll(col, val, false);
    }
}
