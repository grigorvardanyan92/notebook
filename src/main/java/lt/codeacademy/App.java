package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.PersonalNote;
import lt.codeacademy.model.note.StudiesNote;

public class App
{
    public static void main( String[] args )
    {
        Note note = new PersonalNote("tekstukas");
        Note note2 = new StudiesNote("kitas");
        System.out.println(note.getId());
        System.out.println(note2.getId());
    }
}
