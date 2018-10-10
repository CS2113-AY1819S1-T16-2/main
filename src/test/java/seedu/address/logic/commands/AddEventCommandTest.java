package seedu.address.logic.commands;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import seedu.address.model.event.Event;
import seedu.address.testutil.EventBuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddEventCommandTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        new AddCommand(null);
    }

    @Test
    public void equals() {
        Event lecture = new EventBuilder().withEventName("Lecture").build();
        Event tutorial = new EventBuilder().withEventName("Tutorial").build();
        AddEventCommand addLectureCommand = new AddEventCommand(lecture);
        AddEventCommand addTutorialCommand = new AddEventCommand(tutorial);

        // same object -> returns true
        assertTrue(addLectureCommand.equals(addLectureCommand));

        // same values -> returns true
        AddEventCommand addLectureCommandCopy = new AddEventCommand(lecture);
        assertTrue(addLectureCommand.equals(addLectureCommandCopy));

        // different types -> returns false
        assertFalse(addLectureCommand.equals(1));

        // null -> returns false
        assertFalse(addLectureCommand.equals(null));

        // different person -> returns false
        assertFalse(addLectureCommand.equals(addTutorialCommand));
    }

    // TODO: ADD MORE TESTS FOR CREATE COMMAND

}
