package com.spring.sea_battle.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.transaction.Transactional;

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
@Transactional
public class Player {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "player_id", unique = true)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID playerId;



    @Column(name = "user_name")
    @NotNull
    @org.hibernate.annotations.Type(type="string")
    private String userName;

}
