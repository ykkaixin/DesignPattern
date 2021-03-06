package statePattern.state;

import statePattern.Person.Person;

public class SuperExpensiveState implements PersonState {
    Person p;

    public SuperExpensiveState(Person p) {
        this.p = p;
    }
    @Override
    public void runAverageMoney(int money) {
        if(money > 10000 && money < 50000) {
            p.setState(p.getModeratelyExpensiveState());
        } else if(money < 10000) {
            p.setState(p.getBasicState());
        } 
    }

    @Override
    public boolean canBuyItem(String type) {
        if(type.equals("superExpensive") || type.equals("basic") || type.equals("moderatelyExpensive")) return true;
        return false;
    }

    @Override
    public String getState() {
        // TODO Auto-generated method stub
        return "EXTRAVAGANT";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}