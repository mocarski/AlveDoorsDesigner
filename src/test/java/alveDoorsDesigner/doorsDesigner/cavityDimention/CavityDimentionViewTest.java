package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.doorsDesigner.Constants;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class CavityDimentionViewTest {

    @Mock(MockType.NICE)
    CavityHeight cavityHeight;

    @Mock(MockType.NICE)
    CavityWidth cavityWidth;

    @Mock(MockType.NICE)
    NumberOfDoors numberOfDoors;

    @Mock(MockType.NICE)
    FormLayout formLayout;

    @Test
    public void headlineShouldBePlacedInTheMiddleOfView() {
        Label headline = new Label(Constants.CAVITY_DIMENTIONS);
        replay(cavityHeight, cavityWidth, numberOfDoors);

        CavityDimentionView cavityDimentionView = new CavityDimentionView(headline, new FormLayout(),
                cavityHeight, cavityWidth, numberOfDoors);

        assertEquals(Alignment.MIDDLE_CENTER, cavityDimentionView.getComponentAlignment(headline));
    }

    @Test
    public void
    cavityHeightCavityWidthAndNumberOfDoorsShouldBeStackedOneUnderTheOther_WithCaptionsOnTheLeftSide() {
        formLayout.addComponents(cavityHeight, cavityWidth, numberOfDoors);
        replay(formLayout,cavityHeight, cavityWidth, numberOfDoors);

        new CavityDimentionView(new Label(), formLayout, cavityHeight, cavityWidth, numberOfDoors);

        verify(formLayout);
    }

    @Test
    public void cavityDimentionViewIsValidWhenCavityHeightCavityWidthAndNumberOfDoorsAreValid() {
        expect(cavityHeight.isValid()).andReturn(true).andReturn(false).andReturn(true).andReturn(true);
        expect(cavityWidth.isValid()).andReturn(true).andReturn(false).andReturn(true);
        expect(numberOfDoors.isValid()).andReturn(true).andReturn(false);
        replay(cavityHeight, cavityWidth, numberOfDoors);

        CavityDimentionView cavityDimentionView = new CavityDimentionView(new Label(), new FormLayout(),
                cavityHeight, cavityWidth, numberOfDoors);

        assertTrue(cavityDimentionView.isValid());
        assertFalse(cavityDimentionView.isValid());
        assertFalse(cavityDimentionView.isValid());
        assertFalse(cavityDimentionView.isValid());
        verify(cavityHeight, cavityWidth, numberOfDoors);
    }
}