package lt.codeacademy.model.notebook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotebookImplTest {
    @Test
    void GiveId_FromZeroAndUp() {
        Notebook notebook = new NotebookImpl();
        int first = notebook.giveId();
        int second = notebook.giveId();
        assertEquals(0, first);
        assertEquals(1, second);
    }
}