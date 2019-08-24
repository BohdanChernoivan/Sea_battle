package com.spring.sea_battle.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Shoot {

    @Id
   // @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "player_id", unique = true)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID playerId;

    @NotNull
    private int row;

    @NotNull
    private int column;
}
