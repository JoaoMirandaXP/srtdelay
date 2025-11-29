package br.com.jvcm.srtdelay;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DelayUtils {
    // Date Formatter
    static SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss,SSS");

    private static int delayTime;
    public static String startTimeString;
    public static String endTimeString;
    
    public static void setDelayTime(int d){
        delayTime = d;
    }

    /** 
     * @param dateString
     * @return Dado uma string no formato HH:mm:ss,SSS retorna um objeto data
     */
    static Date parseDate(String dateString){
        try {
            return df.parse(dateString);    
        } catch (Exception e) {
            throw new Error("Formato de data inserida inváilida.");

        }
    }

    /**
     * @param current tempo atual na legenda
     * @return o novo tempo de legenda com atraso...
     */
    static String delay(String current){
        Date currentTime = parseDate(current);
        Date delayedTime = new Date(currentTime.getTime()+delayTime);
        return df.format(delayedTime);
    }

    /**
     * Verifica se di<d<df
     * @param di
     * @param d
     * @param df
     * @return 
     */
    public static boolean in(Date di, Date d, Date df){
        return di.compareTo(d) == -1 && df.compareTo(d) == 1;
    }

}
