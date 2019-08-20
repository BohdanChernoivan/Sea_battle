package com.spring.sea_battle.controller;

import com.spring.sea_battle.controller.message.AutomaticCreateShip;
import com.spring.sea_battle.entity.Ship;
import com.spring.sea_battle.game.GamesRoom;
import com.spring.sea_battle.game.logic.AutomaticPlaceShip;
import com.spring.sea_battle.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShipDataController {

    private final ShipRepository shipRepository;
    private final GamesRoom gamesRoom;

    @Autowired
    public ShipDataController(ShipRepository shipRepository, GamesRoom gamesRoom) {
        this.shipRepository = shipRepository;
        this.gamesRoom = gamesRoom;
    }


    @PostMapping("sea_battle/room/player1/create_ship")
    public void create1(@RequestBody Ship ship){
        gamesRoom.creatorShip1.createShip(gamesRoom.creatorMap1.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
        shipRepository.save(ship);
    }

    @PostMapping("sea_battle/room/player2/create_ship")
    public void create2(@RequestBody Ship ship) {
        gamesRoom.creatorShip2.createShip(gamesRoom.creatorMap2.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
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


    @PostMapping("sea_battle/room/player1/random_create_ship")
    public void create1_random(@RequestBody AutomaticCreateShip createShip) {
        AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap1.getMap(), createShip.getSize());
    }

    @PostMapping("sea_battle/room/player2/random_create_ship")
    public void create2_random(@RequestBody AutomaticCreateShip createShip) {
        AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), createShip.getSize());
    }


    class BoardViewPlayer1 {
        public final String[] view = gamesRoom.creatorMap1.getMapViewString();
    }

    class BoardViewPlayer2 {
        public final String[] view = gamesRoom.creatorMap2.getMapViewString();
    }


}

