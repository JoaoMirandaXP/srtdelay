package br.com.jvcm.srtdelay;

import java.util.Date;

public class Subtitle {
    private String start;
    private String end;
    public int number;
    public int tokenIndex;

    public void setTimestamp(String start, String end) {
        this.start = start;
        this.end = end;
        srtDelay();
    }

    public String getStart(){
        return start;
    }
    public String getEnd() {
        return end;
    }

    /**
     * Aplica o delay se a legenda estiver no intervalo certo
     * @param s
     * @return
     */
    void srtDelay(){
        Date startSubtitleTime = DelayUtils.parseDate(DelayUtils.startTimeString);
        Date endSubtitleTime = DelayUtils.parseDate(DelayUtils.endTimeString);
        
        Date startTime = DelayUtils.parseDate(start);
        
        if(DelayUtils.in(startSubtitleTime, startTime, endSubtitleTime)){
            start = DelayUtils.delay(start);
            end = DelayUtils.delay(end);
        }
    }

    public String getTimestamp(){
        return start + " --> " + end;
    }

    @Override
    public String toString() {
        return getTimestamp();
    }
}
