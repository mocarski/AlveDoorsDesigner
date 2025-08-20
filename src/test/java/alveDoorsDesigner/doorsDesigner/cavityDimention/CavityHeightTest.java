package alveDoorsDesigner.doorsDesigner.cavityDimention;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(EasyMockRunner.class)
public class CavityHeightTest {

    @Mock
    UpdateVisibility updateVisibility;

    @Mock
    UpdateVisualization updateVisualization;

    @Mock
    UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction;

    private CavityHeight cavityHeight;

    @Before
    public void setUp() throws Exception {
        cavityHeight = new CavityHeight(new Wardrobe());
        cavityHeight.setActions(updateVisibility, updateVisualization,
                updateFulfillmentHeightTextFieldsAction);
    }

    @Test
    public void cavityHeightIsNotValidWhenEmptyValue(){
        cavityHeight.setValue("");
        assertFalse(cavityHeight.isValid());
    }

    @Test
    public void cavityCanNotBeHigherThen2800mm() {
        cavityHeight.setValue("2800");
        assertTrue(cavityHeight.isValid());

        cavityHeight.setValue("2801");
        assertFalse(cavityHeight.isValid());
    }

    @Test
    public void afterValueChange_VisualizationShouldBeUpdated(){
        updateVisualization.valueChange(anyObject());
        replay(updateVisualization);

        cavityHeight.setValue("anyValue");
        verify(updateVisualization);
    }

    @Test
    public void afterValueChange_FulfillmentHeightFieldsShouldBeUpdated(){
        updateFulfillmentHeightTextFieldsAction.valueChange(anyObject());
        replay(updateFulfillmentHeightTextFieldsAction);

        cavityHeight.setValue("anyValue");
        verify(updateFulfillmentHeightTextFieldsAction);
    }

    @Test
    public void afterValueChange_VisibilityOfDesignerSectionsShouldBeUpdated(){
        updateVisibility.valueChange(anyObject());
        replay(updateVisibility);

        cavityHeight.setValue("anyValue");
        verify(updateVisibility);
    }
}