package numberPlay.subject;

import java.util.Map;

import numberPlay.observer.ObserverI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import numberPlay.Filter.FilterI;

public class NumberGrabber implements SubjectI {

    Map<FilterI,List<ObserverI>> observers;

    public NumberGrabber() {
        observers = new HashMap<FilterI, List<ObserverI>>();
    }

    @Override
    public void process(String c) {
        notifyAll(c);
    }

    @Override
	public
    void register(ObserverI o, FilterI f) {
        if (!observers.containsKey(f)) {
            observers.put(f, new ArrayList<ObserverI>());
        }
        observers.get(f).add(o);
    }


    @Override
    public void notifyAll(String c) {
        if(c == "COMPLETE") {
            for(Map.Entry<FilterI, List<ObserverI>> entry : observers.entrySet()) {
                for(ObserverI o : entry.getValue()) {
                    o.update(c);
                }
            }
        } else {
            for(Map.Entry<FilterI, List<ObserverI>> entry : observers.entrySet()) {
                if(entry.getKey().check(c)) {
                    for(ObserverI o : entry.getValue()) {
                        o.update(c);
                    }
                }
            }
        }
    }
        
        
}
