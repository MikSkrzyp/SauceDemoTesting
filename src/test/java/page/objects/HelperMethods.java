package page.objects;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;


public class HelperMethods {
    public static boolean isSortedAsc(ArrayList<String> numbers) {
        //if size of list is 1 then it is sorted already
        if (numbers.size() <= 1) {
            return true;
        }

        //deleting dollar sign because we get numbers in format "$99.99"
        ArrayList<Double> doubleList = new ArrayList<>();
        for (String number : numbers) {
            number = number.replace("$", "");
            doubleList.add(Double.parseDouble(number));
        }

        //loop which check if numbers are sorted
        for (int i = 0; i < doubleList.size() - 1; i++) {
            if (doubleList.get(i) > doubleList.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
    public static double parseWebElementValueToDouble(WebElement element) {
        String text = element.getText();

        //deleting dollar sign because we get numbers in format "$99.99"
        text = text.replace("$","");
        double value;

        //parsing value to Double with usage of  try catch
        try {
            value = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            System.err.println("Failed to parse value: " + text);
            value = Double.NaN;
        }
        return value;
    }


}
