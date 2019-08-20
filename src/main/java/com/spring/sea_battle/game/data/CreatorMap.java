package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.SpaceStates;

import java.util.Arrays;

public class CreatorMap {

    private SpaceStates[][] map;

    public CreatorMap(int sizeBoard) {
        map = new SpaceStates[sizeBoard][sizeBoard];
        generation();
    }

    public SpaceStates[][] getMap() {
        return map;
    }

    public String[] getMapViewString() {

        String[] mapView = new String[map.length];

            for (int i = 0; i < map.length; i++) {
            mapView[i] = Arrays.toString(map[i]);
        }
            return mapView;
    }

    public void getMapSOUT() {

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }


    private void generation() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = SpaceStates.WATER;
            }
        }
    }

}
