package command;
import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import task.Todo;

public class TodoCommand extends Command {

    String str;

    public TodoCommand(String str) {
        this.str = str;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String sub = str.substring(4).trim();
        if (!sub.isEmpty()) {
            StringBuilder output = new StringBuilder();
            tasks.addTask(new Todo(str.substring(5)));
            storage.saveLocalData(tasks.getTasks());
            output.append("Got it, I've added this task:\n");
            output.append(tasks.getTasks().get(tasks.size() - 1).toString());
            output.append(String.format("\nNow you have %d tasks in the list.\n", tasks.size()));
            return output.toString();
        } else {
            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
        }
    }
}
