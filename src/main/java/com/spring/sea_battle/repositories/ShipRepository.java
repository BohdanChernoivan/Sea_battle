package com.spring.sea_battle.repositories;

import com.spring.sea_battle.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipRepository extends JpaRepository<Ship, UUID> {
}
