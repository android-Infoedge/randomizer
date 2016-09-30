package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.Time;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gagandeep on 29/7/16.
 */

public class TimeGenerator extends GenerationRule<Time, String> {

    private String from;
    private String to;
    private Time.Format format;

    private final String SAMPLE_DATE = "02 Jan 2000";
    private final String SAMPLE_DATE_PATTERN = "dd MMM yyyy";

    private final String ACCEPTED_TIME_PATTERN_12_HOURS = "hh:mm aaa";
    private final String ACCEPTED_TIME_PATTERN_24_HOURS = "HH:mm";

    private long timediff = 0;
    private long fromMillis = 0;
    private long toMillis = 0;

    private final long HOURS_24 = 24 * 60 * 60 * 1000;


    public TimeGenerator(Time annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        from = annotation.from();
        to = annotation.to();
        format = annotation.format();

        String pattern = prepareCompleteSampleDateFormat(SAMPLE_DATE_PATTERN,getAnnotation().format() == Time.Format._12_HOURS ? ACCEPTED_TIME_PATTERN_12_HOURS : ACCEPTED_TIME_PATTERN_24_HOURS);

        from = prepareCompleteSampleDate(SAMPLE_DATE, annotation.from());
        to = prepareCompleteSampleDate(SAMPLE_DATE, annotation.to());

        fromMillis = getTimeMillisFromString(from, pattern);
        toMillis = getTimeMillisFromString(to, pattern);

        timediff = Math.abs(toMillis - fromMillis);

        if (toMillis < fromMillis) {
            toMillis = toMillis + HOURS_24;
            timediff = Math.abs(toMillis - fromMillis);
        }
    }

    @Override
    public String generate() {
        String pattern = getAnnotation().format() == Time.Format._12_HOURS ? ACCEPTED_TIME_PATTERN_12_HOURS : ACCEPTED_TIME_PATTERN_24_HOURS;
        long randomTime = (long) (fromMillis + (Math.random() * timediff));
        return getTimeString(randomTime, pattern);
    }

    private boolean isValidTime(String time) {
        return time != null && !time.isEmpty();
    }


    private String getTimeString(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
        return simpleDateFormat.format(date);
    }

    private long getTimeMillisFromString(String time, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }
        return date.getTime();
    }

    private String prepareCompleteSampleDate(String sampleDate, String time) {
        return String.format("%s %s", sampleDate, time);
    }

    private String prepareCompleteSampleDateFormat(String sampleDateFormat, String timeFormat) {
        return String.format("%s %s", sampleDateFormat, timeFormat);
    }
}
