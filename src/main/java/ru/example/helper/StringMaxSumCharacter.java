package ru.example.helper;

import ru.example.model.CharWithPrice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringMaxSumCharacter {

    private static final int PRICE_A = 3;
    private static final int PRICE_B = 2;
    private static final int PRICE_C = 1;

    public List<String> findMaxSumCharacterStr(String...messageValue) {
        if(messageValue == null) {
            throw new NullPointerException();
        }
        List<CharWithPrice> stringWithPrices = new ArrayList<>();
        for (String str : messageValue) {
            int price = calculatePrice(str);
            stringWithPrices.add(getCharWithPrice(str, price));
        }

        Collections.sort(stringWithPrices, (a, b) -> {
            if (a.getPrice() == b.getPrice()) {
                return Integer.compare(a.getStr().length(), b.getStr().length());
            } else {
                return Integer.compare(b.getPrice(), a.getPrice());
            }
        });

        List<String> result = new ArrayList<>();
        int maxPrice = stringWithPrices.get(0).getPrice();
        int minLength = stringWithPrices.get(0).getStr().length();

        for (CharWithPrice sp : stringWithPrices) {
            if (sp.getPrice() == maxPrice && sp.getStr().length() <= minLength) {
                result.add(sp.getStr());
                minLength = sp.getStr().length();
            }
        }
        return result;
    }

    private CharWithPrice getCharWithPrice(String str, int price) {
        return CharWithPrice.Builder()
                .setStr(str)
                .setPrice(price)
                .build();
    }

    private int calculatePrice(String str) {
        int price = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case 'a':
                    price += PRICE_A;
                    break;
                case 'b':
                    price += PRICE_B;
                    break;
                case 'c':
                    price += PRICE_C;
                    break;
            }
        }
        return price;
    }
}
