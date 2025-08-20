package alveDoorsDesigner.doorsDesigner.positioning;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.model.WardrobeToolbox;
import com.vaadin.data.Binder;
import com.vaadin.ui.NativeSelect;

import java.util.Arrays;

public class PositioningOptionSelect extends NativeSelect<PositioningOption> {

    private final Wardrobe wardrobe;
    private final Door door;

    public PositioningOptionSelect(Wardrobe wardrobe, Door door) {
        this.wardrobe = wardrobe;
        this.door = door;
        setEmptySelectionAllowed(false);

        bind();
        update();
    }

    private void bind() {
        Binder<Door> binder = new Binder<>();

        binder.forField( this )
                .bind( Door::getPositioningOption, Door::setPositioningOption);

        binder.setBean(door);
    }

    public void update(){
        if( WardrobeToolbox.isUtmostDoor( wardrobe, door) && door.getWidth() >= 600 ) {
            setItemsToSelect(PositioningOption.values());
        }
        else {
            if(PositioningOption.Dumper.equals(getValue()))
                setValue(PositioningOption.None);
            setItemsToSelect(new PositioningOption[]{PositioningOption.None, PositioningOption.Positioner});
        }
    }

    public void setItemsToSelect(PositioningOption[] positioningOptions){
        this.setItems(positioningOptions);
    }
}
