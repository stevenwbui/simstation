package simstation;

import mvc.Utilities;

public enum Heading {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST;

    public static Heading random() {
        return values()[Utilities.rng.nextInt(Heading.values().length)];
    }
}
