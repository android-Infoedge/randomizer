package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Avatar;
import com.infoedge.jrandomizer.exceptions.RandomDataGeneratorException;
import com.infoedge.jrandomizer.providers.AvatarProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 28/7/16.
 */

public class AvatarGenerator extends GenerationRule<Avatar,String> {

    private AvatarProvider mProvider;

    private int width;
    private int height;
    private Avatar.Format format;

    public AvatarGenerator(Avatar annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        width = getAnnotation().width();
        height = getAnnotation().height();
        format = getAnnotation().format();
        handleInvalidDimension(annotation.width());
        handleInvalidDimension(annotation.height());
        mProvider = providerFactory().provider(AvatarProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] avatarUrls = mProvider.provide();
        int index = getRandom().nextInt(avatarUrls.length);
        String avatarUrl = avatarUrls[index];

        avatarUrl = avatarUrl.replaceAll("\\{width\\}", String.valueOf(width)).replaceAll("\\{height\\}", String.valueOf(height));
        String formatLabel = "";
        if (format == Avatar.Format.RANDOM) {
            formatLabel = randomFormat();
        } else {
            formatLabel = getAnnotation().format().getLabel();
        }
        return avatarUrl.replaceAll("\\{format\\}", formatLabel);
    }


    private String randomFormat() {
        int random = getRandom().nextInt(3);
        switch (random) {
            case 0:
                return Avatar.Format.PNG.getLabel();
            case 1:
                return Avatar.Format.BMP.getLabel();
            case 2:
                return Avatar.Format.JPG.getLabel();
        }
        return Avatar.Format.PNG.getLabel();
    }

    private void handleInvalidDimension(int dimension) {
        if (dimension < 0 || dimension > 2000) {
            throw new RandomDataGeneratorException("Size of dimension should be between 0 and 2000");
        }
    }

}
