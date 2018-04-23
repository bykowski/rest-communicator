package app;

import org.springframework.stereotype.Service;

@Service
public class HistroyService {

    private String history = "";

    public String getHistory() {
        return history;
    }

    public void addHistory(String text) {
        this.history += text + System.lineSeparator();
    }
}
