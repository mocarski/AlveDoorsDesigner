package alveDoorsDesigner.doorsDesigner.numberOfDivisions;

import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import com.google.common.base.Strings;
import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.ui.TextField;

public class NumberOfDivisionsTextField extends TextField {

    private Binder<Door> binder = new Binder<>();

    private final UpdateVisibility updateVisibility;
    private final CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction;
    private final UpdateVisualization updateVisualization;
    private final UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction;

    public NumberOfDivisionsTextField(Door door, UpdateFulfillmentHeightTextFieldsAction
            updateFulfillmentHeightTextFieldsAction, CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction, UpdateVisualization
            updateVisualization, UpdateVisibility updateVisibility) {
        this.createFulfillmentTypeSelectsAction = createFulfillmentTypeSelectsAction;
        this.updateVisualization = updateVisualization;
        this.updateFulfillmentHeightTextFieldsAction = updateFulfillmentHeightTextFieldsAction;
        this.updateVisibility = updateVisibility;

        setPlaceholder(Constants.DIVIDERS_AMOUNT);

        // The only way to achieve proper UI behaviour when TextField is binded with int variable and
        // placeholder at the beginning should be shown.
        addValueChangeListener(getNumberOfDividersValueChangeListener(door));
    }

    public boolean isValid() {
        return binder.isValid() && !Strings.isNullOrEmpty(getValue());
    }

    private HasValue.ValueChangeListener<String> getNumberOfDividersValueChangeListener(Door door) {
        return new HasValue.ValueChangeListener() {
            boolean isBinded = false;

            @Override
            public void valueChange(HasValue.ValueChangeEvent valueChangeEvent) {
                if (valueChangeEvent.getOldValue().equals("") && !isBinded) {
                    isBinded = true;
                    bind(door);
                    addValueChangeListener(updateFulfillmentHeightTextFieldsAction);
                    addValueChangeListener(createFulfillmentTypeSelectsAction);
                    addValueChangeListener(updateVisualization);
                    addValueChangeListener(updateVisibility);
                    setValue(valueChangeEvent.getValue().toString());
                }
            }
        };
    }

    private Binder<Door> bind(Door door) {
        binder.forField(this)
                .asRequired("Number of numberOfDivisions is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(amountOfModules -> amountOfModules <= 5,
                        "Number of numberOfDivisions can not be higher than 5")
                .bind(Door::getNumberOfDivisions, Door::setAmountOfDivision);

        binder.setBean(door);

        return binder;
    }

    public Door getBean(){
        return binder.getBean();
    }
}
