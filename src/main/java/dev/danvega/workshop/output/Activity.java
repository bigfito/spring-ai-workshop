package dev.danvega.workshop.output;

import java.time.LocalDate;

public record Activity(String activity, String location, LocalDate day, String time) {
}
