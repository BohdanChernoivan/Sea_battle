package com.spring.sea_battle.controller.message;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class AutomaticCreateShip {

    @NotNull
    private UUID playerId;

}
