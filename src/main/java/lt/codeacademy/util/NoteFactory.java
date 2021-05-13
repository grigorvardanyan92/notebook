package lt.codeacademy.util;

import lt.codeacademy.exception.NoSuchCategoryExcepiton;
import lt.codeacademy.model.Category;
import lt.codeacademy.model.Note;
import lt.codeacademy.service.CategoryService;

public class NoteFactory {

    public static Note getNote(String text, String categoryName) throws NoSuchCategoryExcepiton {
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.getByName(categoryName);

        if (category == null) {
            throw new NoSuchCategoryExcepiton();
        }

        return new Note(text, category);
    }
}
