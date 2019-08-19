package com.spring.sea_battle.game.logic;

import com.spring.sea_battle.game.data.elements.ShootStates;

public class FindWinner {

    public static String init(ShootStates[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals(ShootStates.PART_SHIP)) {
                    return "Winner not found";
                }
            }
        }
        return "Winner found!";
    }
}
