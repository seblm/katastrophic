package name.lemerdy.eric;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import static java.lang.String.format;

public class Inv3st_Plan {
    private static final int MAX_HOURS = 12;

    public static String input(String input) {
        final StringJoiner output = new StringJoiner("\n");
        int caseNumber = 1;

        final Scanner scanner = new Scanner(input);
        scanner.nextInt();
        while (scanner.hasNext()) {
            int amount = scanner.nextInt();
            List<Integer> plan = new ArrayList<>();
            for (int i = 1; i <= MAX_HOURS; i++) {
                plan.add(scanner.nextInt());
            }

            int maxProfit = 0;
            String bestProfit = "IMPOSSIBLE";
            for (int buyIndex = 1; buyIndex <= MAX_HOURS; buyIndex++) {
                for (int sellIndex = buyIndex; sellIndex <= MAX_HOURS; sellIndex++) {
                    int buyPrice = plan.get(buyIndex - 1);
                    int sellPrice = plan.get(sellIndex - 1);
                    int quantity = amount / buyPrice;
                    int currentProfit = quantity * sellPrice - quantity * buyPrice;

                    if (currentProfit > maxProfit) {
                        maxProfit = currentProfit;
                        bestProfit = buyIndex + " " + sellIndex + " " + maxProfit;
                    }
                }
            }

            output.add(format("Case #%d: %s", caseNumber++, bestProfit));
        }

        return output.toString();
    }
}
