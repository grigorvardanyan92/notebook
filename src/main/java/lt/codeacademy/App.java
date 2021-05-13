package lt.codeacademy;

import lt.codeacademy.model.Note;
import lt.codeacademy.service.NotebookHibernate;
import lt.codeacademy.util.HibernateConfig;
import lt.codeacademy.util.NoteFactory;

public class App
{
    public static void main( String[] args ) {

        HibernateConfig.buildSessionFactory();

        NotebookHibernate notebook = new NotebookHibernate();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        // adding notes
        Note note1 = NoteFactory.getNote("for setting completed", "work");
        Note note2 = NoteFactory.getNote("for changing text", "home");
        Note note3 = NoteFactory.getNote("for deleting", "personal");
        Note note4 = NoteFactory.getNote("just example", "personal");
        notebook.saveNote(note1);
        notebook.saveNote(note2);
        notebook.saveNote(note3);
        notebook.saveNote(note4);

        // mark note as completed
        notebook.setNoteCompleted(1, true);

        // change note text
        notebook.updateNoteText(2, "changed text");

        // delete note
        notebook.deleteNote(3);

        // print list
        System.out.println(notebookInterface.uncompletedNotes());
        System.out.println(notebookInterface.personalNotes());

        HibernateConfig.closeSessionFactory();


    }
}
