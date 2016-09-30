package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.AppVersion;
import com.infoedge.jrandomizer.generators.AppVersionGenerator;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * Created by gagandeep on 3/8/16.
 */
@RunWith(value = Parameterized.class)
public class AppVersionGeneratorTest {

    @Mock
    AppVersion mAnnotation;

    @Mock
    ProviderFactory mProviderFactory;

    private AppVersionGenerator mGenerator;

    private int mMin;
    private int mMax;

    public AppVersionGeneratorTest(int mMin, int mMax) {
        this.mMin = mMin;
        this.mMax = mMax;
    }

    @Parameterized.Parameters(name = "min = {0}   max = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0,3},
                {-2,-1},
                {3,7},
                {1,1},
                {1,4},
                {5,1},
                {3,10},
                {1,Integer.MAX_VALUE},
        });
    }

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        when(mAnnotation.min()).thenReturn(mMin);
        when(mAnnotation.max()).thenReturn(mMax);
        mGenerator = new AppVersionGenerator(mAnnotation, mProviderFactory);
    }

    @Test
    public void test_valid_app_version_generated() {
        String appVersion = mGenerator.generate();
        assertNotNull(appVersion);
        assertThat(appVersion.length(),greaterThan(0));
    }

    @Test
    public void test_within_range_app_version_generated() {
        String appVersion = mGenerator.generate();
        int firstDotindex = appVersion.indexOf('.');
        if (firstDotindex != -1) {
            appVersion = appVersion.substring(0,firstDotindex);
        }
        int actualResult = Integer.parseInt(appVersion);
        System.out.println(actualResult);
        if (mAnnotation.max() < mAnnotation.min()) {
            assertTrue(actualResult >= mAnnotation.max() && actualResult <= mAnnotation.min());
        } else {
            assertTrue(actualResult >= mAnnotation.min() && actualResult <= mAnnotation.max());
        }
    }
}
