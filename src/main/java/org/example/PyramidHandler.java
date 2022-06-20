package org.example;

import org.example.pyramid.Pyramid;
import org.example.pyramid.brick.Brick;
import org.example.pyramid.brick.Index;
import org.example.pyramid.path.Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PyramidHandler {

    public Path findPathHasMaxSum(Pyramid pyramid) {
        composePaths(pyramid);
        return getPathHasMaxSum(pyramid);
    }

    private void composePaths(Pyramid pyramid) {
        List<List<Brick>> bricks = pyramid.getBricks();

        for (int i = 1; i < bricks.size(); i++) {
            List<Brick> bricksInLine = bricks.get(i);

            for (int j = 0; j < bricksInLine.size(); j++) {
                Brick brick = bricksInLine.get(j);

                // daha bu tuglaya gelmedi bile, nasil out oluyor!
                if (brick.isOut()) System.out.println("FATAL ERROR");

                // Prime check
                if (brick.isPrime()) {
                    brick.out();
                    continue;
                }

                Index upRightIndex = Index.create(i - 1, j);
                Index upLeftIndex = Index.create(i - 1, j - 1);

                List<Path> newPaths = new ArrayList<>();
                for (Path path : pyramid.getPaths()) {

                    if (path.getLength() != i) continue;

                    if (path.hasIndex(upRightIndex)) {
                        Path newPath = path.fork(brick);
                        newPaths.add(newPath);
                    }

                    if (path.hasIndex(upLeftIndex)) {
                        Path newPath = path.fork(brick);
                        newPaths.add(newPath);
                    }
                }

                if (!newPaths.isEmpty())
                    pyramid.addPaths(newPaths);
            }
        }
    }

    private Path getPathHasMaxSum(Pyramid pyramid) {
        Path pathHasMaxSum = Path.create(Collections.emptyList());
        int maxSum = 0;
        for (Path path : pyramid.getPaths()) {
            int sum = path.getSum();
            if (sum > maxSum) {
                pathHasMaxSum = path;
                maxSum = sum;
            }
        }
        return pathHasMaxSum;
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


