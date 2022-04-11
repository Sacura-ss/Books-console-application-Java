package service.impl;

import dao.BookDao;
import dao.RequestDao;
import dao.entity.Book;
import dao.entity.Request;
import service.RequestService;

import java.util.List;

public class RequestServiceImpl extends AbstractServiceImpl<Request, RequestDao> implements RequestService {
    private RequestDao requestDao;
    private BookDao bookDao;

    public RequestServiceImpl(RequestDao requestDao, BookDao bookDao) {
        super(requestDao);
        this.requestDao = requestDao;
        this.bookDao = bookDao;
    }

    @Override
    public void leaveRequest(Long requestId, Long bookId) {
        Request request = requestDao.getById(requestId);
        Book book = bookDao.getById(bookId);
        request.setBook(book);
        bookDao.changeAmountRequestById(bookId,book.getAmountRequest() + 1);
    }

    @Override
    public List<Request> sortRequestByAmount() {
        return requestDao.sortRequestByAmount();
    }

    @Override
    public List<Request> sortRequestByTitle() {
        return requestDao.sortRequestByTitle();
    }

    @Override
    public List<Request> sortRequestByAuthor() {
        return requestDao.sortRequestByAuthor();
    }
}
