package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;
import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;

public class App
{
    public static void main( String[] args )
    {
        Note note = new PersonalNote("tekstukas testkfa fa d adfadfasdfadf adfasdfaf");
        Note note2 = new StudiesNote("kitas");
        Notebook notebook = new NotebookImpl();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        notebook.addNote(note);
        notebook.addNote(note2);

        System.out.println(notebookInterface.uncompletedNotes());
        System.out.println(notebook.getCompletedNotes());

    }
}
