package name.lemerdy.eric;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

public class Inv3st_PlanTest {
    @Test(expected = NullPointerException.class)
    public void should_fail_without_input() {
        Inv3st_Plan.input(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void should_fail_with_empty_input() {
        Inv3st_Plan.input("");
    }

    @Test(expected = NoSuchElementException.class)
    public void should_fail_with_two_numbers() {
        Inv3st_Plan.input("0 1");
    }

    @Test(expected = ArithmeticException.class)
    public void should_fail_with_a_zero_as_one_price() {
        Inv3st_Plan.input("0 100 2 3 4 5 6 7 0 9 10 11 12 13");
    }
    @Test
    public void should_return_empty_with_one_number() {
        String output = Inv3st_Plan.input("0");

        assertThat(output).isEmpty();
    }

    @Test
    public void should_return_impossible_if() { // TODO understand why ?
        String output = Inv3st_Plan.input("0 1 2 3 4 5 6 7 8 9 10 11 12 13");

        assertThat(output).isEqualTo("Case #1: IMPOSSIBLE");
    }

    @Test
    public void should_return_result_if() { // TODO understand why ?
        String output = Inv3st_Plan.input("0 100 2 3 4 5 6 7 8 9 10 11 12 13");

        assertThat(output).isEqualTo("Case #1: 1 12 550");
    }

    @Test
    public void should_compute_result_for_two_cases() {
        String output = Inv3st_Plan.input("0" +
                " 1 2 3 4 5 6 7 8 9 10 11 12 13" +
                " 100 2 3 4 5 6 7 8 9 10 11 12 13");

        assertThat(output).isEqualTo("" +
                "Case #1: IMPOSSIBLE\n" +
                "Case #2: 1 12 550");
    }

    @Test
    public void should_compute_result_for_a_lot_of_cases() {
        String output = Inv3st_Plan.input("0" +
                " -74 -86 -45 24 -11 24 97 38 29 -15 -97 -24 22" +
                " -62 -26 91 74 -77 -70 -40 99 91 62 92 -49 55" +
                " 54 -55 -94 35 -62 -43 41 33 18 -56 54 46 43" +
                " 92 77 -71 76 45 98 -40 -19 39 -60 83 -67 -49" +
                " 42 65 -11 50 -15 65 -89 65 -33 33 -35 -26 -25" +
                " 82 -1 -48 81 13 29 18 -99 -26 -44 91 -12 -65" +
                " -71 14 59 -96 88 -79 -43 -87 -9 26 -92 82 -60" +
                " -58 60 50 -49 -69 68 -61 37 -35 90 71 -37 -74" +
                " -87 -20 35 94 -94 58 70 35 -28 94 38 33 -23" +
                " 63 39 26 23 37 -23 -31 31 -31 -52 33 45 -56" +
                " -39 -30 93 -79 -55 -37 22 62 -27 -53 54 55 -87" +
                " -39 -30 33 -67 -76 -32 46 73 53 43 14 -84 -7" +
                " -70 -60 -95 34 5 -69 79 36 -91 55 68 5 -96" +
                " 69 -18 5 -88 84 -50 2 22 55 -90 -73 75 1" +
                " 71 -42 -78 23 -49 42 -35 9 35 -71 -6 -54 -74" +
                " -8 -28 -90 24 81 -2 24 90 -69 -46 -59 5 -1" +
                " -64 -88 -94 74 -22 11 -84 -5 -12 -50 -70 51 -71" +
                " 48 88 -92 -56 95 69 40 -51 13 48 -65 60 57" +
                " 75 -84 9 7 74 -51 -85 -67 61 -83 -9 -61 64" +
                " 87 96 71 -44 -79 -5 -94 -10 -69 25 34 -67 -6" +
                " 46 84 -23 38 -17 21 95 60 -39 6 -23 -23 59" +
                " 10 18 60 -67 46 -25 5 26 -36 -95 -32 49 -21" +
                " -9 -47 58 -34 57 75 27 47 23 1 26 8 23" +
                " 15 -35 46 30 -82 69 -37 -18 -54 97 -82 -3 66" +
                " 7 81 38 -12 -43 71 9 -94 22 24 77 -19 -48" +
                " 66 -58 -36 -30 -74 -71 -79 90 20 -51 -32 36 35" +
                " 12 -99 -65 -63 -90 -87 -94 -5 -98 -80 -76 -77 14" +
                " -93 -87 -29 -18 93 80 -94 82 76 -71 98 65 -83" +
                " 60 -86 -95 12 -35 -17 24 23 -13 26 -74 -50 -57" +
                " -2 70 2 -86 -87 67 -1 -11 -64 -9 80 -31 -65" +
                " -60 -11 -16 50 -95 47 62 -88 77 18 -29 -72 -90" +
                " 25 61 57 14 -13 -34 90 -83 -85 -17 -43 42 93" +
                " 39 46 -81 -92 -59 -95 88 97 86 -63 -17 86 -37" +
                " -3 -72 -71 18 -50 44 84 63 -85 44 17 -10 -35" +
                " -100 -62 -96 -73 -55 78 4 73 40 33 -28 69 -14" +
                " 62 82 45 -25 -35 -75 -80 -3 -23 62 6 97 -62" +
                " -23 -51 93 -93 -100 -4 28 -20 -72 55 -70 -97 -32" +
                " 40 -63 -75 71 -5 -68 -89 -67 12 -72 50 58 -61" +
                " 67 93 97 84 28 -35 -52 59 -39 90 -86 85 -29" +
                " -46 41 34 10 -5 98 -49 57 -10 48 24 -2 31" +
                " 68 34 80 65 -47 -74 77 -66 95 -63 -9 60 -10" +
                " -24 -93 -45 32 -63 22 -69 19 -3 -85 -37 25 -6" +
                " -83 36 6 -19 86 12 30 4 -94 30 -55 -70 -93" +
                " -58 -84 -45 -63 -78 85 31 86 -75 -85 -28 91 69" +
                " 71 11 -61 -60 -61 -59 10 19 -43 -65 -79 10 55" +
                " -24 33 53 -33 11 -72 73 -90 87 53 -12 88 -76" +
                " 13 73 15 -79 88 -45 -77 -87 -53 -55 66 28 82" +
                " 48 -96 -23 74 -10 59 -80 -40 98 -82 -43 -46 -78" +
                " -40 58 -64 -60 40 -12 -19 54 32 -43 -32 48 -5" +
                " 90 42 55 3 66 -61 93 3 7 -26 12 54 33");

        assertThat(output).isEqualTo("" +
                "Case #1: 4 6 648\n" +
                "Case #2: 1 7 250\n" +
                "Case #3: 8 10 108\n" +
                "Case #4: 7 11 192\n" +
                "Case #5: 2 6 234\n" +
                "Case #6: 1 7 8036\n" +
                "Case #7: 8 11 637\n" +
                "Case #8: 3 9 139\n" +
                "Case #9: 1 3 456\n" +
                "Case #10: 5 12 66\n" +
                "Case #11: 1 2 123\n" +
                "Case #12: 10 11 196\n" +
                "Case #13: 4 12 1414\n" +
                "Case #14: 6 11 2482\n" +
                "Case #15: 10 12 748\n" +
                "Case #16: 5 7 368\n" +
                "Case #17: 7 11 672\n" +
                "Case #18: 8 11 141\n" +
                "Case #19: 3 4 670\n" +
                "Case #20: 5 6 1513\n" +
                "Case #21: 9 12 371\n" +
                "Case #22: 6 11 88\n" +
                "Case #23: IMPOSSIBLE\n" +
                "Case #24: IMPOSSIBLE\n" +
                "Case #25: IMPOSSIBLE\n" +
                "Case #26: 3 6 98\n" +
                "Case #27: 7 8 186\n" +
                "Case #28: 3 10 580\n" +
                "Case #29: 8 10 244\n" +
                "Case #30: 6 10 162\n" +
                "Case #31: 1 8 440\n" +
                "Case #32: 3 12 79\n" +
                "Case #33: 10 12 40\n" +
                "Case #34: IMPOSSIBLE\n" +
                "Case #35: 6 10 800\n" +
                "Case #36: 7 12 1180\n" +
                "Case #37: 5 9 295\n" +
                "Case #38: 4 6 672\n" +
                "Case #39: 4 9 124\n" +
                "Case #40: 4 5 927\n" +
                "Case #41: 1 8 122\n" +
                "Case #42: 8 11 224\n" +
                "Case #43: 7 8 1960\n" +
                "Case #44: 10 11 238\n" +
                "Case #45: 6 12 315\n" +
                "Case #46: 4 7 202\n" +
                "Case #47: IMPOSSIBLE\n" +
                "Case #48: 4 9 288\n" +
                "Case #49: 5 7 198\n" +
                "Case #50: 3 6 2700");
    }
}