package obserwator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventManager {
    private static EventManager eventManager;
    private EventManager() {

    }
    public static EventManager getInstance() {
        if (eventManager == null)
            eventManager = new EventManager();
        return eventManager;
    }

    public HashMap<String, List<Listener>> listeners = new HashMap<>();
    public void subscribe(String eventType, Listener listener) {
        if (listeners.containsKey(eventType)) {
            List<Listener> subscribers = new ArrayList<>(listeners.get(eventType));
            if (!subscribers.contains(listener))
                subscribers.add(listener);
            listeners.put(eventType, subscribers);
        }
        else {
            listeners.put(eventType, List.of(listener));
        }
    }

    public void unsubscribe(String eventType, Listener listener) {
        List<Listener> subscribers = listeners.get(eventType);
        subscribers.remove(listener);
     }

    public void notify(String eventType, List<String> data) {
        for (Listener listener : listeners.get(eventType)) {
            listener.update(eventType, data);
        }
    }
}
