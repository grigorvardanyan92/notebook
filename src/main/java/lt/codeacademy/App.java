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
        File file = new File("notebook.bin");
        FileService fileService = new FileServiceImpl();
        Notebook notebook = new NotebookImpl();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        Note note = new StudiesNote("some text", notebook.giveId());


        notebook.addNote(note);

        fileService.writeNotebook(notebook, file);
        Notebook notebook1 = fileService.readNotebook(file);

        System.out.println(notebook1.getUncompletedNotes());
    }
}
