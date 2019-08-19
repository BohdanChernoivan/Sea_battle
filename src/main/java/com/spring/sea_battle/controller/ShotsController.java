package com.spring.sea_battle.controller;

import com.spring.sea_battle.entity.Shoot;
import com.spring.sea_battle.game.GamesRoom;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShotsController {

    private GamesRoom gamesRoom;

    public ShotsController(GamesRoom gamesRoom) {
        this.gamesRoom = gamesRoom;
    }

    @PostMapping("sea_battle/room/player2/attack")
    public String attack1(@RequestBody Shoot message){
        return gamesRoom.playerShoot1.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
    }

    @PostMapping("sea_battle/room/player1/attack")
    public String attack2(@RequestBody Shoot message){
        return gamesRoom.playerShoot2.shootControl(gamesRoom.creatorMap1.getMap(), message.getRow(), message.getColumn());
    }
}
