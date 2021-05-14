package lt.codeacademy.service;

import lt.codeacademy.factory.NoteFactory;
import lt.codeacademy.model.Note;
import lt.codeacademy.util.HibernateConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookHibernateTest {

    NotebookHibernate notebookHibernate = new NotebookHibernate();
    NoteService noteService = new NoteService();

    @BeforeAll
    static void launchConnection() {
        HibernateConfig.buildSessionFactory();
    }

    @AfterAll
    static void closeConnection() {
        HibernateConfig.closeSessionFactory();
    }

    @Test
    void saveNote() {
        int sizeBefore = noteService.getAll().size();
        Note note = notebookHibernate.saveNote(NoteFactory.getNote("test", "work"));
        int sizeAfter = noteService.getAll().size();
        Assertions.assertEquals(1, sizeAfter - sizeBefore);
        noteService.delete(note);
    }

    @Test
    void getNote() {
        Note note = notebookHibernate.saveNote(NoteFactory.getNote("test", "work"));
        Note gottenNote = notebookHibernate.getNote(note.getId());
        Assertions.assertEquals(note.getText(), gottenNote.getText());
        Assertions.assertEquals(note.getId(), gottenNote.getId());
        noteService.delete(note);
    }

    @Test
    void setNoteCompleted() {
        Note note = notebookHibernate.saveNote(NoteFactory.getNote("test", "work"));
        notebookHibernate.setNoteCompleted(note.getId(), true);
        Note completed = notebookHibernate.getNote(note.getId());
        Assertions.assertTrue(completed.isCompleted());
        noteService.delete(note);
    }
}