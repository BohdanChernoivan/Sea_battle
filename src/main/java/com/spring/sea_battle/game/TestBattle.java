package com.spring.sea_battle.game;

import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.data.CreatorMap;
import com.spring.sea_battle.game.logic.PlayerShoot;

public class TestBattle {

    public final static int SIZE_BOARD = 8;

    public static void main(String[] args) {

        CreatorMap creatorMap = new CreatorMap(8);

        CreatorShip creatorShip = new CreatorShip();
        creatorShip.createShip(creatorMap.getMap(),2, 6, 4);


        String view1 = creatorMap.getMap()[0][0].getState() + creatorMap.getMap()[0][1].getState() + creatorMap.getMap()[0][2].getState() + creatorMap.getMap()[0][3].getState() + creatorMap.getMap()[0][4].getState() + creatorMap.getMap()[0][5].getState() + creatorMap.getMap()[0][6].getState() + creatorMap.getMap()[0][7].getState();
        String view2 = creatorMap.getMap()[1][0].getState() + creatorMap.getMap()[1][1].getState() + creatorMap.getMap()[1][2].getState() + creatorMap.getMap()[1][3].getState() + creatorMap.getMap()[1][4].getState() + creatorMap.getMap()[1][5].getState() + creatorMap.getMap()[1][6].getState() + creatorMap.getMap()[1][7].getState();
        String view3 = creatorMap.getMap()[2][0].getState() + creatorMap.getMap()[2][1].getState() + creatorMap.getMap()[2][2].getState() + creatorMap.getMap()[2][3].getState() + creatorMap.getMap()[2][4].getState() + creatorMap.getMap()[2][5].getState() + creatorMap.getMap()[2][6].getState() + creatorMap.getMap()[2][7].getState();
        String view4 = creatorMap.getMap()[3][0].getState() + creatorMap.getMap()[3][1].getState() + creatorMap.getMap()[3][2].getState() + creatorMap.getMap()[3][3].getState() + creatorMap.getMap()[3][4].getState() + creatorMap.getMap()[3][5].getState() + creatorMap.getMap()[3][6].getState() + creatorMap.getMap()[3][7].getState();
        String view5 = creatorMap.getMap()[4][0].getState() + creatorMap.getMap()[4][1].getState() + creatorMap.getMap()[4][2].getState() + creatorMap.getMap()[4][3].getState() + creatorMap.getMap()[4][4].getState() + creatorMap.getMap()[4][5].getState() + creatorMap.getMap()[4][6].getState() + creatorMap.getMap()[4][7].getState();
        String view6 = creatorMap.getMap()[5][0].getState() + creatorMap.getMap()[5][1].getState() + creatorMap.getMap()[5][2].getState() + creatorMap.getMap()[5][3].getState() + creatorMap.getMap()[5][4].getState() + creatorMap.getMap()[5][5].getState() + creatorMap.getMap()[5][6].getState() + creatorMap.getMap()[5][7].getState();
        String view7 = creatorMap.getMap()[6][0].getState() + creatorMap.getMap()[6][1].getState() + creatorMap.getMap()[6][2].getState() + creatorMap.getMap()[6][3].getState() + creatorMap.getMap()[6][4].getState() + creatorMap.getMap()[6][5].getState() + creatorMap.getMap()[6][6].getState() + creatorMap.getMap()[6][7].getState();
        String view8 = creatorMap.getMap()[7][0].getState() + creatorMap.getMap()[7][1].getState() + creatorMap.getMap()[7][2].getState() + creatorMap.getMap()[7][3].getState() + creatorMap.getMap()[7][4].getState() + creatorMap.getMap()[7][5].getState() + creatorMap.getMap()[7][6].getState() + creatorMap.getMap()[7][7].getState();


        System.out.println(view1);
        System.out.println(view2);
        System.out.println(view3);
        System.out.println(view4);
        System.out.println(view5);
        System.out.println(view6);
        System.out.println(view7);
        System.out.println(view8);

        PlayerShoot playerShoot = new PlayerShoot();

        System.out.println(playerShoot.shootControl(creatorMap.getMap(), 2,6));


        String view11 = creatorMap.getMap()[0][0].getState() + creatorMap.getMap()[0][1].getState() + creatorMap.getMap()[0][2].getState() + creatorMap.getMap()[0][3].getState() + creatorMap.getMap()[0][4].getState() + creatorMap.getMap()[0][5].getState() + creatorMap.getMap()[0][6].getState() + creatorMap.getMap()[0][7].getState();
        String view21 = creatorMap.getMap()[1][0].getState() + creatorMap.getMap()[1][1].getState() + creatorMap.getMap()[1][2].getState() + creatorMap.getMap()[1][3].getState() + creatorMap.getMap()[1][4].getState() + creatorMap.getMap()[1][5].getState() + creatorMap.getMap()[1][6].getState() + creatorMap.getMap()[1][7].getState();
        String view31 = creatorMap.getMap()[2][0].getState() + creatorMap.getMap()[2][1].getState() + creatorMap.getMap()[2][2].getState() + creatorMap.getMap()[2][3].getState() + creatorMap.getMap()[2][4].getState() + creatorMap.getMap()[2][5].getState() + creatorMap.getMap()[2][6].getState() + creatorMap.getMap()[2][7].getState();
        String view41 = creatorMap.getMap()[3][0].getState() + creatorMap.getMap()[3][1].getState() + creatorMap.getMap()[3][2].getState() + creatorMap.getMap()[3][3].getState() + creatorMap.getMap()[3][4].getState() + creatorMap.getMap()[3][5].getState() + creatorMap.getMap()[3][6].getState() + creatorMap.getMap()[3][7].getState();
        String view51 = creatorMap.getMap()[4][0].getState() + creatorMap.getMap()[4][1].getState() + creatorMap.getMap()[4][2].getState() + creatorMap.getMap()[4][3].getState() + creatorMap.getMap()[4][4].getState() + creatorMap.getMap()[4][5].getState() + creatorMap.getMap()[4][6].getState() + creatorMap.getMap()[4][7].getState();
        String view61 = creatorMap.getMap()[5][0].getState() + creatorMap.getMap()[5][1].getState() + creatorMap.getMap()[5][2].getState() + creatorMap.getMap()[5][3].getState() + creatorMap.getMap()[5][4].getState() + creatorMap.getMap()[5][5].getState() + creatorMap.getMap()[5][6].getState() + creatorMap.getMap()[5][7].getState();
        String view71 = creatorMap.getMap()[6][0].getState() + creatorMap.getMap()[6][1].getState() + creatorMap.getMap()[6][2].getState() + creatorMap.getMap()[6][3].getState() + creatorMap.getMap()[6][4].getState() + creatorMap.getMap()[6][5].getState() + creatorMap.getMap()[6][6].getState() + creatorMap.getMap()[6][7].getState();
        String view81 = creatorMap.getMap()[7][0].getState() + creatorMap.getMap()[7][1].getState() + creatorMap.getMap()[7][2].getState() + creatorMap.getMap()[7][3].getState() + creatorMap.getMap()[7][4].getState() + creatorMap.getMap()[7][5].getState() + creatorMap.getMap()[7][6].getState() + creatorMap.getMap()[7][7].getState();


        System.out.println(view11);
        System.out.println(view21);
        System.out.println(view31);
        System.out.println(view41);
        System.out.println(view51);
        System.out.println(view61);
        System.out.println(view71);
        System.out.println(view81);

    }

}
