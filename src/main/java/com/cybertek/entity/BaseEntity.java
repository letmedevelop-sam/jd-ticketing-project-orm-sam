package com.cybertek.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

//Some data we want to keep in DB but no need to see on UI
// Persist    : Say something in DataBase

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime insertDateTime;
    private Long insertUserId;
    private LocalDateTime lastUpdateDateTime;
    private Long lastUpdateUserId;

    private Boolean isDeleted=false;

    @PrePersist     //This method will run before PERSIST each time (before object is saved in DB)
    private void onPrePersist(){

        this.insertDateTime=LocalDateTime.now();
        this.lastUpdateDateTime=LocalDateTime.now();
        this.insertUserId=1L;       //For now they are hard-coded. When we start Security they will be dynamic
        this.lastUpdateUserId=1L;   //For now they are hard-coded. When we start Security they will be dynamic

    }

    @PreUpdate
    private void onPreUpdate(){
        this.lastUpdateDateTime=LocalDateTime.now();
        this.insertUserId=1L;       //For now they are hard-coded. When we start Security they will be dynamic
    }
}
