package numberPlay.subject;
import numberPlay.observer.*;
import numberPlay.Filter.*;

public interface SubjectI  {
    void process(String c);
    void register(ObserverI o, FilterI f);
    void notifyAll(String c);
}