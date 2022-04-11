package dao;

import dao.entity.Book;
import dao.entity.Request;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface RequestDao extends AbstractDao<Request> {
    public List<Request> sortRequestByAmount();

    public List<Request> sortRequestByTitle();

    public List<Request> sortRequestByAuthor();
}
