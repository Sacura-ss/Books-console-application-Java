package controller;

import controller.action.IAction;

public class MenuItem {
    String title;
    IAction action;
    Menu nextMenu;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
    }

    public void doAction() {
        getAction().execute();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }


}
