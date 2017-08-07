package kenny.jconcurrent.concurrent_container.delayqueue;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Event implements Delayed {

    private String name;
    private Date createDate;
    private long delay;

    public Event(String name, Date createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = createDate.getTime() - now.getTime();
        delay = unit.convert(diff, TimeUnit.MILLISECONDS);
        return delay;
    }

    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return result < 0 ? -1 : result > 0 ? 1 : 0;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public long getDelay() {
        return delay;
    }
}
