package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;
import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;
import lt.codeacademy.service.FileService;
import lt.codeacademy.service.FileServiceImpl;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {
        Note note = new PersonalNote("tekstukas testkfa fa d adfadfasdfadf adfasdfaf");
        Note note2 = new StudiesNote("kitas");

        Notebook notebook = new NotebookImpl();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        File file = new File("notebook.bin");
        FileService fileService = new FileServiceImpl();

        notebook.addNote(note);
        notebook.addNote(note2);

        fileService.writeNotebook(notebook, file);
        Notebook notebook1 = fileService.readNotebook(file);

        System.out.println(notebook1.getUncompletedNotes());
    }
}
