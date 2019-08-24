package com.spring.sea_battle.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "creatorShip1")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ship {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "player_id")
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID playerId;

    @Column(name = "row")
    @NotNull
    private int row;

    @Column(name = "column")
    @NotNull
    private int column;

    @Column(name = "length")
    @NotNull
    private int length;

}
