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
@Inheritance(strategy = InheritanceType.JOINED)
public class ShopItem extends BaseDataObject {

    @OneToMany
    @JoinColumn(name = "item_id")
    protected List<ItemPriceInShop> pricesInShops;


}
