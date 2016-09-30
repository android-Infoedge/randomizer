package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Money;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by gagandeep on 31/7/16.
 */

public class MoneyGenerator extends GenerationRule<Money,String> {

    private Money.In moneyIn;
    private double min;
    private double max;

    public MoneyGenerator(Money annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        moneyIn = annotation.in();
        min = annotation.min();
        max = annotation.max();
    }

    @Override
    public String generate() {
        String randomMoney = new BigDecimal(min + (Math.random() * (max - min + 1))).setScale(2, RoundingMode.HALF_UP).toString();
//        randomMoney = randomMoney.length() <= 4 ? randomMoney : randomMoney.substring(0, 4);
        String currencySymbol = currencySymbol(moneyIn);
        return String.format("%s%s", currencySymbol, randomMoney);
    }

    private String currencySymbol(Money.In in) {
        if (in == Money.In.RANDOM) {
            int randomIndex = getRandom().nextInt(Money.In.values().length - 1);
            in = Money.In.values()[randomIndex];
        }
        return in.getCurrencySymbol();
    }
}
