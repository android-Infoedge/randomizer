package com.infoedge.jrandomizer.providers;

/**
 * Created by gagandeep on 31/7/16.
 */

public class EncryptProvider extends Provider<String[]> {

    private EncryptProvider(Class<String[]> clazz) {
        super(clazz);
    }

    @Override
    public String[] provide() {
        if (mLoadedData == null) {
            mLoadedData = new String[]{
                    "EnCt2a9720dffdea29776d93ef8de7521f34f786ce6a9a9720dffdea29776d93ef8dea6CFudXXGQOyMCLhmleOo",
                    "92XKnpQbjwbYSS1RGKPWPFfbjx2TJHvxhSiTST6o/vYRbXxvGkK1TKj0tsRS0u2HmI7Y",
                    "JcEn+tsgnffVWCR5X5gf5NAyjZRXbLuPYqOE/t+zV9yuxaljBAp5KwEIXd7i8VdAO2IxdGviYz6bhWkxSz22G7llM3X1lYk",
                    "TtTTsv8/Nrj63bNiJLvCymtNRtJP7GyDnMLPG9AagKLgJkEL29rnQBepGpDYCvSJXWNEVJpvjWi/qIQ5v2UJ3Wu3C3ug",
                    "FD8hTr1LU44wZibBTWelVbS2bfvxk6wrwbIESdZsM1ID3WtCT7wVTiecscatiHnZhBN4BqKB5oMxg7CXqeHMRXOKBgneu49BPn/",
                    "kqSFP+Av00DKPTdeiNeNSVXQxDN+evPvQ7utu2D8v2+JY5EmMWgUeWN8LgGZMK7oQWrgzBiiwCvREr9F1b4CHk",
                    "vKpB2USc5HatC8AUE/TcB0+QOru898A/HT0EK9fYy2Sk8/HnZX+quyxBypHIIi+GVG1Qu1Af1RLgdxqP2PPLNWiNLycsyzFStg",
                    "5KDkwtwyuYTJNRTA+JW3K23LofhqUtSwz6uzxcYSM9cWkX2LkLYRcjTx8RRv8nt2+gexieeI4xN0gcC7F1WOVMg9b5/8WGvseUHFMNm2HpHJwukEYFYz",
                    "Bjc4rxnUdj8JfZDM6NWfbTCmPvIP9314SXKW1SkvAuh37k+RrddrwupLr5FFOxmND7s/rzPs2UMQs6fu5B3Mah+K3abEf3U9qlHTxATvhvB",
                    "QP4ip+dDw3z12xBZtDPFfJlP/kzE2bHj9zGJZrHaLS9NRibuFUiXIuJLHDkofHsw0zMQF5KS9mnX9ZNZNJEbkGFCUcxPjHKGemBEtf6Dgx8o6EzYQuVcqF/hoVe6DDsxVhILe2Ph1eMFA",
                    "Kj9u7QNsTqpdhI4FpfmudKwuSId2EIa/Lr7OIAUSPikBoQ0nKrxxQJPwFBskJ5mn0n2V2cprW5Y/Szm/LftL3c4oUfTDF8goNzlQhCQZHukn00I6u69QVEDCRD4",
                    "2sG7blkbnkAbPS3T2tWHPT6vSHJ9Et1BiRPCCUrLmNPshcaX6wrosKPrW4hwkFdSiOAtgyQyd8ZEKs8y9RrXuXqhIoxxK1B4pOVkkyGC",
                    "nX/A3zyAohSZj5/UcAM13D5VuQH2ENytSqYwDbJG6sDsVyO08snq98EhwaDdW6562oGdj18WgPq83CVK",
                    "cacN1yfKRSDKzvaV4BMwWEu8HPpOYE22BWabYfMThecmz2q78eh5Au+uRfga+IZ4FLd4FmDHkpCjJMXGgmKFTKucWGD",
                    "ckPxwT7G7FmSiX4uPDQlTv7ywLF8sAXheFI3ldIVJWEEnSkXzvKOMKZLEo",
                    "z93NKa56qhzut+FJROJOFOPSpEEMxMDKiaCs+CUPBe2QXE+hxyHeJgFndrG5qUlLMNZuQBOBd4Pr+Tvj3gsBQP94E",
                    "NOnlnslQeZeNG/R7l5+eMYW3/CbrB36gt7/0jjXD9/s=IwEmS"
            };
        }
        return mLoadedData;
    }
}
