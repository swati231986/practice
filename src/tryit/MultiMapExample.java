package tryit;

import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;

import org.joda.time.LocalDate;
import java.util.Calendar;

public class MultiMapExample {
    public static void main(String [] args) {

        RangeMap<Comparable<?>, Object> isTaxChecklistRequiredMonthMap = ImmutableRangeMap.builder().
                put(Range.closed(Calendar.JANUARY, Calendar.APRIL), Boolean.TRUE).
                put(Range.closed(Calendar.MAY, Calendar.OCTOBER), Boolean.TRUE).
                put(Range.closed(Calendar.NOVEMBER, Calendar.DECEMBER), Boolean.FALSE).build();

        RangeMap<Comparable<?>, Object> isBundleRequiredMonthMap = ImmutableRangeMap.builder().
                put(Range.closed(Calendar.JANUARY, Calendar.APRIL), Boolean.FALSE).
                put(Range.closed(Calendar.MAY, Calendar.OCTOBER), Boolean.TRUE).
                put(Range.closed(Calendar.NOVEMBER, Calendar.DECEMBER), Boolean.FALSE).build();

        LocalDate currentDate = LocalDate.now();
        if (isTaxChecklistRequiredMonthMap.get(currentDate.getMonthOfYear()) != null && isTaxChecklistRequiredMonthMap.get(currentDate.getMonthOfYear()).equals(Boolean.TRUE)) {
            if(currentDate.getMonthOfYear() == Calendar.APRIL && currentDate.getDayOfMonth()> 17) {
                //if it has bundle
            } else if(isBundleRequiredMonthMap.get(currentDate.getMonthOfYear()) != null && isBundleRequiredMonthMap.get(currentDate.getMonthOfYear()).equals(Boolean.TRUE)) {
                // check if has bundle
            }
        } else if(isTaxChecklistRequiredMonthMap.get(currentDate.getMonthOfYear()) != null && isTaxChecklistRequiredMonthMap.get(currentDate.getMonthOfYear()).equals(Boolean.FALSE)){
           // return false;
        }
    }
}
