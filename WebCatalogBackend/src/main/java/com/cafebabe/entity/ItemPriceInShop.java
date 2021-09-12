package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemPriceInShop extends BaseDataObject {

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false, nullable = false)
    protected ShopItem item;

    @Column(nullable = false)
    protected BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "shop_id", insertable = false, updatable = false, nullable = false)
    protected Shop shop;
}
