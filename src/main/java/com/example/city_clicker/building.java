package com.example.city_clicker;

public abstract class building {
    private static boolean purchased;
    private static int upgradeCost; //shows cost for the next level
    private final int purchaseCost = 0;
    private static int level = 1;
    private static int incomePerSecond;


    public building() {
        purchased = false;
    }

    protected int calculateUpgradeCost(boolean up) {
        //upgradecost = upgradecost*1.2 -> for the next level
        //upgradecost = upgradcost*0.8
        if(up) {
            return (int) (upgradeCost * 1.2);
        }
        //If level is decreasing
        return (int) (upgradeCost/1.2);
    }

    public void levelDown() {
        level--;
        upgradeCost = calculateUpgradeCost(false);
        incomePerSecond = level;
    }

    public void levelUp() {
        level++;
        upgradeCost = calculateUpgradeCost(true); //display upgrade cost for next level
        incomePerSecond = level;
    }
    public int returnCurrentLevel() {
        return level;
    }

    public int returnUpgradeCost() {
        return upgradeCost;
    }

    public int returnIncome() {
        return incomePerSecond;
    }

    public boolean returnPurchased() {
        return purchased;
    }


    public void setPurchased(boolean p) {
        purchased = p;
    }

}
