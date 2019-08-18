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
public class ShipDataController {

    private final ShipRepository shipRepository;
    private final SeaBattle seaBattle;

    @Autowired
    public ShipDataController(ShipRepository shipRepository, SeaBattle seaBattle) {
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
        seaBattle.creatorShip2.createShip(seaBattle.creatorMap2.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
        shipRepository.save(ship);
    }


    @GetMapping("sea_battle/room/player1/view_board")
    public BoardViewPlayer1 viewBoard1() {
        return new BoardViewPlayer1();
    }

    @GetMapping("sea_battle/room/player2/view_board")
    public BoardViewPlayer2 viewBoard2() {
        return new BoardViewPlayer2();
    }


    class BoardViewPlayer1 {
        public final String[] view = seaBattle.creatorMap1.getMapViewString();
    }

    class BoardViewPlayer2 {
        public final String[] view = seaBattle.creatorMap2.getMapViewString();
    }

}

