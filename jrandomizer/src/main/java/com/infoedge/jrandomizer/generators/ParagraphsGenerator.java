package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Paragraphs;
import com.infoedge.jrandomizer.providers.ParagraphsProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 29/7/16.
 */

public class ParagraphsGenerator extends GenerationRule<Paragraphs, String> {

    private ParagraphsProvider mProvider;
    private int atleast;
    private int noMoreThan;

    public ParagraphsGenerator(Paragraphs annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(ParagraphsProvider.class, String[].class);
        atleast = annotation.atleast();
        noMoreThan = annotation.noMoreThan();

        if (noMoreThan < atleast) {
            noMoreThan = atleast;
        }
    }


    @Override
    public String generate() {
        String[] paragraphsData = mProvider.provide();
        int diff = noMoreThan - atleast + 1;
        int random = getRandom().nextInt(diff) + atleast;
        StringBuilder paragraphs = new StringBuilder();
        for (int i = 0; i < random; i++) {
            int randomIndex = getRandom().nextInt(paragraphsData.length);
            paragraphs.append(paragraphsData[randomIndex]);
            if (i < random - 1) {
                paragraphs.append("\n");
            }
        }
        return paragraphs.toString();
    }

}
