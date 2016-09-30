package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Words;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.WordsProvider;

/**
 * Created by gagandeep on 30/7/16.
 */

public class WordsGenerator extends GenerationRule<Words,String> {

    private WordsProvider mProvider;
    private int atleast;
    private int noMoreThan;

    public WordsGenerator(Words annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(WordsProvider.class, String[].class);
        atleast = annotation.atleast();
        noMoreThan = annotation.noMoreThan();

        if (noMoreThan < atleast) {
            noMoreThan = atleast;
        }
    }

    @Override
    public String generate() {
        int random = (int) (atleast + (Math.random() * (noMoreThan - atleast + 1)));
        return chooseWords(random);
    }

    private String chooseWords(int length) {
        String[] wordsData = mProvider.provide();
        int random = 0;
        int wordsRemaining = length;
        StringBuilder words = new StringBuilder();
        while (wordsRemaining > 0) {
            random = getRandom().nextInt(wordsData.length);
            String line = wordsData[random];
            String[] lineWords = line.split(" ");
            if (wordsRemaining < lineWords.length) {
                for (int i = 0; i < wordsRemaining; i++) {
                    words.append(lineWords[i] + " ");
                }
                wordsRemaining = 0;
            } else {
                words.append(line + " ");
                wordsRemaining = wordsRemaining - lineWords.length;
            }
        }
        return words.toString().trim();
    }
}
