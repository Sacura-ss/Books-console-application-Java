package controller;

import java.util.Scanner;

public class MenuController {
    private Builder builder;
    private Navigator navigator;

    public MenuController(Builder builder, Navigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        builder.buildMenu();
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();

        Scanner in = new Scanner(System.in);
        int i = 1;
        while (i != -1) {
            i = in.nextInt();
            if(i == -1) { //выход
                break;
            }
            if(i == -2) { //назад
                navigator.setCurrentMenu(builder.getRootMenu());
                navigator.printMenu();
                continue;
            }
            if(i < navigator.getCurrentMenu().getMenuItems().size()) {
                navigator.navigate(i);
            } else {
                System.out.println("No such menu");
            }

        }
    }

    public Builder getBuilder() {
        return builder;
    }

    public Navigator getNavigator() {
        return navigator;
    }
}
