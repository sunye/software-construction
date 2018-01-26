package fr.unantes.alarms;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created on 19/01/2018.
 *
 * @author NaoMod team.
 */
public class Alarm {

    private final BlockingQueue<Notify> notifications = new ArrayBlockingQueue<Notify>(10);

    public void accept(Notify notify) {
        this.notifications.offer(notify);
    }

    // TODO: write a thread that reads the blocking queue and executes the notification.
}
