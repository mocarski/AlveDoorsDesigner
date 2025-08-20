package alveDoorsDesigner.doorsDesigner.fulfillmentHeight;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Door;
import alveDoorsDesigner.model.Module;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;

public class FulfillmentHeightValidator implements Validator<Integer> {

    private final Door door;
    private final Module module;

    public FulfillmentHeightValidator(Door door, Module module) {
        this.door = door;
        this.module = module;
    }

    @Override
    public ValidationResult apply(Integer integer, ValueContext valueContext) {
        if (integer == countCorrectHeightOfModule())
            return ValidationResult.ok();

        /*Dispite of error as validation result, model has to be updated to give possibility to change
        other modules heights. It works like binding also for incorrect height.*/
        module.setHeight(integer);

        return ValidationResult.error(prepareErrorMessage());
    }

    private String prepareErrorMessage() {
        if (countCorrectHeightOfModule() <= 0) {
            return Constants.prepareMessageWhenHeightOfOtherModulesHasToBeChanged(door
                    .calculateTargetHeightOfModules());
        }
        return Constants.prepareMessageWhenHeightOfModuleHasToBeChanged(door
                .calculateTargetHeightOfModules(), countCorrectHeightOfModule());
    }

    private int countCorrectHeightOfModule() {
        int summaryOfRestModules = 0;
        for (Module module : door.getModules()) {
            if (!module.equals(this.module))
                summaryOfRestModules += module.getHeight();
        }

        return door.calculateTargetHeightOfModules() - summaryOfRestModules;
    }
}
