package com.infoedge.randomizer.example;

import com.infoedge.jrandomizer.annotations.CreditCardNumber;
import com.infoedge.jrandomizer.generators.GenerationRule;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 12/8/16.
 */
public class CustomCreditCardNumberGenerator extends GenerationRule<CreditCardNumber,String> {

    public CustomCreditCardNumberGenerator(CreditCardNumber annotation, ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    //Will be called automatically to generate random data from source
    @Override
    public String generate() {
        return CARD_NUMBERS[getRandom().nextInt(CARD_NUMBERS.length)];
    }

    //Provide your own data
    private final String[] CARD_NUMBERS = {"0111-0666-9888-7666","0777-9453-5672-7765"};
}
