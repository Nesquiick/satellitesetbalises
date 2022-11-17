package events;

import eventHandler.AbstractEvent;
import model.SynchronisationAntenneSatellite;

public class SynchroSatelliteEvent extends AbstractEvent {

    public SynchroSatelliteEvent(Object source) {
        super(source);
    }

    @Override
    public void sendTo(Object target) {
        SynchroSatelliteEventListener listener = (SynchroSatelliteEventListener) target;
        SynchronisationAntenneSatellite synchro = (SynchronisationAntenneSatellite) this.getSource();
        if (synchro.synchroStarted())
            listener.whenStartSynchro(this);
        else
            listener.whenStopSynchro(this);
    }
}
