package alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.Constants;
import com.vaadin.data.Binder;
import com.vaadin.ui.NativeSelect;

import java.util.Arrays;

public class TopTrackFacioSelect extends NativeSelect<String> {

    private final Wardrobe wardrobe;

    public TopTrackFacioSelect(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
        setCaption(Constants.TOP_TRACK_FACIO);
        setWidth("10%");
        setEmptySelectionAllowed(false);

        bind();
        updateAvailableColours();
    }

    private void bind() {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( this )
                .bind( Wardrobe::getTopTrackFacio, Wardrobe::setTopTrackFacio);

        binder.setBean(wardrobe);
    }

    public void updateAvailableColours() {
        setItems(Arrays.asList(wardrobe.getColour(), Constants.WHITE));
    }
}
