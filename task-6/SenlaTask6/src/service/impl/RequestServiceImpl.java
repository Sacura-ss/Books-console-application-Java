package service.impl;

import dao.BookDao;
import dao.RequestDao;
import dao.entity.Book;
import dao.entity.Request;
import service.RequestService;

import java.util.List;
import java.util.Scanner;

public class RequestServiceImpl extends AbstractServiceImpl<Request, RequestDao>
        implements RequestService {
    private final RequestDao requestDao;
    private final BookDao bookDao;

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
        bookDao.changeAmountRequestById(bookId, book.getAmountRequest() + 1);
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

    @Override
    public void importFromLine(String line) {
        Request request = new Request();
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        int index = 0;
        while (scanner.hasNext()) {
            String data = scanner.next();
            if (index == 0)
                request.setId(Long.parseLong(data));
            else if (index == 1)
                request.setBook(bookDao.getById(Long.parseLong(data)));
            index++;
        }
        index = 0;
        createOrUpdate(request);
    }
}
