package Tests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class exampleTest2 {

    @Test
    public void gabling() {
        List<String> suits = Arrays.asList("Heart", "Diamond", "Club", "Spade");
        List<String> nums = Arrays.asList("6", "7", "8", "9", "10", "11", "12", "13", "14");
        List<String> finalDeck = new ArrayList<String>();
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 9; k++) {
                finalDeck.add(counter, suits.get(i) + " " + nums.get(k));
                counter++;
            }
        }
        Collections.shuffle(finalDeck);

        int pyramidSize = 7;
        String[][] pyramid = new String[pyramidSize][pyramidSize];

        counter = 0;
        for (int i = 0; i < pyramidSize; i++) {
            for (int k = 0; k <= i; k++) {
                if (i == pyramidSize - 1) {
                    pyramid[i][k] = finalDeck.get(counter) + " [T]";
                } else {
                    pyramid[i][k] = finalDeck.get(counter) + " [N]";
                }
                counter++;
            }
        }

        System.out.println("\nPyramid: ");
        Arrays.stream(pyramid).map(Arrays::toString).forEach(System.out::println);
        List<String> shuffle = new ArrayList<String>();

        shuffle.add(finalDeck.get(counter) + " [T]");
        for (int i = counter + 1; i < 36; i++) {
            shuffle.add(finalDeck.get(i) + " [N]");
        }

        System.out.println("\nShuffle: \n" + shuffle);

        for (int i = 6; i >= 0; i--) {
            for (int k = 0; k <= i; k++) {
                if (pyramid[i][k].contains("[T]")) {
                    for (int n = 6; n >= 0; n--) {
                        for (int o = 0; o <= n; o++) {
                            if (pyramid[n][o].contains("[T]") && !pyramid[n][o].equals(pyramid[i][k])
                                    && pyramid[n][o].replaceAll("\\D+", "")
                                    .equals(pyramid[i][k].replaceAll("\\D+", ""))) {
                                pyramid[i][k] = "[DEL]";
                                pyramid[n][o] = "[DEL]";

                                for (int q = 6; q >= 0; q--) {
                                    for (int w = 0; w <= 6; w++) {
                                        // System.out.println(pyramid[q][w]);
                                        if (w != 6 && pyramid[q][w] != null && pyramid[q][w].contains("[DEL]") &&
                                                pyramid[q][w + 1].contains("[DEL]")) {
                                            if (!pyramid[q - 1][w].contains("[T]")) {
                                                pyramid[q - 1][w] = pyramid[q - 1][w] + " [T]";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        //System.out.println(pyramid[5][2]);
        System.out.println(pyramid[6][2] + "   " + pyramid[6][3]);

        System.out.println("\nPyramid after first iteration: \n" + shuffle);
        Arrays.stream(pyramid).map(Arrays::toString).forEach(System.out::println);
    }
}
