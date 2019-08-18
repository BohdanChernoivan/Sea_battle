package com.spring.sea_battle.game.data.elements;


public enum ShootStates {

    EMPTY(" "),
    WATER("~"),
    PART_SHIP("*"),
    DESTROYED("#");

    private String state;

    ShootStates(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return getState();
    }
}
