package com.cafebabe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
}
