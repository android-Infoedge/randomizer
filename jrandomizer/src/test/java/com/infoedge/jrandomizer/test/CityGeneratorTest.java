package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.City;
import com.infoedge.jrandomizer.generators.CityGenerator;
import com.infoedge.jrandomizer.providers.CityProvider;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by gagandeep on 3/8/16.
 */

@RunWith(Parameterized.class)
public class CityGeneratorTest {

    @Mock
    City mAnnotation;

    @Mock
    ProviderFactory mProviderFactory;

    @Mock
    CityProvider mProvider;

    CityGenerator mGenerator;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[10][0]);
    }

    private final String[] CITY_DATA = new String[]{
            "Angasmarca",
            "President Roxas",
            "Monsanto",
            "Nikolayevsk"
    };

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        when(mProviderFactory.provider(CityProvider.class, String[].class)).thenReturn(mProvider);
        mGenerator = new CityGenerator(mAnnotation, mProviderFactory);
        when(mProvider.provide()).thenReturn(CITY_DATA);
    }

    @Test
    public void test_verify_interaction() {
        mGenerator.generate();
        verify(mProvider).provide();
    }

    @Test
    public void test_generates_valid_city() {
        String city = mGenerator.generate();
        assertNotNull(city);
        assertTrue(city.length() != 0);
    }


}
