package lt.codeacademy;

import lt.codeacademy.model.note.Note;
import lt.codeacademy.model.note.WorkNote;
import lt.codeacademy.model.notebook.Notebook;
import lt.codeacademy.model.notebook.NotebookImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookInterfaceTest {
    @Test
    void ReadNote_NewLineOnEvery50PlusSpace() {
        Notebook notebook = new NotebookImpl();
        NotebookInterface notebookInterface = new NotebookInterface(notebook);
        String text = "Some intentionally long text with a line break instead of the space that comes after " +
                "50th chararacter";
        Note note = new WorkNote(text, notebook.giveId());
        notebook.addNote(note);
        assertEquals("Some intentionally long text with a line break instead\nof the space that comes after " +
                "50th chararacter", notebookInterface.readNote(0));
    }
}