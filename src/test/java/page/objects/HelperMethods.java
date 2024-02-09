package page.objects;
import org.openqa.selenium.WebElement;

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
    public static double parseWebElementValueToDouble(WebElement element) {
        String text = element.getText();
        text = text.replace("$","");
        double value;
        try {
            value = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse value: " + text);
            value = Double.NaN;
        }
        return value;
    }


}
