package com.spring.sea_battle.game;

import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.data.CreatorMap;
import com.spring.sea_battle.game.logic.PlayerShoot;
import org.springframework.stereotype.Service;

@Service
public class SeaBattle {

    private final static int SIZE_MAP = 8;

    public CreatorMap creatorMap1 = new CreatorMap(SIZE_MAP);
    public CreatorMap creatorMap2 = new CreatorMap(SIZE_MAP);

    public CreatorShip creatorShip1 = new CreatorShip();
    public CreatorShip creatorShip2 = new CreatorShip();

    public PlayerShoot playerShoot1 = new PlayerShoot();
    public PlayerShoot playerShoot2 = new PlayerShoot();

}
