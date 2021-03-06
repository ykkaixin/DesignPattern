package numberPlay.observer;

import numberPlay.util.NumberPeaksData;
import numberPlay.subject.*;
import numberPlay.Filter.*;

public class NumberPeaksObserver implements ObserverI {
    SubjectI sub;
    NumberPeaksData n;
    double currentValue = 0;

    public NumberPeaksObserver(SubjectI sub, FilterI filter, NumberPeaksData n) {
        this.sub = sub;
        this.n = n;
        sub.register(this, filter);
    }


    /**
     * find peak store it, when Get message 'COMPLETE' write to File
     */
    @Override
    public void update(String c) {
        if(c == "COMPLETE")
        {
            n.writeToFile();
            n.close();
            return;
        }
        double newValue = Double.parseDouble(c);

        if(newValue > currentValue) {
            currentValue = newValue;
        } else {
            n.store(currentValue);
            currentValue = newValue;
        }
    }
}