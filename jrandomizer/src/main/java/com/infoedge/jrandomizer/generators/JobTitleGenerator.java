package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.JobTitle;
import com.infoedge.jrandomizer.providers.JobTitleProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class JobTitleGenerator extends GenerationRule<JobTitle,String> {
    private JobTitleProvider mProvider;

    public JobTitleGenerator(JobTitle annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(JobTitleProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] jobTitles = mProvider.provide();
        int randomIndex = getRandom().nextInt(jobTitles.length);
        return jobTitles[randomIndex];
    }

}
