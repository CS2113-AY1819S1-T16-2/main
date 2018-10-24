package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.LoginCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class LoginParser {
    public static final String KEY_MANAGER = "manager";
    public static final String KEY_EMPLOYEE = "employee";

    private static final String MESSAGE_INVALID_LOGIN = "Login identity should be either the following:"
            + "\nmanager\nempolyee";

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */


    public static LoginCommand loginCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case KEY_MANAGER:
            return new LoginCommand(KEY_MANAGER);

        case KEY_EMPLOYEE:
            return new LoginCommand(KEY_EMPLOYEE);

        default:
            throw new ParseException(MESSAGE_INVALID_LOGIN);
        }
    }

}
