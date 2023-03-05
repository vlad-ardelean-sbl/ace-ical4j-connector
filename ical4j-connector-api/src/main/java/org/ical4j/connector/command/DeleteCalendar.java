package org.ical4j.connector.command;

import net.fortuna.ical4j.model.Calendar;
import org.ical4j.connector.*;
import picocli.CommandLine;

import static org.ical4j.connector.ObjectCollection.DEFAULT_COLLECTION;

@CommandLine.Command(name = "delete-calendar", description = "Delete calendar objects with specified UID")
public class DeleteCalendar extends AbstractCollectionCommand<CalendarCollection, Calendar> {

    @CommandLine.Option(names = {"-I", "--uid"})
    private String calendarUid;

    public DeleteCalendar() {
        super(DEFAULT_COLLECTION, calendar -> {});
    }

    public DeleteCalendar(ObjectStore<CalendarCollection> store) {
        super(DEFAULT_COLLECTION, calendar -> {}, store);
    }

    public DeleteCalendar(String collectionName, ObjectStore<CalendarCollection> store) {
        super(DEFAULT_COLLECTION, calendar -> {}, store);
    }

    public DeleteCalendar withCalendarUid(String calendarUid) {
        this.calendarUid = calendarUid;
        return this;
    }

    @Override
    public void run() {
        try {
            getConsumer().accept(getCollection().removeCalendar(calendarUid));
        } catch (ObjectStoreException | FailedOperationException | ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
