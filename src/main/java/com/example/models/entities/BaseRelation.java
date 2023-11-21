package com.example.models.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseRelation <T extends Serializable> {

    @EmbeddedId
    @Getter
    private T id;
}
