package com;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ST500Adapter implements MeteoSensor {
    private SensorTemperature sensorTemperature;

    public ST500Adapter(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }

    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public Float getTemperature() {
        return (float)sensorTemperature.temperature();
    }

    @Override
    public Float getHumidity() {
        return null;
    }

    @Override
    public Float getPressure() {
        return null;
    }

    @Override
    public LocalDateTime getDateTime() {
        LocalDate localDate=LocalDate.ofYearDay(sensorTemperature.year(),sensorTemperature.day());
        int seconds=sensorTemperature.second();
        int hh = seconds / 3600;
        int mm = (seconds - hh * 3600) / 60;
        int ss = seconds - hh * 3600 - mm * 60;
        LocalDateTime localDateTime = localDate.atTime(hh,mm,ss);
        return localDateTime;
    }
}
