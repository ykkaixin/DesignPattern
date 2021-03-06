package numberPlay.observer;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Collections;

import numberPlay.util.TopKNumbersData;
import numberPlay.subject.*;
import numberPlay.Filter.*;
import java.util.List;

public class TopKNumbersObserver implements ObserverI{
    private int windowSize;
    private PriorityQueue<Double> q;
    private List<Double> list;
    private ArrayList<Double> list2;
    private SubjectI sub;
    private TopKNumbersData r;

    public TopKNumbersObserver(int windowSize, SubjectI sub,FilterI f,
                                    TopKNumbersData r) {
        this.windowSize = windowSize;
        this.sub = sub;
        this.q = new PriorityQueue<Double>(
            new Comparator<Double>() {
                public int compare(Double a, Double b) {
                    BigDecimal b1 = BigDecimal.valueOf(a);
                    BigDecimal b2 = BigDecimal.valueOf(b);
                    return b2.compareTo(b1);
                }
            }
        );


        this.list = new ArrayList<>();
        this.list2 = new ArrayList<>();
        sub.register(this, f);
        this.r = r;
    }

    /**
     * write to File when get notify "COMPLETE"
     * using priorityQueue to add the value and get the number 
     */
    @Override
    public void update(String c) {
        if(c == "COMPLETE") 
        {
            r.writeToFile();
            r.close();
            return;
        }

        double newValue = Double.parseDouble(c);

        list2.add(newValue);
        Collections.sort(list2, Collections.reverseOrder());
        int size = list2.size();

        if(size > windowSize) {
            size = windowSize;
            for(int i = 0; i < size; i++) {
                double v = list2.get(i);
                list.set(i, v);
            }
        } else {
            list.add(0.0);
            Collections.copy(list, list2);
        }

        r.store(list);


    }
}