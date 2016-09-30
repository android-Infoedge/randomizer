package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.LinkedInSkill;
import com.infoedge.jrandomizer.providers.LinkedInSkillProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 31/7/16.
 */

public class LinkedInSkillGenerator extends GenerationRule<LinkedInSkill,String> {
    private LinkedInSkillProvider mProvider;

    public LinkedInSkillGenerator(LinkedInSkill annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(LinkedInSkillProvider.class, String[].class);
    }

    @Override
    public String generate() {
        String[] skills = mProvider.provide();
        int randomIndex = getRandom().nextInt(skills.length);
        return skills[randomIndex];
    }

}
