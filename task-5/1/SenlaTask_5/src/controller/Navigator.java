package controller;

public class Navigator {
    private Menu currentMenu;

    public void printMenu() {
        for (MenuItem abstractMenuItem : currentMenu.getMenuItems()) {
            System.out.println(abstractMenuItem.getTitle());
        }
    }

    public void navigate(Integer index) {
        // если кнопка имеет соедующее меню - переходим на новое меню
        if (currentMenu.getMenuItems().get(index).getNextMenu() != null) {
            currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
            printMenu();
        }
        // иначе, выполняем действие кнопки
        else if (currentMenu.getMenuItems().get(index).getAction() != null)
            currentMenu.getMenuItems().get(index).doAction();
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
