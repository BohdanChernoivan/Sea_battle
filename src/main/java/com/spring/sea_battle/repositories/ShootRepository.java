package com.spring.sea_battle.repositories;

import com.spring.sea_battle.entity.Shoot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShootRepository extends JpaRepository<Shoot, UUID> {
}
