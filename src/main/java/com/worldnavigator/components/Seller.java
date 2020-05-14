package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.components.items.Item;

import java.util.Map;

public class Seller extends RoomSide {
    private Map<String, Item> items;
    private Map<String, Integer> prices;

    @JsonCreator
    public Seller(
            @JsonProperty("items") Map<String, Item> items,
            @JsonProperty("prices") Map<String, Integer> prices
    ) {
        this.items = items;
        this.prices = prices;
    }

    public Item getItem(String name) {
        return items.get(name);
    }

    public Integer getItemPrice(String name) {
        return prices.get(name);
    }

    @JsonGetter("items")
    public Map<String, Item> getItems() {
        return items;
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
