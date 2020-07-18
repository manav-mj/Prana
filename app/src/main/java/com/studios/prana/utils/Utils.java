package com.studios.prana.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.studios.prana.R;
import com.studios.prana.models.LifestyleData;
import com.studios.prana.models.LifestyleTile;
import com.studios.prana.models.TrackerData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static LifestyleData getLifestyleContent(Context context) {
        InputStream stream = context.getResources().openRawResource(R.raw.lifestyle_data);

        Writer writer = new StringWriter();
        try {
            char[] buffer = new char[10240];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(stream, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                stream.close();
            }
        } catch (IOException e) {

        }

        return new Gson().fromJson(writer.toString(), LifestyleData.class);
    }

    public static TrackerData getAlarmsData(Context context) {
        InputStream stream = context.getResources().openRawResource(R.raw.alarms_data);

        Writer writer = new StringWriter();
        try {
            char[] buffer = new char[10240];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(stream, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                stream.close();
            }
        } catch (IOException e) {

        }

        return new Gson().fromJson(writer.toString(), TrackerData.class);
    }

}