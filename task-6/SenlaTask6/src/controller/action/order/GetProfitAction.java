package controller.action.order;

import controller.Reader;
import controller.action.Action;

import java.util.Calendar;

public class GetProfitAction extends Action {
    @Override
    public void execute() {
        System.out.println("Enter date of begin in the format yyyy-MM-dd");
        Calendar begin = Reader.readCalendar();
        System.out.println("Enter date of end in the format yyyy-MM-dd");
        Calendar end = Reader.readCalendar();

        System.out.println(orderService.getProfit(begin, end));
    }
}
