package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Email;
import com.infoedge.jrandomizer.providers.EmailProvider;
import com.infoedge.jrandomizer.providers.EmailProvider.EmailRecord;
import com.infoedge.jrandomizer.providers.ProviderFactory;

/**
 * Created by gagandeep on 28/7/16.
 */

public class EmailGenerator extends GenerationRule<Email,String> {

    private EmailProvider mProvider;

    public EmailGenerator(Email annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mProvider = providerFactory().provider(EmailProvider.class, EmailRecord[].class);
    }

    @Override
    public String generate() {
        Email annotation = getAnnotation();
        if (annotation.in().length != 0) {
            String[] inEmailAddresses = annotation.in();
            int random = getRandom().nextInt(inEmailAddresses.length);
            return inEmailAddresses[random];
        } else {
            EmailRecord[] emailRecords = mProvider.provide();
            int random = getRandom().nextInt(emailRecords.length);
            EmailRecord emailRecord = emailRecords[random];
            String result = emailRecord.userName;
            if (annotation.domainName().length != 0) {
                random = getRandom().nextInt(annotation.domainName().length);
                String domainName = annotation.domainName()[random];
                result = result + "@" + domainName;
            } else {
                result = result + "@" + emailRecord.domainName;
            }
            return result;
        }
    }
}
