package alveDoorsDesigner.doorsDesigner.numberOfDivisions;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import com.vaadin.ui.*;

import java.util.Iterator;

public class NumberOfDivisionsView extends VerticalLayout {

    private final Wardrobe wardrobe;
    private final HorizontalLayout layout;
    private Label label = new Label(Constants.NUMBER_OF_DIVISIONS);

    public NumberOfDivisionsView(Wardrobe wardrobe, HorizontalLayout layout) {
        this.wardrobe = wardrobe;
        this.layout = layout;

        addComponents(label, layout);
        setComponentAlignment(label, Alignment.TOP_CENTER);

        setWidthUndefined();
        setMargin(false);
        setStyleName("MarginTopAndBottom");
        setVisible(false);
    }

    public void createNumberOfDivisionFieldForEachDoor() {
        layout.removeAllComponents();
        for (Door door : wardrobe.getDoors()) {
            NumberOfDivisionsTextField numberOfDivisionsTextField = new NumberOfDivisionsTextField(door,
                    updateFulfillmentHeightTextFieldsAction, createFulfillmentTypeSelectsAction, updateVisualization, updateVisibility);

            layout.addComponent(numberOfDivisionsTextField);
        }
    }

    public boolean isValid() {
        if(!layout.getComponentIterator().hasNext())
            return false;
        for (Iterator<Component> it = layout.getComponentIterator(); it.hasNext(); ) {
            if (!((NumberOfDivisionsTextField) it.next()).isValid())
                return false;
        }

        return true;
    }

    public void setActions(UpdateVisibility updateVisibility, CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction,
                           UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction,
                           UpdateVisualization updateVisualization) {
        this.updateVisibility = updateVisibility;
        this.createFulfillmentTypeSelectsAction = createFulfillmentTypeSelectsAction;
        this.updateFulfillmentHeightTextFieldsAction = updateFulfillmentHeightTextFieldsAction;
        this.updateVisualization = updateVisualization;
    }

    private UpdateVisibility updateVisibility;
    private CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction;
    private UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction;
    private UpdateVisualization updateVisualization;
}
