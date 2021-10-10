package com.cafebabe;

import com.cafebabe.entity.Color;

import java.util.Arrays;
import java.util.List;

public interface Colors {

    Color BLACK = new Color("Черный"), WHITE = new Color("Белый"), SILVER = new Color("Серебристый"), BIEGE = new Color("Бежевый"), TURQUOISE = new Color("Бирюзовый"), BURGUNDY = new Color("Бордовый"), BRONZE = new Color("Бронзовый"), SKY_BLUE = new Color("Голубой"), YELLOW = new Color("Желтый"), GREEN = new Color("Зеленый"), GOLDEN = new Color("золотистый"), CORAL = new Color("Коралловый"), BROWNISH = new Color("Коричневатый"), RED = new Color("Красный"), COPPER = new Color("Медный"), MINT = new Color("Мятный"), ORANGE = new Color("Оранжевый"), SANDY = new Color("Песочный"), PINK = new Color("Розовый"), LIGHT_BLUE = new Color("Светло-синий"), GREY = new Color("Серый"), BLUE = new Color("Синий"), LILAC = new Color("Сиреневый"), DARK_GREEN = new Color("Темно-зеленый"), DARK_BROWN = new Color("Темно-коричневый"), DARK_RED = new Color("Темно-красный"), DARK_GREY = new Color("Темно-серый"), DARK_BLUE = new Color("Темно-синий"), PURPLE = new Color("Фиолетовый");

    List<Color> ALL = Arrays.asList(BLACK, WHITE, SILVER, BIEGE, TURQUOISE, BURGUNDY, BRONZE, SKY_BLUE, YELLOW, GREEN, GOLDEN, CORAL, BROWNISH, RED, COPPER, MINT, ORANGE, SANDY, PINK, LIGHT_BLUE, GREY, BLUE, LILAC, DARK_GREEN, DARK_BROWN, DARK_RED, DARK_GREY, DARK_BLUE, PURPLE);
}
