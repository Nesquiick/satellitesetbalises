package model;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;

import java.awt.*;

public class Element {
    private Point position;
    private final EventHandler eventHandler;
    //Les variables de mémoires restent en cas d'une possible evolution, l'antenne pourra elle aussi avoir de la mémoire etc
    private int dataSize;
    private Manager manager;

    public Element() {
        eventHandler = new EventHandler();
        this.dataSize = 0;
        this.position = new Point(0, 0);
    }

    public int getDataSize() {
        return this.dataSize;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
        eventHandler.registerListener(whichEventType, listener);
    }

    public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
        eventHandler.unregisterListener(whichEventType, listener);
    }

    public void send(AbstractEvent event) {
        eventHandler.send(event);
    }

    public void tick() {
        this.action();
    }

    public void action() {}

    public void setPosition(Point position) {
        if (this.position.equals(position))
            return;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public Manager getManager() {
        return manager;
    }
}
