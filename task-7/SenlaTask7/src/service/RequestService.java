package service;

import dao.entity.Request;

import java.util.List;

public interface RequestService extends AbstractService<Request> {
    void leaveRequest(Long requestId, Long bookId);

    List<Request> sortRequestByAmount();

    List<Request> sortRequestByTitle();

    List<Request> sortRequestByAuthor();

    void addBookToRequest(Long requestId, Long bookId);

    void updateLinksForBooks();

}
