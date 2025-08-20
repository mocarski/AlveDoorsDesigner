package alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.action;

import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.BottomTrackCoverSelect;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.TopTrackFacioSelect;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

@RunWith(EasyMockRunner.class)
public class UpdateAvailableColorsActionTest {

    @Mock
    TopTrackFacioSelect topTrackFacioSelect;

    @Mock
    BottomTrackCoverSelect bottomTrackCoverSelect;

    @Test
    public void whenActionTriggered_ThenTopTrackFacioSelectAndBottomTrackCoverSelectShouldBeUpdated() throws
            Exception {
        topTrackFacioSelect.updateAvailableColours();
        bottomTrackCoverSelect.updateAvailableColours();
        replay(topTrackFacioSelect, bottomTrackCoverSelect);
        UpdateAvailableColorsAction updateAvailableColorsAction = new
                UpdateAvailableColorsAction(topTrackFacioSelect, bottomTrackCoverSelect);

        updateAvailableColorsAction.valueChange(null);

        verify(topTrackFacioSelect, bottomTrackCoverSelect);
    }
}