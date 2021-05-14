package lt.codeacademy.factory;

import lt.codeacademy.exception.NoSuchCategoryExcepiton;
import lt.codeacademy.model.Category;
import lt.codeacademy.model.Note;

public class NoteFactory {

    public static Note getNote(String name, String categoryName) {
        try {
            Category category = CategoryFactory.getCategory(categoryName);
            return new Note(name, category);

        } catch (NoSuchCategoryExcepiton e) {
            System.out.println("no such category");
            return null;
        }
    }
}
