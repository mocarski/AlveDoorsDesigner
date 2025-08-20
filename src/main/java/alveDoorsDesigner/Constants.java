package alveDoorsDesigner;

public class Constants
{
    //Dimensions
    public static final int VERTICAL_PROFILE_WIDTH = 71;
    public static final int PLACE_TO_FILL_FULFILLMENT = 9;
    public static final int HORIZONTAL_PROFILE_WIDTH = 60;
    public static final int HBAR_WIDTH = 61;
    public static final int PLACE_FOR_TOP_WHEEL = 51;
    public static final int PLACE_FOR_BOTTOM_WHEEL = 146;
    public static final int PLACE_FOR_DIVIDING_PROFILE = 32;
    private static final int PLACE_BETWEEN_FLOOR_AND_DOORS = 17;
    private static final int PLACE_BETWEEN_CEILING_AND_DOORS = 34;
    public static final int SILICONE_BUFFERING_THICKNESS = 1;

    public static final int DOORS_LOWER_THEN_CAVITY = PLACE_BETWEEN_FLOOR_AND_DOORS + PLACE_BETWEEN_CEILING_AND_DOORS;
    public static final int DOORS_NARROWER_THEN_CAVITY = 2 * SILICONE_BUFFERING_THICKNESS;
    public static final int SPACE = 2;
    public static final int PLACE_FOR_TOP_WHEEL_CONFLICTED_WITH_MODULE = PLACE_FOR_TOP_WHEEL - HORIZONTAL_PROFILE_WIDTH;
    public static final int PLACE_FOR_BOTTOM_WHEEL_CONFLICTED_WITH_MODULE = PLACE_FOR_BOTTOM_WHEEL -
            HORIZONTAL_PROFILE_WIDTH;
    public static final int PLACE_FOR_RIGID_BAR_INTRUDING_HBAR = (HBAR_WIDTH - PLACE_FOR_DIVIDING_PROFILE)/2;
}
