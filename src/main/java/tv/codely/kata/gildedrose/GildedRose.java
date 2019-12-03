package tv.codely.kata.gildedrose;

class GildedRose {
    Item[] items;

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item:items) {
            if (item.name.equals(this.AGED_BRIE)
            || item.name.equals(this.BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(this.BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11 && item.quality < 50) {
                                item.quality = item.quality + 1;
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                                item.quality = item.quality + 1;
                        }
                    }
                }
            }else{
                if (item.quality > 0 && !item.name.equals(this.SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
            if (!item.name.equals(this.SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }
            if (item.sellIn < 0) {
                 if(item.name.equals(this.AGED_BRIE) &&(item.quality < 50)) {
                    item.quality = item.quality + 1;
                }
                if(item.name.equals(this.BACKSTAGE_PASSES)) {
                    item.quality = item.quality - item.quality;
                }
                if (item.quality > 0) {
                    if (!item.name.equals(this.SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        }

    }   
}