package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyEventList;


/**
 * Sort the event list based on the parameters given
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sort by the given parameter \n"
            + "Parameters: "
            + "name, starttime, endtime \n"
            + "Example: "
            + "sort endtime";

    public static final String MESSAGE_SUCCESS = "Successfully sort by %s";

    private static final String KEY_NAME = "name";
    private static final String KEY_STARTTIME = "starttime";
    private static final String KEY_ENDTIME = "endtime";

    private final String key;

    public SortCommand(String sortByParam) {
        requireNonNull(sortByParam);
        key = sortByParam;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model   {@code Model} which the command should operate on.
     * @param history {@code CommandHistory} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public CommandResult execute(Model model, CommandHistory history) throws CommandException {
        ReadOnlyEventList events = model.getEventList();
        switch (key) {
        case (KEY_NAME):
            events.sortByName();
            break;
        case (KEY_STARTTIME):
            events.sortByStartTime();
            break;
        case (KEY_ENDTIME):
            events.sortByEndTime();
            break;
        default:
            break;
        }
        model.commitAddressBook();
        return new CommandResult(String.format(MESSAGE_SUCCESS, key));
    }
}
