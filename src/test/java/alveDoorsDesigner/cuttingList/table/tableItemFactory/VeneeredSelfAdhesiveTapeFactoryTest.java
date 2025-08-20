package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VeneeredSelfAdhesiveTapeFactoryTest {
    VeneeredSelfAdhesiveTapeFactory factory = new VeneeredSelfAdhesiveTapeFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void wardrobeAlwaysHasOnlyOneVeneeredSelfAdhesiveTape() {
        assertEquals(1, factory.create(wardrobe).getQuantity());
    }

    @Test
    public void widthOfVeneeredSelfAdhesiveTapeShouldBeTheSameAsWidthOfWardrobeCavity() {
        assertEquals(Integer.toString(wardrobe.getCavityWidth()), factory.create(wardrobe).getDimention());
    }
}