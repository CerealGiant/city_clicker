package com.example.city_clicker;

public interface building {
    public int returnCurrentLevel();
    public int returnUpgradeCost();
    public int returnIncome();
    public boolean returnPurchased();
    public void levelDown();
    public void levelUp();
    private int calculateUpgradeCost(boolean up) {
        return 0;
    }
    public void setPurchased(boolean p); //For refunding/buying the property
}
