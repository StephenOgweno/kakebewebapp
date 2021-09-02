package com.shop.kakebe.KaKebe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Config {

    //put your api key which obtained from admin dashboard
    public static final int WEBSITE_ID = 100;
    public static final String API_KEY = "Wv4Ga1B41jUJh3d67zA8dkOlp1Qakakebe";

    //public static String BASE_URL = "http://192.168.1.5/Projects/MultiWebView/";
    public static String BASE_URL = "http://admin.kakebe.com/";
    public static String GET_ALL_INFORMATION_URL = BASE_URL + "dashboard/Api/get_all_information/";
    public static String CONTENT_IMG_URL = BASE_URL + "assets/upload/content/";
    public static String TOTAL_CONTENT_VIEWED_URL = BASE_URL + "dashboard/Api/total_content_viewed/";


    //==========================================================================//
    public static String UnixToHuman(String publish_date){
        // ***** Convert Time *****
        long unixSeconds = Long.valueOf(publish_date);
        Date date = new Date(unixSeconds*1000L); // convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // - HH:mm --> The format of your date
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+3:30")); // give a timezone reference for formatting
        String humanDate = sdf.format(date);

        return humanDate;
    }


    //==========================================================================//
    public static String TimeAgo(String publish_date){
        // Guide: https://github.com/bancek/android-timeago/blob/master/src/com/lukazakrajsek/timeago/TimeAgo.java
        // ***** Convert Time *****
        long unixSeconds = Long.valueOf(publish_date);
        long diff = new Date().getTime() - (unixSeconds*1000L);

        String prefix = "";
        String suffix = "ago";

        double seconds = Math.abs(diff) / 1000;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;
        double years = days / 365;

        String words;

        if (seconds < 45) {
            words = Math.round(seconds)+" Seceond";
        } else if (seconds < 90) {
            words = "1 Minute";
        } else if (minutes < 45) {
            words = Math.round(minutes)+" Minutes" ;
        } else if (minutes < 90) {
            words = "1 Hour";
        } else if (hours < 24) {
            words = Math.round(hours)+" Hours";
        } else if (hours < 42) {
            words = "1 Day";
        } else if (days < 30) {
            words = Math.round(days)+" Days";
        } else if (days < 45) {
            words = "1 Month";
        } else if (days < 365) {
            words = Math.round(days / 30) + " Months";
        } else if (years < 1.5) {
            words = "1 Year";
        } else {
            words = Math.round(years) + " Years";
        }

        StringBuilder sb = new StringBuilder();

        if (prefix != null && prefix.length() > 0) {
            sb.append(prefix).append(" ");
        }

        sb.append(words);

        if (suffix != null && suffix.length() > 0) {
            sb.append(" ").append(suffix);
        }

        return sb.toString().trim();
    }


    //==========================================================================//
    public static boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }
}