package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.AppBundleID;
import com.infoedge.jrandomizer.generators.AppBundleIdGenerator;
import com.infoedge.jrandomizer.providers.AppBundleIdProvider;
import com.infoedge.jrandomizer.providers.FromJsonProvider;
import com.infoedge.jrandomizer.providers.Provider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by gagandeep on 1/8/16.
 */

public class AppBundleGeneratorTest {

    @Mock
    private AppBundleID mAppBundleID;

    @Mock
    ProviderFactory mProviderFactory;

    @Mock
    AppBundleIdProvider mProvider;

    @Mock
    AppBundleIdProvider.AppBundleIdData mBundleData;

    private AppBundleIdGenerator mGenerator;

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        when(mProviderFactory.provider(AppBundleIdProvider.class, AppBundleIdProvider.AppBundleIdData.class)).thenReturn(mProvider);
        mGenerator = new AppBundleIdGenerator(mAppBundleID,mProviderFactory);
        when(mProvider.provide()).thenReturn(mBundleData);
    }

    @Test
    public void test_verify_interaction() {
        verify(mProviderFactory).provider(AppBundleIdProvider.class, AppBundleIdProvider.AppBundleIdData.class);
        mBundleData.tlds = new String[]{"com"};
        mBundleData.companyNames = new String[]{"google"};
        mBundleData.productNames = new String[]{"abc"};
        mGenerator.generate();
        verify(mProvider).provide();
    }

    @Test
    public void test_generates_valid_bundle_id() {
        mBundleData.tlds = new String[]{"com"};
        mBundleData.companyNames = new String[]{"google"};
        mBundleData.productNames = new String[]{"abc"};
        String actual = mGenerator.generate();
        String expected = "com.google.abc";
        assertThat(expected, CoreMatchers.equalTo(actual));
    }

}
