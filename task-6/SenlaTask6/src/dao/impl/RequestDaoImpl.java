package dao.impl;

import dao.RequestDao;
import dao.entity.Request;

import java.util.List;
import java.util.stream.Collectors;

public class RequestDaoImpl extends AbstractDaoImpl<Request>
        implements RequestDao {
    @Override
    protected void updateFields(Request oldEntity, Request newEntity) {
        oldEntity.setBook(newEntity.getBook());
    }

    @Override
    public List<Request> sortRequestByAmount() {
        return getAll().stream()
                .sorted((request1, request2) -> request1.getBook().getAmountRequest().compareTo(request2.getBook().getAmountRequest()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Request> sortRequestByTitle() {
        return getAll().stream()
                .sorted((request1, request2) -> request1.getBook().getTitle().compareTo(request2.getBook().getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Request> sortRequestByAuthor() {
        return getAll().stream()
                .sorted((request1, request2) -> request1.getBook().getAuthor().compareTo(request2.getBook().getAuthor()))
                .collect(Collectors.toList());
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
