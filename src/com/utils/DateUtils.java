package com.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String current(){
        //日期转换
        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");//精确到毫秒
        String strTime = sdf.format(nowTime);
        return strTime;
    }
}
