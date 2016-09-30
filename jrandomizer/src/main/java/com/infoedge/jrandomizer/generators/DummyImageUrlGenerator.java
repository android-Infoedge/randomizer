package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.DummyImageUrl;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 30/7/16.
 */

public class DummyImageUrlGenerator extends GenerationRule<DummyImageUrl,String> {

    private final String IMAGE_URL_TEMPLATE = "http://dummyimage.com/{width}x{height}/{background-color}.{format}?text={text}";

    private int width = 100;
    private int height = 100;
    private DummyImageUrl.Format format = DummyImageUrl.Format.RANDOM;

    public DummyImageUrlGenerator(DummyImageUrl annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        width = annotation.width();
        height = annotation.height();
        format = annotation.format();
    }

    @Override
    public String generate() {
        String randomColor = randomBackgroundColor();
        return IMAGE_URL_TEMPLATE.replace("{width}",String.valueOf(width)).replace("{height}",String.valueOf(height)).replace("{format}",imageFormat(format)).replace("{background-color}",randomColor).replace("{text}",randomColor);
    }

    private String randomBackgroundColor() {
        int randomCode = getRandom().nextInt(16777216);
        return Integer.toHexString(randomCode);
    }

    private String imageFormat(DummyImageUrl.Format format) {
        if (format == DummyImageUrl.Format.RANDOM) {
            int randomIndex = getRandom().nextInt(3);
            switch (randomIndex) {
                case 0:
                    return DummyImageUrl.Format.JPG.getLabel();
                case 1:
                    return DummyImageUrl.Format.PNG.getLabel();
                case 2:
                    return DummyImageUrl.Format.GIF.getLabel();
            }
        }
        return format.getLabel();
    }
}
