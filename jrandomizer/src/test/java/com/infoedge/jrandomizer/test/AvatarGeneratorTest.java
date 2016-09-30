package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.Avatar;
import com.infoedge.jrandomizer.exceptions.RandomDataGeneratorException;
import com.infoedge.jrandomizer.generators.AvatarGenerator;
import com.infoedge.jrandomizer.providers.AvatarProvider;
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by gagandeep on 3/8/16.
 */
@RunWith(value = Parameterized.class)
public class AvatarGeneratorTest {

    @Mock
    Avatar mAnnotation;

    @Mock
    ProviderFactory mProviderFactory;

    @Mock
    AvatarProvider mProvider;

    private AvatarGenerator mGenerator;

    private TestCaseParams mParams;

    public AvatarGeneratorTest(TestCaseParams mParams) {
        this.mParams = mParams;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<TestCaseParams> data() {
        return Arrays.asList(
                new TestCaseParams(new Params(50,50,Avatar.Format.PNG),new Params(-1,-1,Avatar.Format.PNG)),
                new TestCaseParams(new Params(100,200,Avatar.Format.PNG),new Params(-1,50,Avatar.Format.PNG)),
                new TestCaseParams(new Params(0,0,Avatar.Format.PNG),new Params(50,-1,Avatar.Format.PNG)),
                new TestCaseParams(new Params(50,50,Avatar.Format.BMP),new Params(5000,50,Avatar.Format.PNG)),
                new TestCaseParams(new Params(50,50,Avatar.Format.PNG),new Params(50,50000,Avatar.Format.PNG)),
                new TestCaseParams(new Params(50,50,Avatar.Format.JPG),new Params(50000,50000,Avatar.Format.PNG)),
                new TestCaseParams(new Params(50,50,Avatar.Format.RANDOM),new Params(0,50000,Avatar.Format.PNG))
        );
    }

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        when(mProviderFactory.provider(AvatarProvider.class, String[].class)).thenReturn(mProvider);
        when(mProvider.provide()).thenReturn(new String[]{
                "https://robohash.org/doloremnostrumquod.{format}?size={width}x{height}&set=set1"});
    }

    private void prepare(Params params) {
        when(mAnnotation.width()).thenReturn(params.width);
        when(mAnnotation.height()).thenReturn(params.height);
        when(mAnnotation.format()).thenReturn(params.format);
        mGenerator = new AvatarGenerator(mAnnotation, mProviderFactory);
    }

    @Test
    public void test_generated_valid_url() {
        prepare(mParams.validParams);
        String avatarUrl = mGenerator.generate();
        Assert.assertNotNull(avatarUrl);
    }

    @Test
    public void test_generated_url_width_height() {
        prepare(mParams.validParams);
        String avatarUrl = mGenerator.generate();
        String expected = String.format("%dx%d", mParams.validParams.width, mParams.validParams.height);
        assertTrue(avatarUrl.contains(expected));
    }

    @Test
    public void test_generated_url_extension() {
        prepare(mParams.validParams);
        String avatarUrl = mGenerator.generate();
        String expected = String.format("%s?", mParams.validParams.format.getLabel());
        if (mParams.validParams.format == Avatar.Format.RANDOM) {
            assertFalse(avatarUrl.contains(expected));
        } else {
            assertTrue(avatarUrl.contains(expected));
        }
    }

    @Test(expected = RandomDataGeneratorException.class)
    public void test_handles_invalid_params() {
        prepare(mParams.invalidParams);
        mGenerator.generate();
    }

    private static class TestCaseParams {

        Params validParams;
        Params invalidParams;

        public TestCaseParams(Params validParams, Params invalidParams) {
            this.validParams = validParams;
            this.invalidParams = invalidParams;
        }

        @Override
        public String toString() {
            return "{" +
                    "validParams=" + validParams +
                    ", invalidParams=" + invalidParams +
                    '}';
        }
    }

    private static class Params {
        int width;
        int height;
        Avatar.Format format;

        public Params(int width, int height, Avatar.Format format) {
            this.width = width;
            this.height = height;
            this.format = format;
        }

        @Override
        public String toString() {
            return "{" +
                    "width=" + width +
                    ", height=" + height +
                    ", format=" + format +
                    '}';
        }
    }


}
