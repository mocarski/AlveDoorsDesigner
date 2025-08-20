package alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoorFrameColourSelectTest {
    @Test
    public void emptySelectionIsNotAllowed() throws Exception {
        DoorFrameColourSelect select = new DoorFrameColourSelect(new Wardrobe());
        assertFalse(select.isEmptySelectionAllowed());
    }

    //TODO we can create class which extends NativeSelect and give posiibility to get all values
    @Test
    public void selectShouldHaveAllColoursToChooseFrom() throws Exception {
        DoorFrameColourSelect select = new DoorFrameColourSelect(new Wardrobe());
        int length = DoorFrameColour.values().length;

//        assertEquals(length, select.g);
    }
}