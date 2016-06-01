package mvc;

/**
 * Created by Potaychuk Sviatoslav on 01.06.2016.
 */
public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
