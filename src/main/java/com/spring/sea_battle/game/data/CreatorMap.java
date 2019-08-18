package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.ShotsStates;

import java.util.Arrays;

public class CreatorMap {

    private ShotsStates[][] map;

    public CreatorMap(int sizeBoard) {
        map = new ShotsStates[sizeBoard][sizeBoard];
        generation();
    }

    public ShotsStates[][] getMap() {
        return map;
    }

    public String[] getMapViewString() {

        String[] mapView = new String[map.length];

            for (int i = 0; i < map.length; i++) {
            mapView[i] = Arrays.toString(map[i]);
        }
            return mapView;
    }


    private void generation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = ShotsStates.WATER;
            }
        }
    }

}
