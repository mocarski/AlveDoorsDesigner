package alveDoorsDesigner.navigation.action;


import alveDoorsDesigner.navigation.NavigationState;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;

public class GoToComponentsListAction implements Button.ClickListener {

    private final Navigator navigator;

    public GoToComponentsListAction(Navigator navigator )
    {
        this.navigator = navigator;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        navigator.navigateTo( NavigationState.Components.toString() );
    }
}
