package lt.codeacademy.factory;

import lt.codeacademy.exception.NoSuchCategoryExcepiton;
import lt.codeacademy.model.Category;
import lt.codeacademy.service.CategoryService;

public class CategoryFactory {

    public static Category getCategory(String name) throws NoSuchCategoryExcepiton {
        CategoryService categoryService = new CategoryService();
        Category category = categoryService.getByName(name);

        if (category == null) {
            throw new NoSuchCategoryExcepiton();
        }

        return category;
    }
}
