package org.example;

import org.example.pyramid.brick.Index;
import org.example.pyramid.Pyramid;

import java.util.*;

public class PyramidApp2 {

    /**
     * Pyramid input data.
     */
    private final List<List<Integer>> pyramid = new ArrayList<>();

    /**
     * List of map consist of Index-Sum pair. Indekslerinde de bir listesi olması lazım.
     */
    private final Map<Index, List<Integer>> numberPaths = new HashMap<>();

    public void findPathHasMaxSum(Pyramid pyramid2) {

        // Initiate first pyramid number
        Index firstPathIndex = Index.create(0, 0);
        Integer firstPyramidNumber = pyramid.get(0).get(0);
        numberPaths.put(firstPathIndex, Collections.singletonList(firstPyramidNumber));

        for (int i = 1; i < pyramid.size(); i++) {

            for (int j = 0; j < pyramid.get(i).size(); j++) {

                // Prime check
                Integer number = pyramid.get(i).get(j);
                if (isPrime(number)) return;

                // Right Path check
                Index upRightIndex = Index.create(j, i - 1);
                List<Integer> upRightNumbers = numberPaths.get(upRightIndex); // check -1
                if (upRightNumbers != null) {
                    Index currentIndex = Index.create(j, i);
                    numberPaths.get(currentIndex).add(number);
                }

                // Left Path Check
                Index upLeftIndex = Index.create(j - 1, i - 1);
                List<Integer> upLeftNumbers = numberPaths.get(upLeftIndex); // check -1
                if (upLeftNumbers != null) {
                    Index currentIndex = Index.create(j, i);
                    numberPaths.get(currentIndex).add(number);
                }
            }
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) return false;

        int mod = number;
        while (2 < mod) {
            mod--;
            if (number % mod == 0)
                return false;
        }
        return true;
    }

}


//                                                  215
//                                                193 124
//                                              117 237 442
//                                            218 935 347 235
//                                          320 804 522 417 345
//                                        229 601 723 835 133 124
//                                      248 202 277 433 207 263 257
//                                    359 464 504 528 516 716 871 182
//                                  461 441 426 656 863 560 380 171 923
//                                381 348 573 533 447 632 387 176 975 449
//                              223 711 445 645 245 543 931 532 937 541 444
//                            330 131 333 928 377 733 017 778 839 168 197 197
//                          131 171 522 137 217 224 291 413 528 520 227 229 928
//                        223 626 034 683 839 053 627 310 713 999 629 817 410 121
//                      924 622 911 233 325 139 721 218 253 223 107 233 230 124 233


