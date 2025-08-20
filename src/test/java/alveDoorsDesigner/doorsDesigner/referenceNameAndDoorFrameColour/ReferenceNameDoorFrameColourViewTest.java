package alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour;

import static org.junit.Assert.*;
import alveDoorsDesigner.model.Wardrobe;
import org.junit.Test;

public class ReferenceNameDoorFrameColourViewTest {

    @Test
    public void referenceNameAndDoorFrameColourShouldBeVisibleAsOneSection() throws Exception {
        Wardrobe wardrobe = new Wardrobe();
        ReferenceNameDoorFrameColourView view = new ReferenceNameDoorFrameColourView(new ReferenceName
                (wardrobe), new DoorFrameColourSelect(wardrobe));

        assertEquals("MarginTopAndBottom", view.getStyleName());
    }
}