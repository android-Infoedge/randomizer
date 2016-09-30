package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class CurrencyProvider extends Provider<String[]> {
    private CurrencyProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[] {
                    "Peso",
                    "Pound",
                    "Yen",
                    "Zloty",
                    "Euro",
                    "Yuan Renminbi",
                    "Rupiah",
                    "Real",
                    "Dollar",
                    "Sol",
                    "Ruble",
                    "Dinar",
                    "Cedi",
                    "Hryvnia",
                    "Lempira",
                    "Dong",
                    "Cordoba",
                    "Lev",
                    "Marka",
                    "Tugrik",
                    "Baht",
                    "Rial",
                    "Boliviano",
                    "Rand",
                    "Naira",
                    "Krona",
                    "Won",
                    "Manat",
                    "Birr",
                    "Ringgit",
                    "Forint",
                    "Shilling",
                    "Kuna",
                    "Som",
                    "Franc",
                    "Shekel",
                    "Dirham",
                    "Denar",
                    "Tenge",
                    "Koruna",
                    "Leu",
                    "Taka",
                    "Dram",
                    "Kyat",
                    "Afghani",
                    "Bolivar",
                    "Balboa",
                    "Rupee",
                    "Guarani",
                    "Krone",
                    "Lek",
                    "Rufiyaa",
                    "Lari",
                    "Litas",
                    "Pula",
                    "Ariary",
                    "Riels",
                    "Somoni",
                    "Dalasi"
            };
        }
        return mLoadedData;
    }
}
