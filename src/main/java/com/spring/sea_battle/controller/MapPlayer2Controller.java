package com.spring.sea_battle.controller;

import com.spring.sea_battle.controller.message.AutomaticCreateShip;
import com.spring.sea_battle.entity.Ship;
import com.spring.sea_battle.entity.Shoot;
import com.spring.sea_battle.game.GamesRoom;
import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.logic.AutomaticPlaceShip;
import com.spring.sea_battle.game.logic.FindWinner;
import com.spring.sea_battle.repositories.PlayerRepository;
import com.spring.sea_battle.repositories.ShipRepository;
import com.spring.sea_battle.repositories.ShootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sea_battle/room/player2")
public class MapPlayer2Controller {

    private final PlayerRepository playerRepository;
    private final ShootRepository shootRepository;
    private final ShipRepository shipRepository;
    private final GamesRoom gamesRoom;


    @Autowired
    public MapPlayer2Controller(PlayerRepository playerRepository, ShootRepository shootRepository, ShipRepository shipRepository, GamesRoom gamesRoom) {
        this.playerRepository = playerRepository;
        this.shootRepository = shootRepository;
        this.shipRepository = shipRepository;
        this.gamesRoom = gamesRoom;
    }

    @PostMapping("/attack")
    public String attack(@RequestBody Shoot message){
        if(!gamesRoom.movePlayer) {
            gamesRoom.movePlayer = true;
            if (FindWinner.init(gamesRoom.creatorMap1.getMap())) {
                gamesRoom.playerShoot2.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
                return "Winner player = " + playerRepository.getOne(message.getPlayerId()).getUserName();
            }
            return gamesRoom.playerShoot2.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
        } else
            return "move first player";
    }

    @PostMapping("/create_ship")
    public void create(@RequestBody Ship ship) {
        gamesRoom.creatorShip2.createShip(gamesRoom.creatorMap2.getMap(), ship.getRow(), ship.getColumn(), ship.getLength());
        shipRepository.save(ship);
    }


    @PostMapping("/create_ship/random")
    public void createRandomShip(@RequestBody AutomaticCreateShip createShip) {
        if (playerRepository.existsById(createShip.getPlayerId())) {
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.HUGE_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.BIG_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.BIG_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.AVERAGE_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.AVERAGE_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.AVERAGE_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.SMALL_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.SMALL_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.SMALL_SHIP);
            AutomaticPlaceShip.createAutomaticShip(gamesRoom.creatorMap2.getMap(), CreatorShip.SMALL_SHIP);
        } else {
            throw new IllegalArgumentException("unregistered player");
        }
    }

    @GetMapping("view_board")
    public PlayerViewMap viewBoard() {
        return new PlayerViewMap();
    }

    class PlayerViewMap {
        public final String[] view = gamesRoom.creatorMap2.getMapViewString();
    }
}
