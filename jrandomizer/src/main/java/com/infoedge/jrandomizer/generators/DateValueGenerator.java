package com.infoedge.jrandomizer.generators;

import com.infoedge.jrandomizer.annotations.DateValue;
import com.infoedge.jrandomizer.providers.ProviderFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by gagandeep on 29/7/16.
 */

public class DateValueGenerator extends GenerationRule<DateValue,String> {

    private DateValue.Format mDateFormat;
    private String mCustomDateFormat;
    private String mFrom;
    private String mTo;

    private Date mFromDate;
    private Date mToDate;

    public DateValueGenerator(DateValue annotation,ProviderFactory providerFactory) {
        super(annotation, providerFactory);
        mDateFormat = annotation.format();
        mCustomDateFormat = annotation.customFormat();
        mFrom = annotation.from();
        mTo = annotation.to();

        mFromDate = fromStringToDate(isDateFormatvalid(mCustomDateFormat) ? mCustomDateFormat : mDateFormat.getValue(), mFrom);
        mToDate = fromStringToDate(isDateFormatvalid(mCustomDateFormat) ? mCustomDateFormat : mDateFormat.getValue(), mTo);
    }

    @Override
    public String generate() {
        Date randomDate = randomDate(mFromDate, mToDate);
        return fromDateToString(isDateFormatvalid(mCustomDateFormat) ? mCustomDateFormat : mDateFormat.getValue(),randomDate);
    }

    private Date fromStringToDate(String format, String value) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        Date date = null;
        try {
            date = dateFormat.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }
        return date;
    }

    private String fromDateToString(String format, Date date) {
        DateFormat dateFormat = new SimpleDateFormat(format,Locale.US);
        String dateString = null;
        dateString = dateFormat.format(date);
        return dateString;
    }

    private Date randomDate(Date fromDate, Date toDate) {
        long fromTime = fromDate.getTime();
        long toTime = toDate.getTime();

        long diff = toTime - fromTime + 1;

        if (diff <= 0) {
            return fromDate;
        }

        long randomTime = fromTime + (long) (Math.random() * diff);
        return new Date(randomTime);
    }

    private boolean isDateFormatvalid(String format) {
        return format != null && !format.isEmpty();
    }
}
