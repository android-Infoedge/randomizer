package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.AppName;
import com.infoedge.jrandomizer.generators.AppBundleIdGenerator;
import com.infoedge.jrandomizer.generators.AppNameGenerator;
import com.infoedge.jrandomizer.providers.AppBundleIdProvider;
import com.infoedge.jrandomizer.providers.AppNameProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gagandeep on 1/8/16.
 */

public class AppNameGeneratorTest {

    @Mock
    private AppName mAnnotation;

    @Mock
    ProviderFactory mProviderFactory;

    @Mock
    AppNameProvider mProvider;

    private AppNameGenerator mGenerator;

    private final String[] APPNAMES = new String[]{
            "TrueCaller",
            "Gmail",
            "Pocket",
            "Phone"
    };
    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        when(mProviderFactory.provider(AppNameProvider.class, String[].class)).thenReturn(mProvider);
        mGenerator = new AppNameGenerator(mAnnotation, mProviderFactory);
        when(mProvider.provide()).thenReturn(APPNAMES);
    }

    @Test
    public void test_interaction() {
        verify(mProviderFactory).provider(AppNameProvider.class, String[].class);
        mGenerator.generate();
        verify(mProvider).provide();
    }

    @Test
    public void test_valid_app_name_generated() {
        String appName = mGenerator.generate();
        assertThat(appName.length(), Matchers.greaterThan(0));
    }

    @Test
    public void test_generated_app_name_in_defined_dataset() {
        String appName = mGenerator.generate();
        assertTrue(Arrays.asList(APPNAMES).contains(appName));
    }

}
