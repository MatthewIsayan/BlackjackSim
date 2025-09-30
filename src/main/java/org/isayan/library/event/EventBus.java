package org.isayan.library.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private static final Logger LOGGER = LogManager.getLogger(EventBus.class);
    private final List<EventListener> listeners = new ArrayList<>();

    public EventBus() {
    }

    public void subscribe(EventListener listener) {
        LOGGER.trace("{} subscribed", listener.getClass().getSimpleName());
        listeners.add(listener);
    }

    public void publish(Event event) {
        LOGGER.trace("Publishing [{}]", event.getClass().getSimpleName());
        listeners.forEach(listener -> listener.listen(event));
    }
}
