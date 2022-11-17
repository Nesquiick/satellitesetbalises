package events;

public interface SynchroSatelliteEventListener {
    void whenStartSynchro(SynchroSatelliteEvent arg);
    void whenStopSynchro(SynchroSatelliteEvent arg);
}
