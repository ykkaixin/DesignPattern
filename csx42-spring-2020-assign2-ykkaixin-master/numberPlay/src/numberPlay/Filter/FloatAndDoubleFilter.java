package numberPlay.Filter;
public class FloatAndDoubleFilter implements FilterI{
    
    @Override
    public boolean check(String c) {
        try {
            double d = Double.parseDouble(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
