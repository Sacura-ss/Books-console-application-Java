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
import controller.action.client.UpdateClientAction;
import controller.action.order.*;
import controller.action.request.CreateRequestAction;
import controller.action.request.DeleteRequestAction;
import controller.action.request.LeaveRequestAction;
import controller.action.request.SortRequestByAmountAction;
import controller.action.request.SortRequestByAuthorAction;
import controller.action.request.SortRequestByTitleAction;
import controller.action.request.UpdateRequestAction;
import controller.Builder;
import controller.action.client.CreateClientAction;
import controller.action.client.DeleteClientAction;
import controller.MenuController;
import controller.Navigator;

import java.util.Scanner;

/*public class Main {
    public static void main(String[] args) {

        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder,navigator);
        menuController.run();

        CreateClientAction createClientAction = new CreateClientAction(); //в build
        DeleteClientAction deleteClientAction = new DeleteClientAction();
        UpdateClientAction updateClientAction = new UpdateClientAction();

        CreateBookAction createBookAction = new CreateBookAction();
        DeleteBookAction deleteBookAction = new DeleteBookAction();
        UpdateBookAction updateBookAction = new UpdateBookAction();
        GetIrrelevantBooksAction getIrrelevantBooksAction = new GetIrrelevantBooksAction();
        AddToWarehouseAction addToWarehouseAction = new AddToWarehouseAction();
        RemoveFromWarehouseAction removeFromWarehouseAction = new RemoveFromWarehouseAction();
        SortBooksByAuthorAction sortBooksByAuthorAction = new SortBooksByAuthorAction();
        SortBooksByPriceAction sortBooksByPriceAction = new SortBooksByPriceAction();
        SortBooksByStatusAction sortBooksByStatusAction = new SortBooksByStatusAction();
        SortBooksByTitleAction sortBooksByTitleAction = new SortBooksByTitleAction();
        SortBooksByYearOfPublishingAction sortBooksByYearOfPublishingAction = new SortBooksByYearOfPublishingAction();

        AddBookToOrderAction addBookToOrderAction = new AddBookToOrderAction();
        AddClientToOrderAction addClientToOrderAction = new AddClientToOrderAction();
        CancelOrderAction cancelOrderAction = new CancelOrderAction();
        CheckOrderForLeaveRequestAction checkOrderForLeaveRequestAction = new CheckOrderForLeaveRequestAction();
        CompleteOrderAction completeOrderAction = new CompleteOrderAction();
        CreateOrderAction createOrderAction = new CreateOrderAction();
        DeleteOrderAction deleteOrderAction = new DeleteOrderAction();
        GetAmountCompletedOrderAction getAmountCompletedOrderAction = new GetAmountCompletedOrderAction();
        GetCompletedOrderAction getCompletedOrderAction = new GetCompletedOrderAction();
        GetProfitAction getProfitAction = new GetProfitAction();
        GetTotalPriceAction getTotalPriceAction = new GetTotalPriceAction();
        OpenOrderAction openOrderAction = new OpenOrderAction();
        SortOrderByExecutionDataAction sortOrderByExecutionDataAction = new SortOrderByExecutionDataAction();
        SortOrderByPriceAction sortOrderByPriceAction = new SortOrderByPriceAction();
        SortOrderByStatusAction sortOrderByStatusAction = new SortOrderByStatusAction();
        UpdateOrderAction updateOrderAction = new UpdateOrderAction();

        CreateRequestAction createRequestAction = new CreateRequestAction();
        DeleteRequestAction deleteRequestAction = new DeleteRequestAction();
        LeaveRequestAction leaveRequestAction = new LeaveRequestAction();
        SortRequestByAmountAction sortRequestByAmountAction = new SortRequestByAmountAction();
        SortRequestByAuthorAction sortRequestByAuthorAction = new SortRequestByAuthorAction();
        SortRequestByTitleAction sortRequestByTitleAction = new SortRequestByTitleAction();
        UpdateRequestAction updateRequestAction = new UpdateRequestAction();

        Scanner in = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            i = in.nextInt();
            menuController.getNavigator().navigate(i);
            /*switch (i) {*/
                /*case 1:
                    System.out.println("0 - exit\n" +
                            "1 - create client\n" +
                            "2 - delete client\n" +
                            "3 - change client\n");
                    i = in.nextInt();
                    switch(i) {
                        case 1:
                            createClientAction.execute();
                            break;
                        case 2:
                            deleteClientAction.execute();
                            break;
                        case 3:
                            updateClientAction.execute();
                            break;
                    }
                    break;
            case 2:
                    menuController.getNavigator().navigate(2);
                    i = in.nextInt();
                    menuController.getNavigator().navigate(i - 1);
                    switch(i) {
                        case 1:
                            createBookAction.execute();
                            break;
                        case 2:
                            deleteBookAction.execute();
                            break;
                        case 3:
                            updateBookAction.execute();
                            break;
                        case 4:
                            getIrrelevantBooksAction.execute();
                            break;
                        case 5:
                            addToWarehouseAction.execute();
                            break;
                        case 6:
                            removeFromWarehouseAction.execute();
                            break;
                        case 7:
                            sortBooksByAuthorAction.execute();
                            break;
                        case 8:
                            sortBooksByPriceAction.execute();
                            break;
                        case 9:
                            sortBooksByStatusAction.execute();
                            break;
                        case 10:
                            sortBooksByTitleAction.execute();
                            break;
                        case 11:
                            sortBooksByYearOfPublishingAction.execute();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("0 - exit\n" +
                            "1 - create order\n" +
                            "2 - delete order\n" +
                            "3 - change order\n" +
                            "4 - add book to order\n" +
                            "5 - add client to order\n" +
                            "6 - check order for leave request\n" +
                            "7 - open order\n" +
                            "8 - cancel order\n" +
                            "9 - complete order\n" +
                            "10 - get amount completed order\n" +
                            "11 - get completed order\n" +
                            "12 - get profit\n" +
                            "13 - get total price\n" +
                            "14 - sort order by execution data\n" +
                            "15 - sort order by price\n" +
                            "16 - sort order by status\n");
                    i = in.nextInt();
                    switch (i) {
                        case 1:
                            createOrderAction.execute();
                            break;
                        case 2:
                            deleteOrderAction.execute();
                            break;
                        case 3:
                            updateOrderAction.execute();
                            break;
                        case 4:
                            addBookToOrderAction.execute();
                            break;
                        case 5:
                            addClientToOrderAction.execute();
                            break;
                        case 6:
                            checkOrderForLeaveRequestAction.execute();
                            break;
                        case 7:
                            openOrderAction.execute();
                            break;
                        case 8:
                            cancelOrderAction.execute();
                            break;
                        case 9:
                            completeOrderAction.execute();
                            break;
                        case 10:
                            getAmountCompletedOrderAction.execute();
                            break;
                        case 11:
                            getCompletedOrderAction.execute();
                            break;
                        case 12:
                            getProfitAction.execute();
                            break;
                        case 13:
                            getTotalPriceAction.execute();
                            break;
                        case 14:
                            sortOrderByExecutionDataAction.execute();
                            break;
                        case 15:
                            sortOrderByPriceAction.execute();
                            break;
                        case 16:
                            sortOrderByStatusAction.execute();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("0 - exit\n" +
                            "1 - create request\n" +
                            "2 - delete request\n" +
                            "3 - change request\n" +
                            "4 - leave request\n" +
                            "5 - sort request by amount\n" +
                            "6 - sort request by author\n" +
                            "7 - sort request by title\n");
                    i = in.nextInt();
                    switch (i){
                        case 1:
                            createRequestAction.execute();
                            break;
                        case 2:
                            deleteRequestAction.execute();
                            break;
                        case 3:
                            updateRequestAction.execute();
                            break;
                        case 4:
                            leaveRequestAction.execute();
                            break;
                        case 5:
                            sortRequestByAmountAction.execute();
                            break;
                        case 6:
                            sortRequestByAuthorAction.execute();
                            break;
                        case 7:
                            sortRequestByTitleAction.execute();
                            break;

                    }
                    break;*/
            //}
   /*     }
    //зациклить считывание из консоли
      //  0 ...5 пункты меню 0 - взаимодействие с заказаом,
        //  1- взаимодействие с клиентами
        //ввод 1(например) - появляется новое меню
            //0 - создать заказ 1- удалить заказ
            // 2- добавить клиента к заказу(в другом месте sout введите id клиента, введите id заказа)
        // - > действие выполнилось - снова перебрасывает в меню и вывод "клиент такойто добавлен к заказу такомуто"
        // while(i != -1) //-1 - выход из приложения
}*/
