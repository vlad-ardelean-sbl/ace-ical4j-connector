package org.ical4j.connector.command;

import org.ical4j.connector.CardCollection;
import org.ical4j.connector.FailedOperationException;
import org.ical4j.connector.ObjectNotFoundException;
import picocli.CommandLine;

@CommandLine.Command(name = "delete-card", description = "Delete vCard objects with specified UID")
public class DeleteCard extends AbstractCommand<CardCollection> {

    private final CardCollection collection;

    private String cardUid;

    public DeleteCard(CardCollection collection) {
        this.collection = collection;
    }

    public DeleteCard withCardUid(String cardUid) {
        this.cardUid = cardUid;
        return this;
    }

    @Override
    public void run() {
        try {
            collection.removeCard(cardUid);
        } catch (FailedOperationException | ObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}