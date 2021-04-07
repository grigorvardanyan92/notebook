package lt.codeacademy.service;

import lt.codeacademy.model.notebook.Notebook;

public interface FileService {
    void writeNotebook(Notebook notebook);
    Notebook readNotebook();
}
