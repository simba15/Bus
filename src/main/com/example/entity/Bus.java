package main.com.example.entity;

import java.util.Objects;

public class Bus {
    private String comanyName;
    private String beginWay;
    private String endWay;

    private int beginHours;
    private int beginMinutes;

    private int endHours;
    private int endMinutes;

    private int durationMinutes;



    public Bus() {}


    public Bus(String comanyName, String beginWay, String endWay) {
        this.comanyName = comanyName;
        this.beginWay = beginWay;
        this.endWay = endWay;

        int[]parseBegin = parseInt(beginWay.split(":"));
        beginHours=parseBegin[0];
        beginMinutes=parseBegin[1];

        int[]parseEnd = parseInt(endWay.split(":"));
        endHours=parseEnd[0];
        endMinutes=parseEnd[1];

        durationMinutes = getDuration();
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    private int getDuration() {
        return (endHours*60) - (beginHours*60) + endMinutes - beginMinutes;
    }

    public int getBeginHours() {
        return beginHours;
    }

    public int getBeginMinutes() {
        return beginMinutes;
    }

    public int getEndHours() {
        return endHours;
    }


    public int getEndMinutes() {
        return endMinutes;
    }


    public String getComanyName() {

        return comanyName;
    }

    public void setComanyName(String comanyName) {
        this.comanyName = comanyName;
    }

    public String getBeginWay() {
        return beginWay;
    }

    public void setBeginWay(String beginWay) {
        this.beginWay = beginWay;
    }

    public String getEndWay() {
        return endWay;
    }

    public void setEndWay(String endWay) {
        this.endWay = endWay;
    }


    private int[]parseInt(String[]value){
        int[]numbers = new int[value.length];

        for (int i=0;i<numbers.length;i++) {
            numbers[i]=Integer.parseInt(value[i]);
        }
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(comanyName, bus.comanyName) &&
                Objects.equals(beginWay, bus.beginWay) &&
                Objects.equals(endWay, bus.endWay);
    }

    @Override
    public int hashCode() {

        return beginHours*60+beginMinutes;
    }

    @Override
    public String toString() {
        return comanyName + " " + beginWay + " " + endWay;
    }
}
