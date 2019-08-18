package com.spring.sea_battle.game.logic;


import com.spring.sea_battle.game.data.elements.ShipStates;
import com.spring.sea_battle.game.data.elements.ShootStates;



public class PlayerShoot {


    public String shootControl(ShootStates[][] map, int x, int y) {
        if (map.length < x || map.length < y) {
            return "Move сame out of the map";
        } else if (map[x][y].equals(ShootStates.DESTROYED) || map[x][y].equals(ShootStates.EMPTY)) {
            return "You went here";
        } else {
            if (map[x][y].getState().equals(ShootStates.WATER.getState())) {
                map[x][y] = ShootStates.EMPTY;
                return ShipStates.MISSED.getState();
            } else if (map[x][y].getState().equals(ShootStates.PART_SHIP.getState())) {
                map[x][y] = ShootStates.DESTROYED;
                if (checkKilling(map, x, y)) {
                    String view = ShipStates.INJURED.getState() + " and " + ShipStates.KILLED.getState();
                    return view;
                }
                return ShipStates.INJURED.getState();
            } else if (map[x][y].getState().equals(ShootStates.DESTROYED.getState())) {
                return ShipStates.KILLED.getState();
            } else
                throw new IllegalArgumentException("What do you do?");
        }
    }

    private boolean checkKilling(ShootStates[][] map, int x, int y) {

        for (int i = x; i <= x; i++) {
            for (int j = y; j < map[i].length; j++) {
                if (map[i][j].getState().equals(ShootStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = x; i <= x; i++) {
            for (int j = y; j >= 0; j--) {
                if (map[i][j].getState().equals(ShootStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = y; i <= y; i++) {
            for (int j = x; j < map[i].length ; j++) {
                if (map[j][i].getState().equals(ShootStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        for (int i = y; i <= y; i++) {
            for (int j = x; j >= 0; j--) {
                if (map[j][i].getState().equals(ShootStates.PART_SHIP.getState())) {
                    return false;
                }
            }
        }

        return true;
    }
}
