package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Sentences;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.SentencesProvider;

/**
 * Created by gagandeep on 29/7/16.
 */

public class SentencesGenerator extends GenerationRule<Sentences,String> {

    private SentencesProvider mProvider;
    private int atleast;
    private int noMoreThan;

    public SentencesGenerator(Sentences annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(SentencesProvider.class, String[].class);
        atleast = annotation.atleast();
        noMoreThan = annotation.noMoreThan();

        if (noMoreThan < atleast) {
            noMoreThan = atleast;
        }
    }

    @Override
    public String generate() {
        String[] sentencesData = mProvider.provide();
        int diff = noMoreThan - atleast + 1;
        int random = getRandom().nextInt(diff) + atleast;
        StringBuilder sentences = new StringBuilder();
        for (int i = 0; i < random; i++) {
            int randomIndex = getRandom().nextInt(sentencesData.length);
            sentences.append(sentencesData[randomIndex]);
            if (i < random - 1) {
                sentences.append(" ");
            }
        }
        return sentences.toString();
    }
}
