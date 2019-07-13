package pl.mbierut.models.weekend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Weekend {
    private LocalDate startDate;
    private LocalDate endDate;

    public boolean hasOverlapWith(Weekend otherPeriod) {
        //https://stackoverflow.com/questions/325933/determine-whether-two-date-ranges-overlap
        return !getStartDate().isAfter(otherPeriod.getEndDate()) && !getEndDate().isBefore(otherPeriod.getStartDate());
    }

    public List<LocalDate> getAllDaysInclusive() {
        List<LocalDate> allDates = new ArrayList<>();

        LocalDate tempDate = startDate;
        while (!tempDate.isAfter(endDate)) {
            allDates.add(tempDate);
            tempDate = tempDate.plusDays(1);
        }
        return allDates;
    }
}
