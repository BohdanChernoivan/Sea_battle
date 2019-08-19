package com.spring.sea_battle.game;

import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.data.CreatorMap;
import com.spring.sea_battle.game.logic.PlayerShoot;
import org.springframework.stereotype.Service;

@Service
public class GamesRoom {

    public final static int SIZE_MAP = 8;

    public CreatorMap creatorMap1;
    public CreatorShip creatorShip1;
    public PlayerShoot playerShoot1;

    public CreatorMap creatorMap2;
    public CreatorShip creatorShip2;
    public PlayerShoot playerShoot2;

}
