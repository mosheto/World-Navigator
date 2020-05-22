package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Seller extends RoomSide {

    private Map<String, Integer> prices;

    @JsonCreator
    public Seller(
            @JsonProperty("prices") Map<String, Integer> prices
    ) {
        this.prices = prices;
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
