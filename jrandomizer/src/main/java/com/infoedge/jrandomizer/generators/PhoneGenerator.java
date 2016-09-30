package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.Utils;
import com.infoedge.jrandomizer.annotations.Phone;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gagandeep on 31/7/16.
 */

public class PhoneGenerator extends GenerationRule<Phone,String> {

    private Map<Integer, Integer> mPartsMap;

    public PhoneGenerator(Phone annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        String[] split = annotation.country().getFormat().split("-");
        mPartsMap = new HashMap<>(split.length - 1);
        parsePhonePartsAndPopulateMap(mPartsMap,split);
    }

    @Override
    public String generate() {
        String phoneNnumber = getAnnotation().country().getFormat();
        Set<Integer> keys = mPartsMap.keySet();
        for (Integer key : keys) {
            String toReplace = String.format("\\{%d,%d\\}", key, mPartsMap.get(key));
            String replaceWith = generatePhoneNumberPart(mPartsMap.get(key), getAnnotation().country().getStart());
            phoneNnumber = phoneNnumber.replaceAll(toReplace, replaceWith);
        }
        return phoneNnumber;
    }

    private String generatePhoneNumberPart(int digits,int min) {
        long startNumber = Long.parseLong(Utils.tailPad(String.valueOf(min), "0", digits));
        long endNumber = (long) (Math.pow(10, digits) - 1);
        return String.valueOf(Utils.randomLongWithMinMax(startNumber, endNumber));
    }

    private void parsePhonePartsAndPopulateMap(Map<Integer, Integer> map, String[] parts) {
        int count = parts.length;
        for (int i = 1; i < count; i++) {
            String part = parts[i].replaceAll("\\{", "").replaceAll("\\}", "");
            map.put(Integer.parseInt(part.split(",")[0]), Integer.parseInt(part.split(",")[1]));
        }
    }


}
