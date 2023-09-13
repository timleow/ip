package Commands;

import java.util.List;
import java.util.stream.Collectors;

import OOP.Storage;
import OOP.TaskList;
import OOP.Ui;
import Tasks.Task;

/**
 * The command that helps user search for tasks by using some search text.
 */
public class FindTasksCommand implements Command {
    private String searchText;
    public FindTasksCommand(String searchText) {
        this.searchText = searchText;
    }

    /**
     * {@inheritDoc}
     *
     * Executes the FindTasksCommand which filters out task based on a string prompt.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        List<Task> filteredTasks = tasks.getTasks().stream().filter(t -> {
            return t.toString().contains(searchText);
        }).collect(Collectors.toList());
        // get UI to print out the filtered list of tasks
        int i = 0;
        String res = ui.printFindTaskMessage();
        for (Task task : filteredTasks) {
            assert task.toString().contains(searchText);
            res += ui.printTask(i, task);
            i++;
        }
        return res;
    }
}
