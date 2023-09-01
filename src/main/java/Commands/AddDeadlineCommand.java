package Commands;
import OOP.TaskList;
import OOP.Ui;
import OOP.Storage;
import Tasks.Deadline;
import Tasks.Task;
public class AddDeadlineCommand implements Command {
    private Deadline deadline;
    public AddDeadlineCommand(String deadlineName, String deadlineString) {
        Deadline deadline  = Storage.parseDeadlineFromString(deadlineName, deadlineString);
        this.deadline = deadline;
    }

    public Deadline getDeadline() {
        return this.deadline;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.addTask(this.deadline);
        ui.printTaskAddedMessage(this.deadline, tasks);
    }
}
