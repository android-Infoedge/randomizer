package com.infoedge.jrandomizer.test;

import com.infoedge.jrandomizer.annotations.CreditCardNumber;
import com.infoedge.jrandomizer.generators.CreditCardNumberGenerator;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by gagandeep on 4/8/16.
 */
@RunWith(value = Parameterized.class)
public class CreditCardNumberTest {

    @Mock
    CreditCardNumber mAnnotation;

    @Mock
    ProviderFactory mProviderFactory;

    private CreditCardNumberGenerator mGenerator;

    private TestCaseParams mParams;

    public CreditCardNumberTest(TestCaseParams mParams) {
        this.mParams = mParams;
    }

    @Parameterized.Parameters(name = "Separator = {0}")
    public static List<TestCaseParams> data() {
        return Arrays.asList(new TestCaseParams("-", null),
                new TestCaseParams("$", null),
                new TestCaseParams("#", "custom"),
                new TestCaseParams("", null)
        );
    }

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
    }

    public void prepare(String separator) {
        when(mAnnotation.separator()).thenReturn(separator);
        mGenerator = new CreditCardNumberGenerator(mAnnotation, mProviderFactory);
    }

    @Test
    public void test_valid_card_number_generated() {
        prepare(mParams.validInput);
        String cardNumber = mGenerator.generate();
        assertNotNull(cardNumber);
        assertTrue(cardNumber.length() > 0);
    }

    @Test
    public void test_handles_invalid_seprator() {
        prepare(mParams.invalidInput);
        String cardNumber = mGenerator.generate();
        assertNotNull(cardNumber);
        assertTrue(cardNumber.length() > 0);
    }

    @Test
    public void test_valid_card_number_format() {
        prepare(mParams.validInput);
        String cardNumber = mGenerator.generate();
        if (mParams.validInput.isEmpty()) {
            assertTrue(cardNumber.length() == 16);
        } else {
            assertTrue(cardNumber.length() > 16);
            String separator = mParams.validInput.substring(0, 1);
            assertEquals(cardNumber.indexOf(separator),4);
            cardNumber = cardNumber.substring(cardNumber.indexOf(separator) + 1);
            assertEquals(cardNumber.indexOf(separator),4);
            cardNumber = cardNumber.substring(cardNumber.indexOf(separator) + 1);
            assertEquals(cardNumber.indexOf(separator),4);
        }
    }


    private static class TestCaseParams {
        public String validInput;
        public String invalidInput;

        public TestCaseParams(String validInput, String invalidInput) {
            this.validInput = validInput;
            this.invalidInput = invalidInput;
        }

        @Override
        public String toString() {
            return "{" +
                    "validInput='" + validInput + '\'' +
                    ", invalidInput='" + invalidInput + '\'' +
                    '}';
        }
    }
}
