package lt.codeacademy;

import lt.codeacademy.factory.NoteFactory;
import lt.codeacademy.model.Note;
import lt.codeacademy.service.NotebookHibernate;
import lt.codeacademy.util.HibernateConfig;

public class App
{
    public static void main( String[] args ) {

//        HibernateConfig.buildSessionFactory();
//
//        NotebookHibernate notebook = new NotebookHibernate();
//        NotebookInterface notebookInterface = new NotebookInterface(notebook);
//
//        // adding notes
//        notebook.saveNote(NoteFactory.getNote("for setting completed", "work"));
//        notebook.saveNote(NoteFactory.getNote("for changing text", "home"));
//        notebook.saveNote(NoteFactory.getNote("for deleting", "personal"));
//        notebook.saveNote(NoteFactory.getNote("just example", "personal"));
//
//        // mark note as completed
//        notebook.setNoteCompleted(1, true);
//
//        // change note text
//        notebook.updateNoteText(2, "changed text");
//
//        // delete note
//        notebook.deleteNote(3);
//
//        // print list
//        System.out.println(notebookInterface.uncompletedNotes());
//        System.out.println(notebookInterface.personalNotes());
//
//        HibernateConfig.closeSessionFactory();
    }
}
