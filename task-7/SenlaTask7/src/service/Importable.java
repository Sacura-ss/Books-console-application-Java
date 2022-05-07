package service;

public interface Importable {
    void importById(Long id, String file);

    void importAll(String file);
}
