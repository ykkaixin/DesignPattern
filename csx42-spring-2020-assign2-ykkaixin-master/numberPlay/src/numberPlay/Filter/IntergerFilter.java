package numberPlay.Filter;

public class IntergerFilter implements FilterI{

    @Override
    public boolean check(String c) {
        try {
            int i = Integer.parseInt(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
