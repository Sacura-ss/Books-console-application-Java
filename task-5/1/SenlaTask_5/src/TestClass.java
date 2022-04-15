import controller.Builder;
import controller.MenuController;
import controller.Navigator;

public class TestClass {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Navigator navigator = new Navigator();
        MenuController menuController = new MenuController(builder, navigator);
        menuController.run();

    }
}
