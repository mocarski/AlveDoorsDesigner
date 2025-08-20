package alveDoorsDesigner.doorsDesigner.positioning.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentTypeView;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.positioning.PositioningOptionsView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

@RunWith(EasyMockRunner.class)
public class UpdatePositioningOptionsActionTest {

    @Mock
    PositioningOptionsView positioningOptionsView;

    @Test
    public void whenActionTriggered_ThenUpdateAvailablePositioningOptions() throws Exception {
        positioningOptionsView.updateAvailablePositioningOptions();
        replay(positioningOptionsView);
        UpdatePositioningOptionsAction updatePositioningOptionsAction = new
                UpdatePositioningOptionsAction(positioningOptionsView);

        updatePositioningOptionsAction.valueChange(null);

        verify(positioningOptionsView);
    }
}