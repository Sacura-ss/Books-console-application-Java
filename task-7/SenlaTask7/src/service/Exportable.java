package service;

public interface Exportable {
    void exportById(Long id, String file);

    void exportAll(String file);
}
