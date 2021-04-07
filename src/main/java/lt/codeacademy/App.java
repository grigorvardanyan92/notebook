package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;
import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.service.FileService;
import lt.codeacademy.service.FileServiceImpl;

import java.io.File;

public class App
{
    public static void main( String[] args )
    {
        File file = new File("notebook.bin");
        FileService fileService = new FileServiceImpl(file);

        Notebook notebook = fileService.readNotebook();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        Note note1 = new StudiesNote("Study Java", notebook.giveId());
        Note note2 = new PersonalNote("Buy flowers", notebook.giveId());
        notebook.addNote(note1);
        notebook.addNote(note2);

        System.out.println(notebookInterface.personalNotes());
        System.out.println(notebookInterface.studiesNotes());

        notebook.deleteNote(1);

//        System.out.println(notebookInterface);
        fileService.writeNotebook(notebook);
    }
}
