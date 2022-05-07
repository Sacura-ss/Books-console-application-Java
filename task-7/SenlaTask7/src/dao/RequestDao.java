package dao;

import dao.entity.Book;
import dao.entity.Request;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public interface RequestDao extends AbstractDao<Request> {
    List<Request> sortRequestByAmount();

    List<Request> sortRequestByTitle();

    List<Request> sortRequestByAuthor();
}
