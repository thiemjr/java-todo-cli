import model.Todo;
import service.TodoService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoService service = new TodoService();

        while (true) {
            System.out.println("\n=== TODO APP ===");
            System.out.println("1. Add Todo");
            System.out.println("2. List Todos");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter todo: ");
                    String title = scanner.nextLine();
                    service.add(title);
                    System.out.println("Added!");
                    break;

                case 2:
                    List<Todo> todos = service.getAll();
                    if (todos.isEmpty()) {
                        System.out.println("No todos.");
                    } else {
                        for (Todo t : todos) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Bye!");
                    return;
            }
        }
    }
}
