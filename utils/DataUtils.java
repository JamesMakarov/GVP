package utils;

import java.time.LocalDateTime;

public class DataUtils {
    private DataUtils() {
        throw new UnsupportedOperationException("Não é possível instanciar esta classe");
    }
    public static int anoNow() {
        return LocalDateTime.now().getYear();
    }

    public static int mesNow() {
        return LocalDateTime.now().getMonthValue();
    }

    public static int diaNow() {
        return LocalDateTime.now().getDayOfMonth();
    }

    public static int horaNow() {
        return LocalDateTime.now().getHour();
    }

    public static int minutoNow() {
        return LocalDateTime.now().getMinute();
    }

    public static int segundoNow() {
        return LocalDateTime.now().getSecond();
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
}
