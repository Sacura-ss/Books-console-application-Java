package dao.impl;

import dao.RequestDao;
import dao.entity.Request;

import java.util.List;

public class RequestDaoImpl extends AbstractDaoImpl<Request>
        implements RequestDao {
    @Override
    protected void updateFields(Request oldEntity, Request newEntity) {
        oldEntity.setBook(newEntity.getBook());
    }

    @Override
    public List<Request> sortRequestByAmount() {
        List<Request> list = getAll();
        list.sort((request1, request2) -> request1.getBook().getAmountRequest().compareTo(request2.getBook().getAmountRequest()));
        return list;
    }

    @Override
    public List<Request> sortRequestByTitle() {
        List<Request> list = getAll();
        list.sort((request1, request2) -> request1.getBook().getTitle().compareTo(request2.getBook().getTitle()));
        return list;
    }

    @Override
    public List<Request> sortRequestByAuthor() {
        List<Request> list = getAll();
        list.sort((request1, request2) -> request1.getBook().getAuthor().compareTo(request2.getBook().getAuthor()));
        return list;
    }


    @Override
    public String exportToLine(Long id) {
        Request request = getById(id);
        String line = "";
        StringBuilder builder = new StringBuilder();
        builder.append(request.getId());
        builder.append(',');
        builder.append(request.getBook().getId());
        builder.append('\n');
        line = builder.toString();
        return line;
    }
}
