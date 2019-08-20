package com.spring.sea_battle.game.logic;

import com.spring.sea_battle.game.data.elements.SpaceStates;

public class FindWinner {

    public static boolean init(SpaceStates[][] map) {
        for (SpaceStates[] spaceStates : map) {
            for (SpaceStates spaceState : spaceStates) {
                if (spaceState.equals(SpaceStates.PART_SHIP)) {
                    return false;
                }
            }
        }
        return true;
    }
}
