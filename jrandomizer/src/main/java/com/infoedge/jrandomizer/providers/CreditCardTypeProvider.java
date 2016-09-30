package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CreditCardTypeProvider extends Provider<String[]> {
    private CreditCardTypeProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[] {
                    "bankcard",
                    "jcb",
                    "diners-club-international",
                    "mastercard",
                    "visa",
                    "diners-club-us-ca",
                    "china-unionpay",
                    "laser",
                    "maestro",
                    "visa-electron",
                    "diners-club-enroute",
                    "americanexpress",
                    "diners-club-carte-blanche",
                    "switch",
                    "instapayment",
                    "solo"
            };
        }
        return mLoadedData;
    }
}
