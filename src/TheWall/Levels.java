package TheWall;
/*
Creator: Erdem Ege Marasli
 */
/**
 * For squareLocations
 * 0 = empty
 * 1 = blueKnights
 * 2 = redKnights
 * 3 = castle
 * For Edge
 * 0 = empty
 * 1 = non empty
 * For Rectangles
 * 0 = empty
 * 1 = wall
 * 2 = castle wall
 */

public class Levels {
    Map [] levels = new Map[64];
    //int [] squareLocations; // 16
    //int [] edgeLocations; // 26
    //int [] horizontalRectangleLocations; // 20
    //int [] verticalRectangleLocations; // 21
    public Levels(){
        int [] squareLocations = {3,3,0,
                                0,0,0,0,0,
                                0,0,1,0,1,
                                  0,0,1};

        int [] edgeLocations = {0,0,1,0,
                                0,1,0,0,1,0,
                                0,0,0,0,0,0,
                                0,0,0,0,0,1,
                                0,0,0,0};

        int [] horizontalRectangleLocations = {1,1,0,
                                            0,1,1,1,0,
                                            0,0,1,0,1,
                                            0,0,1,0,1,
                                              0,0,1};

        int [] verticalRectangleLocations = {1,2,1,0,
                                            0,0,0,1,1,0,
                                            0,0,1,0,0,1,
                                            0,0,1,1};

        levels[0] = new Map(squareLocations,edgeLocations,horizontalRectangleLocations,verticalRectangleLocations);

        int [] squareLocations1 = {0,0,1,
                                0,0,0,2,0,
                                0,1,0,3,2,
                                  0,2,3};

        int [] edgeLocations1 = {0,1,0,0,
                                0,1,0,0,0,0,
                                0,0,0,0,0,0,
                                0,1,0,0,0,0,
                                0,0,1,0};

        int [] horizontalRectangleLocations1 = {0,1,1,
                                                0,1,0,1,0,
                                                0,1,0,1,0,
                                                0,1,1,2,0,
                                                0,0,1};

        int [] verticalRectangleLocations1 = {0,1,0,1,
                                            0,1,0,1,0,0,
                                            0,1,1,0,1,0,
                                              0,0,1,1};

        levels[1] = new Map(squareLocations1,edgeLocations1,horizontalRectangleLocations1,verticalRectangleLocations1);
    }

    public Map[] getLevels() {
        return levels;
    }
}
