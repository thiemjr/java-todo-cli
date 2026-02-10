package storage;

import model.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TodoStorage {

    private static final String FILE_NAME = "todos.txt";

    public static List<Todo> load() {
        List<Todo> todos = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return todos;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int id = 1;
            while ((line = br.readLine()) != null) {
                todos.add(new Todo(id++, line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return todos;
    }

    public static void save(List<Todo> todos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Todo t : todos) {
                bw.write(t.getTitle());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
