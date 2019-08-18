package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.ShootStates;

import java.util.Arrays;

public class CreatorMap {

    private ShootStates[][] map;

    public CreatorMap(int sizeBoard) {
        map = new ShootStates[sizeBoard][sizeBoard];
        generation();
    }

    public ShootStates[][] getMap() {
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
                map[i][j] = ShootStates.WATER;
            }
        }
    }

}
