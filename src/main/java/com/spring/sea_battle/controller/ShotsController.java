package com.spring.sea_battle.controller;

import com.spring.sea_battle.entity.Shoot;
import com.spring.sea_battle.game.GamesRoom;
import com.spring.sea_battle.game.logic.FindWinner;
import com.spring.sea_battle.repositories.PlayerRepository;
import com.spring.sea_battle.repositories.ShootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ShotsController {

    private final PlayerRepository playerRepository;
    private final ShootRepository shootRepository;
    private final GamesRoom gamesRoom;
    private boolean movePlayer = false;


    @Autowired
    public ShotsController(PlayerRepository playerRepository, ShootRepository shootRepository, GamesRoom gamesRoom) {
        this.playerRepository = playerRepository;
        this.shootRepository = shootRepository;
        this.gamesRoom = gamesRoom;
    }

    @PostMapping("sea_battle/room/player2/attack")
    public String attack1(@RequestBody Shoot message){
        if(!movePlayer) {
            movePlayer = true;
            if (FindWinner.init(gamesRoom.creatorMap1.getMap())) {
                gamesRoom.playerShoot2.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
                return "Winner player = " + playerRepository.getOne(message.getPlayerId()).getUserName();
            }
            return gamesRoom.playerShoot2.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
        } else
        return "move first player";
    }

    @PostMapping("sea_battle/room/player1/attack")
    public String attack2(@RequestBody Shoot message){
        if(movePlayer) {
            movePlayer = false;
            if (FindWinner.init(gamesRoom.creatorMap2.getMap())) {
                gamesRoom.playerShoot1.shootControl(gamesRoom.creatorMap2.getMap(), message.getRow(), message.getColumn());
                return "Winner player = " + playerRepository.getOne(message.getPlayerId()).getUserName();
            }
            return gamesRoom.playerShoot1.shootControl(gamesRoom.creatorMap2.getMap(), message.getRow(), message.getColumn());
        } else
            return "move second player";
    }

}
