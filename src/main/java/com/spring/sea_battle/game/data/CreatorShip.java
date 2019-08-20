package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.SpaceStates;



public class CreatorShip {

    public final static int HUGE_SHIP = 4;
    public final static int BIG_SHIP = 3;
    public final static int AVERAGE_SHIP = 2;
    public final static int SMALL_SHIP = 1;

    private SpaceStates state;

    public CreatorShip() {
        this.state = SpaceStates.PART_SHIP;
    }

    public void createShip(SpaceStates[][] map, int startX, int startY, int lengthShip) {

        int equals = direction(map, startX, startY);

        if (equals == 1) {
            for (int i = startX; i <= startX; i++) {
                for (int j = startY; j < startY + lengthShip; j++) {
                    map[i][j] = state;
                }
            }
        } else if (equals == -1){
            for (int i = startY; i <= startY; i++) {
                for (int j = startX; j < startX + lengthShip; j++) {
                    map[j][i] = state;
                }
            }
        } else
            throw new IllegalArgumentException("over map limit, enter again Row and Column");

    }



    private int direction(SpaceStates[][] map, int x, int y) {
        if (map.length - x > x) {
            return -1;
        } else if (map.length - y > y) {
            return 1;
        } else {
            return 0;
        }
    }
}
