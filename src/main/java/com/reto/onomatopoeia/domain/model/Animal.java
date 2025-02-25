package com.reto.onomatopoeia.domain.model;

import com.reto.onomatopoeia.domain.enums.AnimalType;
import com.reto.onomatopoeia.domain.interfaces.ISound;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class Animal implements ISound {
    protected String name;
    protected AnimalType type;
    protected String onomatopoeia;

    public Animal(String name, AnimalType type, String onomatopoeia) {
        this.name = name;
        this.type = type;
        this.onomatopoeia = onomatopoeia;
    }

    public AnimalType getTipo() {
        return type;
    }

    @Override
    public String Onomatopoeia() {
        return "Los/as " + name + " hacen '" + onomatopoeia + "'";
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public String getOnomatopoeia() {
        return onomatopoeia;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    public void setOnomatopoeia(String onomatopoeia) {
        this.onomatopoeia = onomatopoeia;
    }
}