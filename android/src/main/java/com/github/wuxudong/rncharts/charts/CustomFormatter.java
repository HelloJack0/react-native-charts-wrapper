package com.github.wuxudong.rncharts.charts;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class CustomFormatter extends ValueFormatter {

    private DecimalFormat mFormat;
    private boolean isPieChart = false;
    private int sum = 0;
    
    public CustomFormatter(String value, String type) {
        if (type.equals("PIE")) {
            isPieChart = true;
            String[] str = value.split("PIE");
            sum = Integer.parseInt(str[1]);
            mFormat = new DecimalFormat(str[0]);
        } else {
            mFormat = new DecimalFormat(value);
        }
    }

    public CustomFormatter(String value) {
        mFormat = new DecimalFormat(value);
    }

    @Override
    public String getFormattedValue(float value) {
        if (isPieChart) {
             return mFormat.format(value)+", "+Math.round((value*sum)/100);
        }
        return mFormat.format(value);
    }

}
