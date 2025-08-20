package alveDoorsDesigner.cuttingList.table.tableItemFactory;

import alveDoorsDesigner.model.Wardrobe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TopWheeledConnectorsLeftFactoryTest {
    TopWheeledConnectorsLeftFactory factory = new TopWheeledConnectorsLeftFactory();
    Wardrobe wardrobe = new Wardrobe();

    @Before
    public void setUp() {
        wardrobe.setCavityHeight(2000);
        wardrobe.setCavityWidth(2000);
        wardrobe.setNumberOfDoors(3);
    }

    @Test
    public void topWheeledConnectorLeftHasNoDimention() {
        assertEquals("", factory.create(wardrobe).getDimention());
    }

    @Test
    public void numberOfTopWheeledConnectorsLeftShouldBeTheSameAsNumberOfDoors() {
        assertEquals(wardrobe.getAmountOfDoors(), factory.create(wardrobe).getQuantity());
    }
}