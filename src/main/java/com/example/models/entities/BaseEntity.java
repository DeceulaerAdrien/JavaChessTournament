package com.example.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
public abstract class BaseEntity<T extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private T id;

    @Setter
    @Column(name = "creation_date")
    @CreatedDate
    private Date createdAt;

    @Setter
    @Column(name = "update_date")
    @LastModifiedDate
    private Date updateAt;
}