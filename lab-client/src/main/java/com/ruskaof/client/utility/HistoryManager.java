package com.ruskaof.client.utility;

import java.util.Queue;
import java.util.StringJoiner;
import java.util.concurrent.ArrayBlockingQueue;

public class HistoryManager {
    private final int capacity = 6;
    private final Queue<String> history = new ArrayBlockingQueue<>(capacity);

    public void addNote(String note) {
        if (history.size() == capacity) {
            history.remove();
        }
        history.add(note);
    }

    public String niceToString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("The last 6 commands were:");
        for (String commandName : history) {
            stringJoiner.add(commandName);
        }
        return stringJoiner.toString();
    }
}
