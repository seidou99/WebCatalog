package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Shop extends BaseDataObjectWithUniqueName {

    @OneToMany
    @JoinColumn(name = "shop_id")
    protected List<ItemPriceInShop> itemsWithPrice;

    public Shop(String name) {
        super(name);
    }

    @OneToOne
    protected ShopAdmin shopAdmin;

    @ElementCollection
    protected List<String> addresses;

    @ElementCollection
    protected List<String> contactInfoList;

    protected String shopDescription;
}
