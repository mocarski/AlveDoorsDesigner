package alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.action.UpdateAvailableColorsAction;
import com.vaadin.data.Binder;
import com.vaadin.ui.NativeSelect;

public class DoorFrameColourSelect extends NativeSelect<String> {

    public DoorFrameColourSelect(Wardrobe wardrobe) {
        setCaption(Constants.DOOR_FRAME_COLOUR);
        setWidth( "10%" );
        setEmptySelectionAllowed( false );
        setItems( DoorFrameColour.getDoorFrameColours() );

        bind(wardrobe);
    }

    public void bind(Wardrobe wardrobe){
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField( this )
                .bind( Wardrobe::getColour, Wardrobe::setColour);

        binder.setBean(wardrobe);
    }
}
