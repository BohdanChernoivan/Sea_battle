package com.spring.sea_battle.game.logic;


import com.spring.sea_battle.game.data.elements.ShipStates;
import com.spring.sea_battle.game.data.elements.SpaceStates;



public class PlayerShoot {

    public String moveOut = "Move сame out of the map";
    public String wentHere = "You went here";

    public String shootControl(SpaceStates[][] map, int x, int y) {
        if (map.length < x || map.length < y) {
            return moveOut;
        } else if (map[x][y].equals(SpaceStates.DESTROYED) || map[x][y].equals(SpaceStates.EMPTY)) {
            return wentHere;
        } else {
            if (map[x][y].getState().equals(SpaceStates.WATER.getState())) {
                map[x][y] = SpaceStates.EMPTY;
                return ShipStates.MISSED.getState();
            } else if (map[x][y].getState().equals(SpaceStates.PART_SHIP.getState())) {
                map[x][y] = SpaceStates.DESTROYED;
                if (checkKilling(map, x, y)) {
                    String view = ShipStates.INJURED.getState() + " and " + ShipStates.KILLED.getState();
                    return view;
                }
                return ShipStates.INJURED.getState();
            } else if (map[x][y].getState().equals(SpaceStates.DESTROYED.getState())) {
                return ShipStates.KILLED.getState();
            } else
                throw new IllegalArgumentException("What do you do?");
        }
    }

    private boolean checkKilling(SpaceStates[][] map, int x, int y) {

        for (int i = x; i <= x; i++) {
            for (int j = y; j < map[i].length; j++) {
                if (map[i][j].getState().equals(SpaceStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = x; i <= x; i++) {
            for (int j = y; j >= 0; j--) {
                if (map[i][j].getState().equals(SpaceStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = y; i <= y; i++) {
            for (int j = x; j < map[i].length ; j++) {
                if (map[j][i].getState().equals(SpaceStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = y; i <= y; i++) {
            for (int j = x; j >= 0; j--) {
                if (map[j][i].getState().equals(SpaceStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        return true;
    }
}
