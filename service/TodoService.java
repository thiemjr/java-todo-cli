package service;

import model.Todo;
import storage.TodoStorage;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

    private List<Todo> todos;

    public TodoService() {
        this.todos = TodoStorage.load();
    }

    public void add(String title) {
        int id = todos.size() + 1;
        todos.add(new Todo(id, title));
        TodoStorage.save(todos);
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }
}
