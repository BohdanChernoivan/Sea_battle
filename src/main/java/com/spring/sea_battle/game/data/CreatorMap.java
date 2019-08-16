package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.SpaceStates;

public class CreatorMap {

    private SpaceStates[][] map;

    public CreatorMap(int sizeBoard) {
        map = new SpaceStates[sizeBoard][sizeBoard];
        generation();
    }

    public SpaceStates[][] getMap() {
        return map;
    }


    private void generation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = SpaceStates.WATER;
            }
        }
    }

}
