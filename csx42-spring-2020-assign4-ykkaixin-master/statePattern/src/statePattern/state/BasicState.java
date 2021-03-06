package statePattern.state;

import statePattern.Person.Person;

public class BasicState implements PersonState{
    Person p;

    public BasicState(Person p) {
        this.p = p;
    }

    @Override
    public void runAverageMoney(int money) {
        if(money > 10000 && money < 50000) {
            p.setState(p.getModeratelyExpensiveState());
        } else if(money >= 50000) {
            p.setState(p.getSuperExpensiveState());
        }
    }

    @Override
    public boolean canBuyItem(String type) {
        // TODO Auto-generated method stub
        if(type.equals("basic")) return true;
        return false;
    }

    @Override 
    public String getState() {
        return "BASIC" ;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}