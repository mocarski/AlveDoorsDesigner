package alveDoorsDesigner.doorsDesigner;

import alveDoorsDesigner.navigation.action.GoToComponentsListAction;
import com.vaadin.ui.Button;

public class PreviewListButton extends Button {

    public PreviewListButton(GoToComponentsListAction goToComponentsListAction) {
        addClickListener(goToComponentsListAction);

        setCaption(Constants.PREVIEW_PRODUCTION_LIST);
        setStyleName("MarginTopAndBottom");
        setEnabled(false);
    }
}
