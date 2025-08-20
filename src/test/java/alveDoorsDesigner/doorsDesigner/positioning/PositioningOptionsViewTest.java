package alveDoorsDesigner.doorsDesigner.positioning;

import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.ui.HorizontalLayout;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(EasyMockRunner.class)
public class PositioningOptionsViewTest {

    private HorizontalLayout positioningOptionsLayout = new HorizontalLayout();

    private Wardrobe wardrobe = new Wardrobe();
    private int numberOfDoors = 2;

    @Before
    public void setUp() throws Exception {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
    }

    @Test
    public void PositioningOptionsShouldBeInvisibleByDefault() throws Exception {
        PositioningOptionsView positioningOptionsView = new PositioningOptionsView(wardrobe,
                positioningOptionsLayout);

        assertFalse(positioningOptionsView.isVisible());
    }

    @Test
    public void numberOfPositioningOptionSelectsShouldBeEqualsToNumberOfDoors() throws Exception {
        PositioningOptionsView positioningOptionsView = new PositioningOptionsView(wardrobe,
                positioningOptionsLayout);

        positioningOptionsView.createPositioningOptions();

        assertEquals(numberOfDoors, positioningOptionsLayout.getComponentCount());
    }

    @Test
    public void whenPositioningOptionSelectsRecreated_ThenNumberOfSelectsShouldBeEqualsToNumberOfDoors()
            throws Exception {
        PositioningOptionsView positioningOptionsView = new PositioningOptionsView(wardrobe,
                positioningOptionsLayout);

        positioningOptionsView.createPositioningOptions();
        wardrobe.setNumberOfDoors(3);
        positioningOptionsView.createPositioningOptions();

        assertEquals(3, positioningOptionsLayout.getComponentCount());
    }

    @Test
    public void whenViewUpdated_ThenAllSelectsShouldBeUpdated() throws Exception {
        PositioningOptionSelect Select1 = niceMock(PositioningOptionSelect.class);
        PositioningOptionSelect Select2 = niceMock(PositioningOptionSelect.class);
        PositioningOptionSelect Select3 = niceMock(PositioningOptionSelect.class);
        Select1.update();
        Select2.update();
        Select3.update();
        replay(Select1, Select2, Select3);
        positioningOptionsLayout.addComponents(Select1, Select2, Select3);

        PositioningOptionsView positioningOptionsView = new PositioningOptionsView(wardrobe,
                positioningOptionsLayout);

        positioningOptionsView.updateAvailablePositioningOptions();

        verify(Select1, Select2, Select3);
    }
}