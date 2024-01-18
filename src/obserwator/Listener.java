package obserwator;

import java.util.List;

public interface Listener {
    void update(String eventType, List<String> data);
}
