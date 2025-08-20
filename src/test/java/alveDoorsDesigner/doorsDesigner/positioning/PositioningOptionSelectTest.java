package alveDoorsDesigner.doorsDesigner.positioning;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PositioningOptionSelectTest {

    private Wardrobe wardrobe = new Wardrobe();
    private int numberOfDoors = 2;

    @Before
    public void setUp() throws Exception {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(numberOfDoors);
    }

    @Test
    public void emptySelectionShouldBeNotAllowed() throws Exception {
        PositioningOptionSelect positioningOptionSelect = new PositioningOptionSelect(wardrobe, wardrobe
                .getDoors().get(0));

        assertFalse(positioningOptionSelect.isEmptySelectionAllowed());
    }

    @Test
    public void whenWidthOfDoorIsGraterThen600_ThenAllPositioningOptionsShouldBeAvailable() throws
            Exception {
        TestablePositioningOptionSelect positioningOptionSelect = new TestablePositioningOptionSelect
                (wardrobe, wardrobe
                .getDoors().get(0));

        assertEquals(3, positioningOptionSelect.getPositioningOptions().length);
        assertEquals(PositioningOption.None, positioningOptionSelect.getPositioningOptions()[0]);
        assertEquals(PositioningOption.Positioner, positioningOptionSelect.getPositioningOptions()[1]);
        assertEquals(PositioningOption.Dumper, positioningOptionSelect.getPositioningOptions()[2]);
    }

    @Test
    public void whenWidthOfDoorIsLessThen600_ThenPositionerAndNoneOptionsShouldBeAvailable() throws
            Exception {
        wardrobe.setCavityWidth(1000);

        TestablePositioningOptionSelect positioningOptionSelect = new TestablePositioningOptionSelect
                (wardrobe, wardrobe
                .getDoors().get(0));

        assertEquals(2, positioningOptionSelect.getPositioningOptions().length);
        assertEquals(PositioningOption.None, positioningOptionSelect.getPositioningOptions()[0]);
        assertEquals(PositioningOption.Positioner, positioningOptionSelect.getPositioningOptions()[1]);
    }

    @Test
    public void
    whenSelectedOptionWasDumper_AndSelectIsUpdatedWhenWidthOfDoorIsLessThen600_ThenNoneOptionShouldBeSelected()
            throws
            Exception {
        TestablePositioningOptionSelect positioningOptionSelect = new TestablePositioningOptionSelect
                (wardrobe, wardrobe
                .getDoors().get(0));

        positioningOptionSelect.setValue(PositioningOption.Dumper);
        wardrobe.setCavityWidth(1000);
        positioningOptionSelect.update();

        assertEquals(PositioningOption.None, positioningOptionSelect.getValue());
    }

    private class TestablePositioningOptionSelect extends PositioningOptionSelect {
        private PositioningOption[] positioningOptions;

        public TestablePositioningOptionSelect(Wardrobe wardrobe, Door door) {
            super(wardrobe, door);
        }

        @Override
        public void setItemsToSelect(PositioningOption[] positioningOptions) {
            this.positioningOptions = positioningOptions;
        }

        public PositioningOption[] getPositioningOptions() {
            return positioningOptions;
        }
    }
}