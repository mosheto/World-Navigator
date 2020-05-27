package com.worldnavigator.maze.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.maze.RoomSideVisitor;

import java.util.Collections;
import java.util.Map;

public class Seller extends RoomSide {

    private final Map<String, Integer> prices;

    @JsonCreator
    public Seller(
            @JsonProperty("prices") Map<String, Integer> prices
    ) {
        this.prices = Collections.unmodifiableMap(prices);
    }

    public Integer getItemPrice(String name) {
        return prices.get(name);
    }

    @Override
    public void accept(RoomSideVisitor visitor) {
        visitor.execute(this);
    }

    @JsonGetter("prices")
    public Map<String, Integer> getPrices() {
        return prices;
    }

    @Override
    public String toString() {
        return "Seller";
    }
}
