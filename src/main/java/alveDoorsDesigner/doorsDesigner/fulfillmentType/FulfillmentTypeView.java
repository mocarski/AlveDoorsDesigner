package alveDoorsDesigner.doorsDesigner.fulfillmentType;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class FulfillmentTypeView extends VerticalLayout {

    public FulfillmentTypeView(Wardrobe wardrobe, HorizontalLayout fulfillmentSelectsForAllDoorsLayout) {
        this.wardrobe = wardrobe;
        this.fulfillmentSelectsForAllDoorsLayout = fulfillmentSelectsForAllDoorsLayout;

        addComponents(label, fulfillmentSelectsForAllDoorsLayout);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        setWidthUndefined();
        setMargin(false);
        setStyleName("MarginTopAndBottom");
        setVisible(false);
    }

    public void createFulfillmentTypeSelects() {
        fulfillmentSelectsForAllDoorsLayout.removeAllComponents();

        for (Door door : wardrobe.getDoors()) {
            fulfillmentSelectsForAllDoorsLayout.addComponent(createFulfillmentSelectsForDoor(door));
        }
    }

    private VerticalLayout createFulfillmentSelectsForDoor(Door door) {
        VerticalLayout fulfillmentSelectsForDoor = new VerticalLayout();
        fulfillmentSelectsForDoor.setMargin(false);
        for (Module module : door.getModules()) {
            fulfillmentSelectsForDoor.addComponent(new FulfillmentTypeSelect(module));
        }
        return fulfillmentSelectsForDoor;
    }

    private Label label = new Label(Constants.TYPE_OF_FILLINGS);
    private final Wardrobe wardrobe;
    private final HorizontalLayout fulfillmentSelectsForAllDoorsLayout;
}
