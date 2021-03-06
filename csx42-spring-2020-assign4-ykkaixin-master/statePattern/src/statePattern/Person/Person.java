package statePattern.Person;

import java.util.LinkedList;
import java.util.Queue;

import statePattern.state.*;;

public class Person {
    private PersonState basicState;
    private PersonState moderatelyExpensiveState;
    private PersonState superExpensiveState;

    int currentMoney = 0;
    int windowSize;
    Queue<Integer> moneyQ;
    private PersonState state;

    public Person(int size) {
        this.basicState = new BasicState(this);
        this.moderatelyExpensiveState = new ModeratelyExpensiveState(this);
        this.superExpensiveState = new SuperExpensiveState(this);
        this.windowSize = size;
        this.moneyQ = new LinkedList<>();
        this.state = basicState;
    }

    /**
     * get Money
     * @money get money input file
     */
    public void getMoney(int money) {
        if (moneyQ.size() == windowSize) {
            int p = moneyQ.poll();
            currentMoney -= p;
            moneyQ.add(money);
            currentMoney += money;
            state.runAverageMoney(currentMoney/windowSize);
        } else {
            moneyQ.add(money);
            currentMoney += money;
        }
        //this.currentMoney = money;
    }

    /**
     * person can buy Item according to state
     */
    public boolean CanBuyItem(String type) {
        return state.canBuyItem(type);
    }

    public void setState(PersonState state) {
        this.state = state;
    }

    public String getState() {
        return this.state.getState();
    }

    public PersonState getModeratelyExpensiveState() {
        return moderatelyExpensiveState;
    }

    public PersonState getSuperExpensiveState() {
        return superExpensiveState;
    }

    public PersonState getBasicState() {
        return basicState;
    }
}