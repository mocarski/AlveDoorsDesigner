package alveDoorsDesigner;

import javax.servlet.annotation.WebServlet;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.navigation.NavigationState;
import alveDoorsDesigner.doorsDesigner.WardrobeFormView;
import alveDoorsDesigner.cuttingList.ComponentsListView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;


@Theme("mytheme")
public class Main extends com.vaadin.ui.UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Wardrobe wardrobe = new Wardrobe();
        Navigator navigator = new Navigator(this, this);

        WardrobeFormView wardrobeFormView = WardrobeFormView.create(navigator, wardrobe);
        ComponentsListView componentsListView = ComponentsListView.create(navigator, wardrobe);

        navigator.addView(NavigationState.Wardrobe.toString(), wardrobeFormView);
        navigator.addView(NavigationState.Components.toString(), componentsListView);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = Main.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
