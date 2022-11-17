package model;

import events.SatelliteMoved;
import events.SynchroSatelliteEvent;

public class SynchronisationAntenneSatellite extends Deplacement{

    private int synchroTime;
    private Satellite synchro;

    public Boolean synchroStarted() {
        return this.synchro != null;
    }

    public SynchronisationAntenneSatellite() {
        this.synchroTime = 10;
        this.synchro = null;
    }


    public void whenSatelitteMoved(SatelliteMoved arg, Antenne target) {
        if (synchroStarted()) return;
        Satellite sat = (Satellite) arg.getSource();
        int satX = sat.getPosition().x;
        int tarX = target.getPosition().x;
        if (satX > tarX - 10 && satX < tarX + 10 && sat.getDataSize()>0) {
            this.synchro = sat;
            target.send(new SynchroSatelliteEvent(this));
            this.synchro.send(new SynchroSatelliteEvent(this));
            sat.resetData();
        }
    }

    @Override
    public void bouge(ElementMobile target) {
        if (this.synchro == null) return;
        this.synchroTime--;
        if (synchroTime <= 0) {
            Satellite sat = this.synchro;
            this.synchro = null;
            this.synchroTime = 10;
            target.send(new SynchroSatelliteEvent(this));
            sat.send(new SynchroSatelliteEvent(this));
        }
    }
}
