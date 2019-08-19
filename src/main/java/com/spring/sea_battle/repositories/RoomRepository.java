package com.spring.sea_battle.repositories;

import com.spring.sea_battle.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

}
