package com.spring.sea_battle.game;

import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.data.CreatorMap;
import com.spring.sea_battle.game.logic.AutomaticPlaceShip;
import com.spring.sea_battle.game.logic.FindWinner;
import com.spring.sea_battle.game.logic.PlayerShoot;


public class TestBattle {

    public final static int SIZE_BOARD = 10;

    public static void main(String[] args) {

        CreatorMap creatorMap = new CreatorMap(SIZE_BOARD);

//        CreatorShip creatorShip = new CreatorShip();
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.HUGE_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.BIG_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.BIG_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.AVERAGE_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.AVERAGE_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.AVERAGE_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.SMALL_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.SMALL_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.SMALL_SHIP);
        AutomaticPlaceShip.createAutomaticShip(creatorMap.getMap(), CreatorShip.SMALL_SHIP);

        creatorMap.getMapSOUT();

        PlayerShoot playerShoot = new PlayerShoot();

        for (int i = 0; i < 1000; i++) {
            if(FindWinner.init(creatorMap.getMap())) {
                break;
            }
            System.out.println(i);
            System.out.println(playerShoot.shootControl(creatorMap.getMap(), AutomaticPlaceShip.rndLocationInBoard(),AutomaticPlaceShip.rndLocationInBoard()));
        }

        creatorMap.getMapSOUT();

    }

}
