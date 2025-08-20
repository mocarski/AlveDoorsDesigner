package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import com.google.common.base.Strings;
import com.vaadin.data.Binder;
import com.vaadin.ui.TextField;

public class FulfillmentHeightTextField extends TextField {

    private Binder<Module> binder = new Binder<>();

    public FulfillmentHeightTextField(Door door, Module module){
        setPlaceholder(Constants.HEIGHT_OF_FILLING);
        bindModuleWithDivisionTextField(door, module);
    }

    private void bindModuleWithDivisionTextField(Door door, Module module) {
        binder.forField(this)
                .asRequired("The height of fulfillmentType is required")
                .withConverter(Integer::valueOf, String::valueOf, "Input value should be a number")
                .withValidator(new FulfillmentHeightValidator(door, module))
                .bind(Module::getHeight, Module::setHeight);

        binder.setBean(module);
    }

    public boolean isValid() {
        return binder.isValid() && !Strings.isNullOrEmpty(this.getValue());
    }

    /*Allows trigger text field validation from outside when height of other fulfillment within the same
    door will change)*/
    public void validate() {
        binder.validate();
    }
}
