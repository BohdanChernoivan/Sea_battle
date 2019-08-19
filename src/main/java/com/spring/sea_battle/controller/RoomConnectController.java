package com.spring.sea_battle.controller;


import com.spring.sea_battle.controller.message.ConnectToRoomMessage;
import com.spring.sea_battle.entity.Room;
import com.spring.sea_battle.game.GamesRoom;
import com.spring.sea_battle.game.data.CreatorMap;
import com.spring.sea_battle.game.data.CreatorShip;
import com.spring.sea_battle.game.logic.PlayerShoot;
import com.spring.sea_battle.repositories.PlayerRepository;
import com.spring.sea_battle.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

import static com.spring.sea_battle.game.GamesRoom.SIZE_MAP;

@RestController
public class RoomConnectController {

    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;
    private final GamesRoom gamesRoom;


    @Autowired
    public RoomConnectController(RoomRepository roomRepository, PlayerRepository playerRepository, GamesRoom gamesRoom) {
        this.roomRepository = roomRepository;
        this.playerRepository = playerRepository;
        this.gamesRoom = gamesRoom;
    }


    @PostMapping("sea_battle/room/connect")
    public void connect(@RequestBody ConnectToRoomMessage connect) {
        if(Objects.isNull(connect.getRoomId()) ||
                Objects.isNull(connect.getPlayerId())) {
            throw new IllegalArgumentException("userId and roomId must be not null");
        }

        if (!playerRepository.existsById(connect.getPlayerId())) {
            throw new IllegalArgumentException("unregistered player");
        }

        if(!roomRepository.existsById(connect.getRoomId())) {
            Room room = new Room(connect.getRoomId());
            room.setFirstPlayerId(connect.getPlayerId());
            roomRepository.save(room);
        }


        gamesRoom.creatorMap1 = new CreatorMap(SIZE_MAP);
        gamesRoom.creatorShip1 = new CreatorShip();
        gamesRoom.playerShoot1 = new PlayerShoot();

    }

    @PostMapping("sea_battle/room/join")
    public void joinRoom(@RequestBody ConnectToRoomMessage connect) {
        if(Objects.isNull(connect.getRoomId()) ||
                Objects.isNull(connect.getPlayerId())) {
            throw new IllegalArgumentException("userId and roomId must be not null");
        }

        if (!playerRepository.existsById(connect.getPlayerId())) {
            throw new IllegalArgumentException("unregistered player");
        }

        if (!roomRepository.existsById(connect.getRoomId())) {
            throw new IllegalArgumentException("unregistered room");
        }


        Room room1 = roomRepository.getOne(connect.getRoomId());
        room1.setSecondPlayerId(connect.getPlayerId());
        roomRepository.save(room1);


        gamesRoom.creatorMap2 = new CreatorMap(SIZE_MAP);
        gamesRoom.creatorShip2 = new CreatorShip();
        gamesRoom.playerShoot2 = new PlayerShoot();

    }

}

// c31a8e39-f9e5-444e-989f-57220a4803c8
// 5e1b5aa6-a5ff-4ec9-bf10-2cd1eace87a5
