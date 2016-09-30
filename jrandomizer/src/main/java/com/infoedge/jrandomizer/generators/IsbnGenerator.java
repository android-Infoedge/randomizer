package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Isbn;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class IsbnGenerator extends GenerationRule<Isbn, String> {


    public IsbnGenerator(Isbn annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
    }

    @Override
    public String generate() {
        String firstPart = randomPart(300);
        String secondPart = randomPart(300);
        String thirdPart = randomPart(300);

        String lastPart = charOrNumber();
        return String.format("%s%s%s-%s", firstPart, secondPart, thirdPart, lastPart);
    }

    private String randomPart(int range) {
        String random = String.valueOf(getRandom().nextInt(range));
        int targetLength = String.valueOf(range).length();
        int randomLength = random.length();
        if (randomLength < targetLength) {
            for (int i = randomLength; i < targetLength; i++) {
                random = "0" + random;
            }
        }
        return random;
    }

    private String charOrNumber() {
        int random = getRandom().nextInt(38);
        if (random < 10) {
            return String.valueOf(random);
        } else {
            random = random - 10;
            return getCharForNumber(random);
        }
    }

    private String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 64)) : "A";
    }
}
