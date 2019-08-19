package com.spring.sea_battle.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Room {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "room_id", unique = true)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID roomId;

    @Column(name = "player1/player_id", unique = true)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID firstPlayerId;

    @Column(name = "player2/player_id", unique = true)
    @org.hibernate.annotations.Type(type="uuid-char")
    private UUID secondPlayerId;

    public Room(UUID roomId) {
        this.roomId = roomId;
    }


}
