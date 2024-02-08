package page.objects;
import java.util.ArrayList;

public class HelperMethods {
    public static boolean isSortedAsc(ArrayList<String> numbers) {
        if (numbers.size() <= 1) {
            return true;
        }

        ArrayList<Double> doubleList = new ArrayList<>();
        for (String number : numbers) {
            number = number.replace("$", "");
            doubleList.add(Double.parseDouble(number));
        }

        for (int i = 0; i < doubleList.size() - 1; i++) {
            if (doubleList.get(i) > doubleList.get(i + 1)) {
                return false;
            }
        }

        return true;
    }


}
