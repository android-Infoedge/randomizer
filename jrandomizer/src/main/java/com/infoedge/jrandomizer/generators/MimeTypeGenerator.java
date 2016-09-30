package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.MimeType;
import com.infoedge.jrandomizer.providers.MimeTypeProvider;
import com.infoedge.jrandomizer.providers.MimeTypeProvider.MimeTypeData;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class MimeTypeGenerator extends GenerationRule<MimeType,String> {

    private MimeTypeProvider mProvider;
    private MimeType.Type mimeType;

    public MimeTypeGenerator(MimeType annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mimeType = annotation.type();
        mProvider = providerFactory().provider(MimeTypeProvider.class, MimeTypeData.class);
    }

    @Override
    public String generate() {
        MimeTypeData mimeTypeData = mProvider.provide();
        return getRandomMimeType(mimeTypeData, mimeType);
    }

    private String getRandomMimeType(MimeTypeData mimeTypeData, MimeType.Type type) {
        String[] data = mimeTypeData.all;
        switch (type) {
            case ALL:
                data = mimeTypeData.all;
                break;
            case COMMON:
                data = mimeTypeData.common;
                break;
            case CODE:
                data = mimeTypeData.code;
                break;
            case DOCUMENT:
                data = mimeTypeData.document;
                break;
            case IMAGE:
                data = mimeTypeData.image;
                break;
            case MEDIA:
                data = mimeTypeData.media;
                break;
            case TEXT:
                data = mimeTypeData.text;
                break;
        }
        int randomIndex = getRandom().nextInt(data.length);
        return data[randomIndex];
    }
}
