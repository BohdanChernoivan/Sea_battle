package com.spring.sea_battle.controller.message;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AutomaticCreateShip {

    @NotNull
    private int size;

}
