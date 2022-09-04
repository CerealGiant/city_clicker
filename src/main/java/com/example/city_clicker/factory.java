package com.example.city_clicker;

public class factory implements building{

    private static boolean purchased;
    private static int upgradeCost; //shows cost for the next level
    private final int purchaseCost = 10;
    private static int level = 1;
    private static int incomePerSecond;

    public factory() {
        purchased = false;
        upgradeCost = (int)(purchaseCost*1.2);
        incomePerSecond = 1;
    }

    private int calculateUpgradeCost(boolean up) {
        //upgradecost = upgradecost*1.2 -> for the next level
        //upgradecost = upgradcost*0.8
        if(up) {
            return (int) (upgradeCost * 1.2);
        }
        //If level is decreasing
        return (int) (upgradeCost/1.2);
    }

    @Override
    public void levelDown() {
        level--;
        upgradeCost = calculateUpgradeCost(false);
        incomePerSecond = level;
    }

    @Override
    public void levelUp() {
        level++;
        upgradeCost = calculateUpgradeCost(true); //display upgrade cost for next level
        incomePerSecond = level;
    }

    @Override
    public int returnCurrentLevel() {
        return level;
    }

    @Override
    public int returnUpgradeCost() {
        return upgradeCost;
    }

    @Override
    public int returnIncome() {
        return incomePerSecond;
    }

    @Override
    public boolean returnPurchased() {
        return purchased;
    }

    @Override
    public void setPurchased(boolean p) {
        purchased = p;
    }
}
