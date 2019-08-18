package com.spring.sea_battle.controller;


import com.spring.sea_battle.controller.message.ConnectToRoomMessage;
import com.spring.sea_battle.entity.Room;
import com.spring.sea_battle.repositories.PlayerRepository;
import com.spring.sea_battle.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class RoomConnectController {

    private final RoomRepository roomRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public RoomConnectController(RoomRepository roomRepository, PlayerRepository playerRepository) {
        this.roomRepository = roomRepository;
        this.playerRepository = playerRepository;
    }

    @PostMapping("sea_battle/room/connect")
    public void connect(@RequestBody ConnectToRoomMessage connect) {
        if(Objects.isNull(connect.getRoomId()) ||
                Objects.isNull(connect.getFirstPlayerId())) {
            throw new IllegalArgumentException("userId and roomId must be not null");
        }

        if (!playerRepository.existsById(connect.getFirstPlayerId())) {
            throw new IllegalArgumentException("unregistered first player");
        }

        if (!playerRepository.existsById(connect.getSecondPlayerId())) {
            throw new IllegalArgumentException("unregistered second player");
        }

        if(!roomRepository.existsById(connect.getRoomId())) {
            Room room = new Room(connect.getRoomId());
            roomRepository.save(room);
        }

    }
}

// c31a8e39-f9e5-444e-989f-57220a4803c8
// 5e1b5aa6-a5ff-4ec9-bf10-2cd1eace87a5
