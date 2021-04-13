package com.gildedrose;

class GildedRose {
    Item[] items;
    
    public static final String AGED_BRIE_NAME = "Aged Brie";
    public static final String TAFKAL80ETC_NAME = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_RAGNAROS_NAME = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(AGED_BRIE_NAME)
                    && !items[i].getName().equals(TAFKAL80ETC_NAME)) {
                if (items[i].getQuality() > 0 && !items[i].getName().equals(SULFURAS_RAGNAROS_NAME)) {
                    items[i].setQuality(items[i].getQuality() - 1);
                }
            } else {
                if (items[i].getQuality() < 50) {
                    updateItemWithQualityGreaterThanFifty(items[i]);
                }
            }

            if (!items[i].getName().equals(SULFURAS_RAGNAROS_NAME)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                updateItemWithSellInLessThanZero(items[i]);
            }
        }
    }

    public void updateItemWithSellInLessThanZero(Item item) {
        if (!item.getName().equals(AGED_BRIE_NAME)) {
            if (!item.getName().equals(TAFKAL80ETC_NAME)) {
                if (item.getQuality() > 0 && !item.getName().equals(SULFURAS_RAGNAROS_NAME)) {
                    item.setQuality(item.getQuality() - 1);
                }
            } else {
                item.setQuality(0);
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }

    public void updateItemWithQualityGreaterThanFifty(Item item) {
        item.setQuality(item.getQuality() + 1);

        if (item.getName().equals(TAFKAL80ETC_NAME)) {
            if (item.getSellIn() < 11 && item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }

            if (item.getSellIn() < 6 && item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
    }
}