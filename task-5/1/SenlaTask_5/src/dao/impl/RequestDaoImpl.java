package dao.impl;

import dao.RequestDao;
import dao.entity.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl extends AbstractDaoImpl<Request>
        implements RequestDao {
    @Override
    protected void updateFields(Request oldEntity, Request newEntity) {
        oldEntity.setBook(newEntity.getBook());
    }

    @Override
    public List<Request> sortRequestByAmount() {
        List<Request> list = new ArrayList<>(getAll());
        list.sort((request1, request2) -> request1.getBook().getAmountRequest().compareTo(request2.getBook().getAmountRequest()));
        return list;
    }

    @Override
    public List<Request> sortRequestByTitle() {
        List<Request> list = new ArrayList<>(getAll());
        list.sort((request1, request2) -> request1.getBook().getTitle().compareTo(request2.getBook().getTitle()));
        return list;
    }

    @Override
    public List<Request> sortRequestByAuthor() {
        List<Request> list = new ArrayList<>(getAll());
        list.sort((request1, request2) -> request1.getBook().getAuthor().compareTo(request2.getBook().getAuthor()));
        return list;
    }
}
