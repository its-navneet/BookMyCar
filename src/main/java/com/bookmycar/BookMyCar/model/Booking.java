package com.bookmycar.BookMyCar.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("booking")
@Getter
@Setter
public class Booking {
    @Id
    String id;

    private String userId;
    private String ownerId;
    private String carId;
    private int amount;
    private LocalDateTime createdAt;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int duration;

    public Booking (int amount, LocalDateTime startTime, int duration) {
        this.amount = amount;
        this.startTime = startTime;
        this.duration = duration;
    }
}
