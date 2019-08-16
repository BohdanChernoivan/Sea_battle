package com.spring.sea_battle.controller;

import com.spring.sea_battle.entity.Ship;
import com.spring.sea_battle.game.SeaBattle;
import com.spring.sea_battle.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShipCreationController {

    private final ShipRepository shipRepository;
    private final SeaBattle seaBattle;

    @Autowired
    public ShipCreationController(ShipRepository shipRepository, SeaBattle seaBattle) {
        this.shipRepository = shipRepository;
        this.seaBattle = seaBattle;
    }


    @PostMapping("sea_battle/room/player1/create_ship")
    public void create1(@RequestBody Ship ship){
        seaBattle.creatorShip1.createShip(seaBattle.creatorMap1.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
        shipRepository.save(ship);
    }

    @PostMapping("sea_battle/room/player2/create_ship")
    public void create2(@RequestBody Ship ship) {
        seaBattle.creatorShip2.createShip(seaBattle.creatorMap1.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
        shipRepository.save(ship);
    }



    @GetMapping("sea_battle/room/player1/view_board")
    public BoardViewPlayer1 viewBoard1() {
        return new BoardViewPlayer1();
    }

    @GetMapping("sea_battle/room/player2/view_board")
    public BoardViewPlayer1 viewBoard2() {
        return new BoardViewPlayer1();
    }


    class BoardViewPlayer1 {

        public final String view1 = seaBattle.creatorMap1.getMap()[0][0].getState() + seaBattle.creatorMap1.getMap()[0][1].getState() + seaBattle.creatorMap1.getMap()[0][2].getState() + seaBattle.creatorMap1.getMap()[0][3].getState() + seaBattle.creatorMap1.getMap()[0][4].getState() + seaBattle.creatorMap1.getMap()[0][5].getState() + seaBattle.creatorMap1.getMap()[0][6].getState() + seaBattle.creatorMap1.getMap()[0][7].getState();
        public final String view2 = seaBattle.creatorMap1.getMap()[1][0].getState() + seaBattle.creatorMap1.getMap()[1][1].getState() + seaBattle.creatorMap1.getMap()[1][2].getState() + seaBattle.creatorMap1.getMap()[1][3].getState() + seaBattle.creatorMap1.getMap()[1][4].getState() + seaBattle.creatorMap1.getMap()[1][5].getState() + seaBattle.creatorMap1.getMap()[1][6].getState() + seaBattle.creatorMap1.getMap()[1][7].getState();
        public final String view3 = seaBattle.creatorMap1.getMap()[2][0].getState() + seaBattle.creatorMap1.getMap()[2][1].getState() + seaBattle.creatorMap1.getMap()[2][2].getState() + seaBattle.creatorMap1.getMap()[2][3].getState() + seaBattle.creatorMap1.getMap()[2][4].getState() + seaBattle.creatorMap1.getMap()[2][5].getState() + seaBattle.creatorMap1.getMap()[2][6].getState() + seaBattle.creatorMap1.getMap()[2][7].getState();
        public final String view4 = seaBattle.creatorMap1.getMap()[3][0].getState() + seaBattle.creatorMap1.getMap()[3][1].getState() + seaBattle.creatorMap1.getMap()[3][2].getState() + seaBattle.creatorMap1.getMap()[3][3].getState() + seaBattle.creatorMap1.getMap()[3][4].getState() + seaBattle.creatorMap1.getMap()[3][5].getState() + seaBattle.creatorMap1.getMap()[3][6].getState() + seaBattle.creatorMap1.getMap()[3][7].getState();
        public final String view5 = seaBattle.creatorMap1.getMap()[4][0].getState() + seaBattle.creatorMap1.getMap()[4][1].getState() + seaBattle.creatorMap1.getMap()[4][2].getState() + seaBattle.creatorMap1.getMap()[4][3].getState() + seaBattle.creatorMap1.getMap()[4][4].getState() + seaBattle.creatorMap1.getMap()[4][5].getState() + seaBattle.creatorMap1.getMap()[4][6].getState() + seaBattle.creatorMap1.getMap()[4][7].getState();
        public final String view6 = seaBattle.creatorMap1.getMap()[5][0].getState() + seaBattle.creatorMap1.getMap()[5][1].getState() + seaBattle.creatorMap1.getMap()[5][2].getState() + seaBattle.creatorMap1.getMap()[5][3].getState() + seaBattle.creatorMap1.getMap()[5][4].getState() + seaBattle.creatorMap1.getMap()[5][5].getState() + seaBattle.creatorMap1.getMap()[5][6].getState() + seaBattle.creatorMap1.getMap()[5][7].getState();
        public final String view7 = seaBattle.creatorMap1.getMap()[6][0].getState() + seaBattle.creatorMap1.getMap()[6][1].getState() + seaBattle.creatorMap1.getMap()[6][2].getState() + seaBattle.creatorMap1.getMap()[6][3].getState() + seaBattle.creatorMap1.getMap()[6][4].getState() + seaBattle.creatorMap1.getMap()[6][5].getState() + seaBattle.creatorMap1.getMap()[6][6].getState() + seaBattle.creatorMap1.getMap()[6][7].getState();
        public final String view8 = seaBattle.creatorMap1.getMap()[7][0].getState() + seaBattle.creatorMap1.getMap()[7][1].getState() + seaBattle.creatorMap1.getMap()[7][2].getState() + seaBattle.creatorMap1.getMap()[7][3].getState() + seaBattle.creatorMap1.getMap()[7][4].getState() + seaBattle.creatorMap1.getMap()[7][5].getState() + seaBattle.creatorMap1.getMap()[7][6].getState() + seaBattle.creatorMap1.getMap()[7][7].getState();

    }

    class BoardViewPlayer2 {

        public final String view1 = seaBattle.creatorMap2.getMap()[0][0].getState() + seaBattle.creatorMap2.getMap()[0][1].getState() + seaBattle.creatorMap2.getMap()[0][2].getState() + seaBattle.creatorMap2.getMap()[0][3].getState() + seaBattle.creatorMap2.getMap()[0][4].getState() + seaBattle.creatorMap2.getMap()[0][5].getState() + seaBattle.creatorMap2.getMap()[0][6].getState() + seaBattle.creatorMap2.getMap()[0][7].getState();
        public final String view2 = seaBattle.creatorMap2.getMap()[1][0].getState() + seaBattle.creatorMap2.getMap()[1][1].getState() + seaBattle.creatorMap2.getMap()[1][2].getState() + seaBattle.creatorMap2.getMap()[1][3].getState() + seaBattle.creatorMap2.getMap()[1][4].getState() + seaBattle.creatorMap2.getMap()[1][5].getState() + seaBattle.creatorMap2.getMap()[1][6].getState() + seaBattle.creatorMap2.getMap()[1][7].getState();
        public final String view3 = seaBattle.creatorMap2.getMap()[2][0].getState() + seaBattle.creatorMap2.getMap()[2][1].getState() + seaBattle.creatorMap2.getMap()[2][2].getState() + seaBattle.creatorMap2.getMap()[2][3].getState() + seaBattle.creatorMap2.getMap()[2][4].getState() + seaBattle.creatorMap2.getMap()[2][5].getState() + seaBattle.creatorMap2.getMap()[2][6].getState() + seaBattle.creatorMap2.getMap()[2][7].getState();
        public final String view4 = seaBattle.creatorMap2.getMap()[3][0].getState() + seaBattle.creatorMap2.getMap()[3][1].getState() + seaBattle.creatorMap2.getMap()[3][2].getState() + seaBattle.creatorMap2.getMap()[3][3].getState() + seaBattle.creatorMap2.getMap()[3][4].getState() + seaBattle.creatorMap2.getMap()[3][5].getState() + seaBattle.creatorMap2.getMap()[3][6].getState() + seaBattle.creatorMap2.getMap()[3][7].getState();
        public final String view5 = seaBattle.creatorMap2.getMap()[4][0].getState() + seaBattle.creatorMap2.getMap()[4][1].getState() + seaBattle.creatorMap2.getMap()[4][2].getState() + seaBattle.creatorMap2.getMap()[4][3].getState() + seaBattle.creatorMap2.getMap()[4][4].getState() + seaBattle.creatorMap2.getMap()[4][5].getState() + seaBattle.creatorMap2.getMap()[4][6].getState() + seaBattle.creatorMap2.getMap()[4][7].getState();
        public final String view6 = seaBattle.creatorMap2.getMap()[5][0].getState() + seaBattle.creatorMap2.getMap()[5][1].getState() + seaBattle.creatorMap2.getMap()[5][2].getState() + seaBattle.creatorMap2.getMap()[5][3].getState() + seaBattle.creatorMap2.getMap()[5][4].getState() + seaBattle.creatorMap2.getMap()[5][5].getState() + seaBattle.creatorMap2.getMap()[5][6].getState() + seaBattle.creatorMap2.getMap()[5][7].getState();
        public final String view7 = seaBattle.creatorMap2.getMap()[6][0].getState() + seaBattle.creatorMap2.getMap()[6][1].getState() + seaBattle.creatorMap2.getMap()[6][2].getState() + seaBattle.creatorMap2.getMap()[6][3].getState() + seaBattle.creatorMap2.getMap()[6][4].getState() + seaBattle.creatorMap2.getMap()[6][5].getState() + seaBattle.creatorMap2.getMap()[6][6].getState() + seaBattle.creatorMap2.getMap()[6][7].getState();
        public final String view8 = seaBattle.creatorMap2.getMap()[7][0].getState() + seaBattle.creatorMap2.getMap()[7][1].getState() + seaBattle.creatorMap2.getMap()[7][2].getState() + seaBattle.creatorMap2.getMap()[7][3].getState() + seaBattle.creatorMap2.getMap()[7][4].getState() + seaBattle.creatorMap2.getMap()[7][5].getState() + seaBattle.creatorMap2.getMap()[7][6].getState() + seaBattle.creatorMap2.getMap()[7][7].getState();

    }

}

