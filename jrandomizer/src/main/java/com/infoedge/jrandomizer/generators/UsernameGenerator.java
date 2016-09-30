package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Username;
import com.infoedge.jrandomizer.providers.ProviderFactory;
import com.infoedge.jrandomizer.providers.UsernameProvider;

/**
 * Created by gagandeep on 31/7/16.
 */

public class UsernameGenerator extends GenerationRule<Username,String> {

    private UsernameProvider mProvider;

    public UsernameGenerator(Username annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(UsernameProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] userNames = mProvider.provide();
        int randomIndex = getRandom().nextInt(userNames.length);
        return userNames[randomIndex];
    }
}
