package alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action;

import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightView;
import com.vaadin.data.HasValue;

public class UpdateFulfillmentHeightTextFieldsAction implements HasValue.ValueChangeListener<String> {

    private final FulfillmentHeightView fulfillmentHeightView;

    public UpdateFulfillmentHeightTextFieldsAction(FulfillmentHeightView fulfillmentHeightView){
        this.fulfillmentHeightView = fulfillmentHeightView;
    }

    @Override
    public void valueChange(HasValue.ValueChangeEvent<String> valueChangeEvent) {
        fulfillmentHeightView.createFulfillmentHeightTextFields();
    }
}
