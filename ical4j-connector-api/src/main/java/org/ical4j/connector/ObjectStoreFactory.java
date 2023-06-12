package org.ical4j.connector;

import org.ical4j.connector.local.LocalCalendarStore;

import java.io.File;
import java.util.Properties;

public class ObjectStoreFactory {

    private final Properties properties;

    public ObjectStoreFactory() {
        this(System.getProperties());
    }

    public ObjectStoreFactory(Properties properties) {
        this.properties = properties;
    }

    public <C extends ObjectCollection<?>> ObjectStore<C> newInstance() {

//        try {
//            return (ObjectStore<C>) new LocalCalendarStore(Files.createTempDirectory("ical-local").toFile());
            return (ObjectStore<C>) new LocalCalendarStore(new File("ical-local"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}