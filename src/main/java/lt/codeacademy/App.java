package lt.codeacademy;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args ) throws JsonProcessingException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        // work with file
//        File file = new File("notebook.bin");
//        FileService fileService = new FileServiceImpl(file);

        // notebook class
//        Notebook notebook = new NotebookImpl();
//        Notebook notebook = fileService.readNotebook();
//        NotebookInterface notebookInterface = new NotebookInterface(notebook);

        // add notes
//        Note note1 = new StudiesNote("Study Java", notebook.giveId());
//        Note note2 = new PersonalNote("Buy flowers", notebook.giveId());
//        notebook.addNote(note1);
//        notebook.addNote(note2);

        // delete note
//        notebookInterface.deleteNote(0);

        // print list
//        System.out.println(notebookInterface.uncompletedNotes());
//        System.out.println(notebookInterface.personalNotes());
//        System.out.println(notebookInterface.studiesNotes());

        // save to file
//        fileService.writeNotebook(notebook);
    }
}
