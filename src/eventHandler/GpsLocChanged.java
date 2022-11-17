package eventHandler;

public class GpsLocChanged extends AbstractEvent{
    public GpsLocChanged(Object source) {
        super(source);
    }

    public void sendTo(Object listener){
        ElementMobileListener e = (ElementMobileListener) listener;
        e.whenGpsLocChanges(this);
    }

}
