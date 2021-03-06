package numberPlay.observer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

import numberPlay.util.RunningAverageData;
import numberPlay.subject.*;
import numberPlay.Filter.*;

public class RunningAverageObserver implements ObserverI{
    private int windowSize;
    private LinkedList<Double> q;
    private SubjectI sub;
    private RunningAverageData r;
    private double averageValue = 0.0;

    public RunningAverageObserver(int windowSize, SubjectI sub,FilterI f,
                                    RunningAverageData r) {
        this.windowSize = windowSize;
        this.sub = sub;
        q = new LinkedList<>();
        sub.register(this, f);
        this.r = r;
    }

    /**
     * write to File when get notify "COMPLETE"
     * calculate the average according window size
     */
    @Override
    public void update(String c) {
        if(c == "COMPLETE") {
            r.writeToFile();
            r.close();
            return;
        }
        double newValue = Double.parseDouble(c);

        if(q.size() == windowSize) { 
            q.removeFirst();
            q.add(newValue);
            calculateAvg(windowSize);
            r.store(averageValue);
        } else {
            q.add(newValue);      
            calculateAvg(q.size());
            r.store(averageValue);
        }
    }

    /**
     * calculate the average
     * get the avg and set to @averageValue;
     * @param size the number of read
     */
    private void calculateAvg(int size) {
        double sum = 0;
        for(int i = 0; i < size; i++) {
            sum += q.get(i);
        }
        DecimalFormat df = new DecimalFormat("#.##");
        double avg = sum / size;
        avg = Double.valueOf(df.format(avg));
        averageValue = avg;
    }
}