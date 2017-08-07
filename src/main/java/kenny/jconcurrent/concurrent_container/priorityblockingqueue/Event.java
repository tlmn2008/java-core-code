package kenny.jconcurrent.concurrent_container.priorityblockingqueue;

import java.util.Comparator;

public class Event implements Comparable<Event> {

    private String name;

    private int priority;

    public Event(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Event o) {
        return this.priority < o.getPriority() ? -1 : this.priority > o.getPriority() ? 1 : 0;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
