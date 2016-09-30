package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.URL;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.URLProvider;
import com.infoedge.jrandomizer.providers.URLProvider.URLData;

/**
 * Created by gagandeep on 31/7/16.
 */

public class URLGenerator extends GenerationRule<URL, String> {

    private URLProvider mProvider;

    public URLGenerator(URL annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(URLProvider.class, URLData.class);
    }

    @Override
    public String generate() {
        URLData urlData = mProvider.provide();
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(getAnnotation().protocol() ? urlData.protocols[getRandom().nextInt(urlData.protocols.length)] + "://" : "");
        urlBuilder.append(getAnnotation().host() ? urlData.hosts[getRandom().nextInt(urlData.hosts.length)] : "");
        urlBuilder.append(getAnnotation().host() && getAnnotation().port() ? ":" + Utils.randomIntWithMinMax(8000, 9000) : "");
        urlBuilder.append(getAnnotation().path() ? urlData.paths[getRandom().nextInt(urlData.paths.length)] : "");
        urlBuilder.append(getAnnotation().queryParams() && getAnnotation().maxQueryParams() > 0 ? randomQueryParams(urlData) : "");
        return urlBuilder.toString();
    }

    private String randomQueryParams(URLData urlData) {
        int count = Utils.randomIntWithMinMax(0, getAnnotation().maxQueryParams());
        if (count == 0) {
            return "";
        }
        StringBuilder queryParamsBuilder = new StringBuilder(getAnnotation().maxQueryParams() > 0 ? "?" : "");
        for (int i = 0; i < count; i++) {
            int randomIndex = getRandom().nextInt(urlData.queryParams.length);
            queryParamsBuilder.append(urlData.queryParams[randomIndex]);
            if (i < count - 1) {
                queryParamsBuilder.append("&");
            }
        }
        return queryParamsBuilder.toString();
    }
}
