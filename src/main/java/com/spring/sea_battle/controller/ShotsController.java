package com.spring.sea_battle.controller;

import com.spring.sea_battle.entity.Shoot;
import com.spring.sea_battle.game.SeaBattle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShotsController {

    private SeaBattle seaBattle;

    public ShotsController(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
    }

    @PostMapping("sea_battle/room/player2/attack")
    public String attack1(@RequestBody Shoot message){
        return seaBattle.playerShoot1.shootControl(seaBattle.creatorMap1.getMap(), message.getRow(), message.getColumn());
    }

    @PostMapping("sea_battle/room/player1/attack")
    public String attack2(@RequestBody Shoot message){
        return seaBattle.playerShoot2.shootControl(seaBattle.creatorMap1.getMap(), message.getRow(), message.getColumn());
    }
}
