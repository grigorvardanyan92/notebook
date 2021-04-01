package lt.codeacademy.service;

import lt.codeacademy.model.notebook.Notebook;

import java.io.File;

public interface FileService {
    void writeNotebook(Notebook notebook);
    Notebook readNotebook();
}
