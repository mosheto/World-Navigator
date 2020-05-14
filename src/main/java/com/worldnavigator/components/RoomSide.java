package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Wall.class, name = "wall"),
        @JsonSubTypes.Type(value = Door.class, name = "door"),
        @JsonSubTypes.Type(value = Mirror.class, name = "mirror"),
        @JsonSubTypes.Type(value = Painting.class, name = "painting"),
        @JsonSubTypes.Type(value = Seller.class, name = "seller")
})
public abstract class RoomSide {}
