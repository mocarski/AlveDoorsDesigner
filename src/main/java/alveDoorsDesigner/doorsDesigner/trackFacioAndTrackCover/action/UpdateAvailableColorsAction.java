package alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.action;

import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.BottomTrackCoverSelect;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.TopTrackFacioSelect;
import com.vaadin.data.HasValue;

public class UpdateAvailableColorsAction implements HasValue.ValueChangeListener<String> {

    private final TopTrackFacioSelect topTrackFacioSelect;
    private final BottomTrackCoverSelect bottomTrackCoverSelect;

    public UpdateAvailableColorsAction(TopTrackFacioSelect topTrackFacioSelect, BottomTrackCoverSelect bottomTrackCoverSelect){
        this.topTrackFacioSelect = topTrackFacioSelect;
        this.bottomTrackCoverSelect = bottomTrackCoverSelect;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        topTrackFacioSelect.updateAvailableColours();
        bottomTrackCoverSelect.updateAvailableColours();
    }
}
