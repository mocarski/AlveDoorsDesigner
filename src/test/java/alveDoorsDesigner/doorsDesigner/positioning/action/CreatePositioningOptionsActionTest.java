package alveDoorsDesigner.doorsDesigner.positioning.action;

import alveDoorsDesigner.doorsDesigner.positioning.PositioningOptionsView;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class CreatePositioningOptionsActionTest {

    @Mock
    PositioningOptionsView positioningOptionsView;

    @Test
    public void whenActionTriggered_ThenPositioningOptionsShouldBeCreated() throws Exception {
        positioningOptionsView.createPositioningOptions();
        replay(positioningOptionsView);
        CreatePositioningOptionsAction createPositioningOptionsAction = new
                CreatePositioningOptionsAction(positioningOptionsView);

        createPositioningOptionsAction.valueChange(null);

        verify(positioningOptionsView);
    }
}