package ru.geekbrains.converter;

public class ConvertToMs implements ConvertTo {
    @Override
    public float Do(float sourceValue) {
        float res=(float)(sourceValue/3.6);
        return res;
    }
}
