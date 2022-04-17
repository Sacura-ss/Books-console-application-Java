package service.impl;

import dao.AbstractDao;
import dao.entity.AbstractEntity;
import service.AbstractService;
import service.Exportable;
import service.Importable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AbstractServiceImpl<T extends AbstractEntity, D extends AbstractDao<T>>
        implements AbstractService<T> {

    private D defaultDao;

    public AbstractServiceImpl(D defaultDao) {
        this.defaultDao = defaultDao;
    }

    @Override
    public T getById(Long id) {
        return defaultDao.getById(id);
    }

    @Override
    public List<T> getAll() {
        return defaultDao.getAll();
    }

    @Override
    public void deleteById(Long id) {
        defaultDao.deleteById(id);
    }

    @Override
    public void update(Long id, T entity) {
        defaultDao.update(id, entity);
    }

    @Override
    public void create(T entity) {
        defaultDao.create(entity);
    }

    @Override
    public void exportById(Long id, String file) {
        String str = defaultDao.exportToLine(id);
        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(str);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void exportAll(String file) {
        for(T entity: getAll()) {
            Long id = entity.getId();
            exportById(id, file);
        }
    }

    @Override
    public void importById(Long id, String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            Scanner scanner = null;
            while ( line != null) {
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String idFromFile = scanner.next();
                    if(id.equals(Long.parseLong(idFromFile))) {
                        defaultDao.importFromLine(idFromFile + scanner.nextLine());
                        line = null;
                        break;
                    } else {
                        scanner.nextLine();
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
   public void importAll(String file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
               defaultDao.importFromLine(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
