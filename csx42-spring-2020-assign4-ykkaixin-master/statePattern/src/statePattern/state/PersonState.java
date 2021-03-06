package statePattern.state;

public interface PersonState {
    void runAverageMoney(int money);
    boolean canBuyItem(String type);
    String getState();
}