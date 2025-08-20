package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.ui.*;

import java.util.LinkedList;
import java.util.List;

public class FulfillmentHeightView extends VerticalLayout {

    public FulfillmentHeightView(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;

        layoutForAllDoors.setMargin(false);
        addComponents(label, layoutForAllDoors);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        setWidthUndefined();
        setMargin(false);
        setStyleName("MarginTopAndBottom");
        setVisible(false);
    }

    public void createFulfillmentHeightTextFields() {
        layoutForAllDoors.removeAllComponents();
        for (Door door : wardrobe.getDoors()) {
            layoutForAllDoors.addComponent(fulfillmentHeightsForDoorLayoutGenerator.generate(door));
        }
        updateVisibility.valueChange(null);
    }

    public boolean isValid() {
        if (getAllHeightOfFillingsTextFields().size() == 0)
            return false;
        for (FulfillmentHeightTextField fulfillmentHeightTextField : getAllHeightOfFillingsTextFields()) {
            if (!fulfillmentHeightTextField.isValid())
                return false;
        }

        return true;
    }

    public void validate() {
        for (FulfillmentHeightTextField fulfillmentHeightTextField : getAllHeightOfFillingsTextFields()) {
            fulfillmentHeightTextField.validate();
        }
    }

    private List<FulfillmentHeightTextField> getAllHeightOfFillingsTextFields() {
        List<FulfillmentHeightTextField> fulfillmentHeightTextFieldList = new LinkedList<>();
        for (Component verticalLayouts : (Iterable<Component>) () -> layoutForAllDoors.getComponentIterator
                ()) {
            for (Component textFields : (Iterable<Component>) () -> ((VerticalLayout) verticalLayouts)
                    .getComponentIterator())
                fulfillmentHeightTextFieldList.add((FulfillmentHeightTextField) textFields);
        }

        return fulfillmentHeightTextFieldList;
    }

    public void setActions(UpdateVisibility updateVisibility,
                           FulfillmentHeightsForDoorLayoutGenerator fulfillmentHeightsForDoorLayoutGenerator) {
        this.updateVisibility = updateVisibility;
        this.fulfillmentHeightsForDoorLayoutGenerator = fulfillmentHeightsForDoorLayoutGenerator;
    }

    private final Wardrobe wardrobe;
    private UpdateVisibility updateVisibility;
    private FulfillmentHeightsForDoorLayoutGenerator fulfillmentHeightsForDoorLayoutGenerator;
    private Label label = new Label(Constants.HEIGHT_OF_FILLINGS);
    private HorizontalLayout layoutForAllDoors = new HorizontalLayout();
}
