package statePattern.state;

import statePattern.Person.Person;

public class ModeratelyExpensiveState implements PersonState{
    Person p;

    public ModeratelyExpensiveState(Person p) {
        this.p = p;
    }
    @Override
    public void runAverageMoney(int money) {
        if(money < 10000 ) {
            p.setState(p.getBasicState());
        } else if(money >= 50000) {
            p.setState(p.getSuperExpensiveState());
        }
    }

    @Override
    public boolean canBuyItem(String type) {
        // TODO Auto-generated method stub
        if(type.equals("moderatelyExpensive") || type.equals("basic")) return true;
        return false;
    }

    @Override
    public String getState() {
        // TODO Auto-generated method stub
        return "LUXURIOUS";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}