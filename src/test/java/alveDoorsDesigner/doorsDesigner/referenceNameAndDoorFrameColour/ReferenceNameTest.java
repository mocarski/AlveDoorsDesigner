package alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReferenceNameTest {

    @Test
    public void referenceNameIsValidWhenIsNotEmpty() throws Exception {
        ReferenceName referenceName = new ReferenceName(new Wardrobe());

        referenceName.setValue("notEmpty");
        assertTrue(referenceName.isValid());

        referenceName.setValue("");
        assertFalse(referenceName.isValid());
    }
}