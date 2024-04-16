package org.example.taplab6;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CalendarController implements Initializable {

    @FXML
    private Label monthYearLabel;

    @FXML
    private GridPane calendarGrid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Afișăm luna și anul curente în formatul "Luna Anul"
        LocalDate currentDate = LocalDate.now();
        String monthYearString = currentDate.format(DateTimeFormatter.ofPattern("MMMM yyyy"));
        monthYearLabel.setText(monthYearString);
        // Afișăm calendarul pentru luna curentă
        populateCalendarGrid(currentDate);
    }

    private void populateCalendarGrid(LocalDate currentDate) {
        // Șablon pentru zilele săptămânii
        String[] daysOfWeek = {"Mon ", "Tue ", "Wed ", "Thu ", "Fri ", "Sat ", "Sun "};

        // Adăugăm antetul cu zilele săptămânii
        for (int i = 0; i < daysOfWeek.length; i++) {
            Label dayLabel = new Label(daysOfWeek[i]);
            dayLabel.setStyle("-fx-font-weight: bold");
            calendarGrid.add(dayLabel, i, 0);
        }

        // Afișăm zilele lunii în calendarGrid
        int daysInMonth = currentDate.lengthOfMonth();
        LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue(); // 1 - Monday, 7 - Sunday

        int row = 1;
        int col = startDayOfWeek - 1;
        for (int day = 1; day <= daysInMonth; day++) {
            Label dayLabel = new Label(String.valueOf(day));
            if (currentDate.getDayOfMonth() == day) {
                dayLabel.setStyle("-fx-background-color: #66bbff; -fx-font-weight: bold"); // Ziua curentă
            } else if (col == 0 || col == 6) {
                dayLabel.setStyle("-fx-text-fill: #6495ED"); // Weekend
            }
            calendarGrid.add(dayLabel, col, row);
            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }
    }
}