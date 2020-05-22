package com.worldnavigator.components.items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Key.class, name = "key"),
        @JsonSubTypes.Type(value = Flashlight.class, name = "flashlight")
})
public abstract class Item {

    public abstract void accept(ItemVisitor visitor);
}
