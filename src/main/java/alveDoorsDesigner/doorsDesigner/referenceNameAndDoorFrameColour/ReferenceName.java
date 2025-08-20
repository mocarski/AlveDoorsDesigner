package alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour;

import alveDoorsDesigner.doorsDesigner.Constants;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import com.vaadin.data.Binder;
import com.vaadin.ui.TextField;

public class ReferenceName extends TextField {

    public ReferenceName(Wardrobe wardrobe){
        setPlaceholder(Constants.REFERENCE_NAME);
        setCaption(Constants.REFERENCE_NAME);
        setWidth("10%");

        bind(wardrobe);
    }

    public void bind(Wardrobe wardrobe) {
        Binder<Wardrobe> binder = new Binder<>();

        binder.forField(this)
                .asRequired(Constants.REFERENCE_NAME_IS_REQUIRED)
                .bind(Wardrobe::getReferenceName, Wardrobe::setReferenceName);

        binder.setBean(wardrobe);
    }

    public boolean isValid() {
        return getValue().equals("") ? false : true;
    }
}
