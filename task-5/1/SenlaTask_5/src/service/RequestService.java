package service;

import dao.entity.Request;

import java.util.List;

public interface RequestService extends AbstractService<Request>{
    void leaveRequest(Long requestId, Long bookId);
    public List<Request> sortRequestByAmount();

    public List<Request> sortRequestByTitle();

    public List<Request> sortRequestByAuthor();
}
