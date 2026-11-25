import controller.BudgetController;
import model.Budget;
import model.User;
import view.BudgetView;

public class BudgetTrackerMain {

    public static void main(String[] args) {

        User user = new User("PlaceHolder");
        Budget budget = new Budget(1000.00); // example limit

        BudgetController controller = new BudgetController(user, budget);
        BudgetView view = new BudgetView(controller);

        view.start();
    }
}
