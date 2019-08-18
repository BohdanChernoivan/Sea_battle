package com.spring.sea_battle.game.data;

import com.spring.sea_battle.game.data.elements.ShootStates;

import java.util.Random;

import static com.spring.sea_battle.game.TestBattle.SIZE_BOARD;


public class CreatorShip {

    private ShootStates state;


    public CreatorShip() {
        this.state = ShootStates.PART_SHIP;
    }

    public void createShip(ShootStates[][] map, int startX, int startY, int lengthShip) {

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



    private int rndLocationInBoard() {
        return new Random().nextInt(SIZE_BOARD);
    }

    private int direction(ShootStates[][] map, int x, int y) {
        if (map.length - x > x) {
            return -1;
        } else if (map.length - y > y) {
            return 1;
        } else {
            return 0;
        }
    }
}
