package com.spring.sea_battle.game.data.elements;

public enum ShipStates {

    INJURED("Injured"),
    KILLED("Killed"),
    MISSED("Missed");

    private String state;

    ShipStates(String state) {
    this.state = state;
    }

    public String getState() {
        return state;
    }
}
