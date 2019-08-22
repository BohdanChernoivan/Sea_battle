package com.spring.sea_battle.game.logic;

import com.spring.sea_battle.game.data.elements.SpaceStates;
import lombok.Getter;

import java.util.Random;

import static com.spring.sea_battle.game.TestBattle.SIZE_BOARD;

@Getter
public class AutomaticPlaceShip {

    protected static int lengthShip = 0;
    protected static int rowShip = 0;
    protected static int columnShip = 0;

    public static void createAutomaticShip(SpaceStates[][] map, int size) {

        int row = rndLocationInBoard();
        int column = rndLocationInBoard();

        int equals = checkLocation(map, row, column, size);

        if (row < map.length || column < map.length) {

            if (equals == 1) {
                for (int i = column; i <= column; i++) {
                    for (int j = row; j < row + size; j++) {
                        map[i][j] = SpaceStates.PART_SHIP;
                    }
                }
            } else if (equals == 2) {
                for (int i = row; i <= row; i++) {
                    for (int j = column; j < column + size; j++) {
                        map[j][i] = SpaceStates.PART_SHIP;
                    }
                }
            } else if (equals == 3) {
                for (int i = column; i <= column; i++) {
                    for (int j = row; j > row-size; j--) {
                        map[i][j] = SpaceStates.PART_SHIP;
                    }
                }
            } else if (equals == 4) {
                for (int i = row; i <= row; i++) {
                    for (int j = column; j > column-size; j--) {
                        map[j][i] = SpaceStates.PART_SHIP;
                    }
                }
            } else createAutomaticShip(map, size);

        } else createAutomaticShip(map, size);
    }

    public static int rndLocationInBoard() {
        return new Random().nextInt(SIZE_BOARD);
    }

    private static int checkLocation(SpaceStates[][] map, int startCreate, int endCreate, int size) {

        int maxSize = 0;

        if(startCreate + size <= map.length) {
            for (int i = endCreate; i <= endCreate; i++) {
                for (int j = startCreate; j < startCreate + size; j++) {
                    if (map[endCreate][startCreate].equals(SpaceStates.WATER)) {
                        maxSize++;
                    } else maxSize = 0;

                    if (maxSize == size) {
                        lengthShip = size;
                        startCreate = rowShip;
                        endCreate = columnShip;
                        return 1;
                    }
                }
            }
        }

        if(endCreate + size <= map.length) {
            for (int i = startCreate; i <= startCreate; i++) {
                for (int j = endCreate; j < endCreate + size; j++) {
                    if (map[endCreate][startCreate].equals(SpaceStates.WATER)) {
                        maxSize++;
                    } else maxSize = 0;

                    if (maxSize == size) {
                        lengthShip = size;
                        startCreate = rowShip;
                        endCreate = columnShip;
                        return 2;
                    }
                }
            }
        }

        if(startCreate - size >= 0) {
            for (int i = endCreate; i <= endCreate; i++) {
                for (int j = startCreate; j < startCreate - size; j--) {
                    if (map[endCreate][startCreate].equals(SpaceStates.WATER)) {
                        maxSize++;
                    } else maxSize = 0;

                    if (maxSize == size) {
                        lengthShip = size;
                        startCreate = rowShip;
                        endCreate = columnShip;
                        return 3;
                    }
                }
            }
        }

        if(endCreate - size >= 0) {
            for (int i = startCreate; i <= startCreate; i++) {
                for (int j = endCreate; j < endCreate - size; j--) {
                    if (map[endCreate][startCreate].equals(SpaceStates.WATER)) {
                        maxSize++;
                    } else maxSize = 0;

                    if(maxSize == size) {
                        lengthShip = size;
                        startCreate = rowShip;
                        endCreate = columnShip;
                        return 4;
                    }
                }
            }
        }

        return 0;

    }


}
