package controller;

import controller.action.book.AddToWarehouseAction;
import controller.action.book.CreateBookAction;
import controller.action.book.DeleteBookAction;
import controller.action.book.GetIrrelevantBooksAction;
import controller.action.book.RemoveFromWarehouseAction;
import controller.action.book.SortBooksByAuthorAction;
import controller.action.book.SortBooksByPriceAction;
import controller.action.book.SortBooksByStatusAction;
import controller.action.book.SortBooksByTitleAction;
import controller.action.book.SortBooksByYearOfPublishingAction;
import controller.action.book.UpdateBookAction;
import controller.action.client.CreateClientAction;
import controller.action.client.DeleteClientAction;
import controller.action.client.GetAllClientAction;
import controller.action.client.UpdateClientAction;
import controller.action.order.*;
import controller.action.request.CreateRequestAction;
import controller.action.request.DeleteRequestAction;
import controller.action.request.LeaveRequestAction;
import controller.action.request.SortRequestByAmountAction;
import controller.action.request.SortRequestByAuthorAction;
import controller.action.request.SortRequestByTitleAction;
import controller.action.request.UpdateRequestAction;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    private Menu rootMenu;

    public void buildMenu() {
        List<MenuItem> rootList = new ArrayList<>();
        rootList.add(new MenuItem("-1 - exit"));
        rootList.add(new MenuItem("1 - interaction with client"));
        rootList.add(new MenuItem("2 - interaction with book"));
        rootList.add(new MenuItem("3 - interaction with order"));
        rootList.add(new MenuItem("4 - interaction with request"));
        rootMenu = new Menu("Main", rootList);

        List<MenuItem> clientList = new ArrayList<>();
        clientList.add(new MenuItem("-2 - back"));
        clientList.add(new MenuItem("1 - create client", new CreateClientAction()));
        clientList.add(new MenuItem("2 - delete client", new DeleteClientAction()));
        clientList.add(new MenuItem("3 - change client", new UpdateClientAction()));
        clientList.add(new MenuItem("4 - get all", new GetAllClientAction()));
        Menu clientMenu = new Menu("Client", clientList);

        List<MenuItem> bookList = new ArrayList<>();
        bookList.add(new MenuItem("-2 - back"));
        bookList.add(new MenuItem("1 - create book", new CreateBookAction()));
        bookList.add(new MenuItem("2 - delete book", new DeleteBookAction()));
        bookList.add(new MenuItem("3 - change book", new UpdateBookAction()));
        bookList.add(new MenuItem("4 - get irrelevant books", new GetIrrelevantBooksAction()));
        bookList.add(new MenuItem("5 - add book to warehouse", new AddToWarehouseAction()));
        bookList.add(new MenuItem("6 - remove book from warehouse", new RemoveFromWarehouseAction()));
        bookList.add(new MenuItem("7 - sort book by author", new SortBooksByAuthorAction()));
        bookList.add(new MenuItem("8 - sort book by price", new SortBooksByPriceAction()));
        bookList.add(new MenuItem("9 - sort book by status", new SortBooksByStatusAction()));
        bookList.add(new MenuItem("10 - sort book by title", new SortBooksByTitleAction()));
        bookList.add(new MenuItem("11 - sort book by year of publishing", new SortBooksByYearOfPublishingAction()));
        Menu bookMenu = new Menu("Book", bookList);

        List<MenuItem> orderList = new ArrayList<>();
        orderList.add(new MenuItem("-2 - back"));
        orderList.add(new MenuItem("1 - create order", new CreateOrderAction()));
        orderList.add(new MenuItem("2 - delete order", new DeleteOrderAction()));
        orderList.add(new MenuItem("3 - change order", new UpdateOrderAction()));
        orderList.add(new MenuItem("4 - add book to order", new AddBookToOrderAction()));
        orderList.add(new MenuItem("5 - add client to order", new AddClientToOrderAction()));
        orderList.add(new MenuItem("6 - check order for leave request", new CheckOrderForLeaveRequestAction()));
        orderList.add(new MenuItem("7 - open order", new OpenOrderAction()));
        orderList.add(new MenuItem("8 - cancel order", new CancelOrderAction()));
        orderList.add(new MenuItem("9 - complete order", new CompleteOrderAction()));
        orderList.add(new MenuItem("10 - get amount completed order", new GetAmountCompletedOrderAction()));
        orderList.add(new MenuItem("11 - get completed order", new GetCompletedOrderAction()));
        orderList.add(new MenuItem("12 - get profit", new GetProfitAction()));
        orderList.add(new MenuItem("13 - get total price", new GetTotalPriceAction()));
        orderList.add(new MenuItem("14 - sort order by execution data", new SortOrderByExecutionDataAction()));
        orderList.add(new MenuItem("15 - sort order by price", new SortOrderByPriceAction()));
        orderList.add(new MenuItem("16 - sort order by status", new SortOrderByStatusAction()));
        Menu orderMenu = new Menu("Order", orderList);

        List<MenuItem> requestList = new ArrayList<>();
        requestList.add(new MenuItem("-2 - back"));
        requestList.add(new MenuItem("1 - create request", new CreateRequestAction()));
        requestList.add(new MenuItem("2 - delete request", new DeleteRequestAction()));
        requestList.add(new MenuItem("3 - change request", new UpdateRequestAction()));
        requestList.add(new MenuItem("4 - leave request", new LeaveRequestAction()));
        requestList.add(new MenuItem("5 - sort request by amount", new SortRequestByAmountAction()));
        requestList.add(new MenuItem("6 - sort request by author", new SortRequestByAuthorAction()));
        requestList.add(new MenuItem("7 - sort request by title", new SortRequestByTitleAction()));
        Menu requestMenu = new Menu("Request", requestList);

        rootMenu.getMenuItems().get(1).setNextMenu(clientMenu);
        rootMenu.getMenuItems().get(2).setNextMenu(bookMenu);
        rootMenu.getMenuItems().get(3).setNextMenu(orderMenu);
        rootMenu.getMenuItems().get(4).setNextMenu(requestMenu);

    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
