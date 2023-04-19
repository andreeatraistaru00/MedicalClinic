package com.example.medical.clinic.utils;

import java.time.format.DateTimeFormatter;

public class Formatters {
    public final static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final static DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
}
