package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Encrypt;
import com.infoedge.jrandomizer.providers.EncryptProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class EncryptGenerator extends GenerationRule<Encrypt, String> {

    private EncryptProvider mProvider;
    private int mLength;

    public EncryptGenerator(Encrypt annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(EncryptProvider.class, String[].class);
        mLength = annotation.length();
        if (mLength < 0) {
            mLength = 0;
        }
    }

    @Override
    public String generate() {
        String randomizedText = randomizeEncryptedText();
        int textLength = randomizedText.length();
        int requiredLength = mLength;
        if (requiredLength == 0) {
            return "";
        }
        StringBuilder textBuilder = new StringBuilder();
        int loops = requiredLength / textLength;
        int leftOverLength = requiredLength % textLength;
        for (int i = 0; i < loops; i++) {
            textBuilder.append(randomizedText.substring(0, textLength - 1));
        }
        textBuilder.append(randomizedText.substring(0, leftOverLength));
        return textBuilder.toString();
    }

    private String randomizeEncryptedText() {
        String[] encryptedLines = mProvider.provide();
        StringBuilder randomized = new StringBuilder();
        int length = encryptedLines.length;
        for (int i = 0; i < length; i++) {
            int random = getRandom().nextInt(length);
            randomized.append(encryptedLines[random]);
        }
        return randomized.toString();
    }


}
