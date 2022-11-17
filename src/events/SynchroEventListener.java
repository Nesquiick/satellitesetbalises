package events;

public interface SynchroEventListener {
	void whenStartSynchro(SynchroEvent arg);
	void whenStopSynchro(SynchroEvent arg);
}
