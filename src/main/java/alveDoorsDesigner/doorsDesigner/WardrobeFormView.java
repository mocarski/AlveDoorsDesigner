package alveDoorsDesigner.doorsDesigner;

import alveDoorsDesigner.doorsDesigner.cavityDimention.CavityHeight;
import alveDoorsDesigner.doorsDesigner.cavityDimention.CavityWidth;
import alveDoorsDesigner.doorsDesigner.cavityDimention.NumberOfDoors;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightsForDoorLayoutGenerator;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateFulfillmentHeightTextFieldsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.action.UpdateValidityOfFulfillmentHeightsAction;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.action.CreateFulfillmentTypeSelectsAction;
import alveDoorsDesigner.doorsDesigner.numberOfDivisions.action.CreateNumberOfDivisionFieldsAction;
import alveDoorsDesigner.doorsDesigner.positioning.PositioningOptionsView;
import alveDoorsDesigner.doorsDesigner.numberOfDivisions.NumberOfDivisionsView;
import alveDoorsDesigner.doorsDesigner.fulfillmentHeight.FulfillmentHeightView;
import alveDoorsDesigner.doorsDesigner.fulfillmentType.FulfillmentTypeView;
import alveDoorsDesigner.doorsDesigner.cavityDimention.CavityDimentionView;
import alveDoorsDesigner.doorsDesigner.positioning.action.CreatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.positioning.action.UpdatePositioningOptionsAction;
import alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour.DoorFrameColourSelect;
import alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour.ReferenceName;
import alveDoorsDesigner.doorsDesigner.referenceNameAndDoorFrameColour.ReferenceNameDoorFrameColourView;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.BottomTrackCoverSelect;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.TopTrackFacioSelect;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.TrackFacioTrackCoverView;
import alveDoorsDesigner.doorsDesigner.trackFacioAndTrackCover.action.UpdateAvailableColorsAction;
import alveDoorsDesigner.doorsDesigner.visibility.UpdateVisibility;
import alveDoorsDesigner.doorsDesigner.visualization.VisualizationView;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualization;
import alveDoorsDesigner.doorsDesigner.visualization.action.UpdateVisualizationWhenCorrectModuleHeights;
import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.navigation.action.GoToComponentsListAction;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


public class WardrobeFormView extends VerticalLayout implements View {

    public WardrobeFormView(VisualizationView visualizationView,
                            ReferenceNameDoorFrameColourView referenceNameDoorFrameColourView,
                            CavityDimentionView cavityDimentionView,
                            NumberOfDivisionsView numberOfDivisionsView,
                            FulfillmentHeightView fulfillmentHeightView,
                            FulfillmentTypeView fulfillmentTypeView,
                            PositioningOptionsView positioningOptionsView,
                            TrackFacioTrackCoverView topTrackFacioSelect,
                            Button previewListButton) {
        addComponents(visualizationView, referenceNameDoorFrameColourView, cavityDimentionView,
                numberOfDivisionsView, fulfillmentHeightView, fulfillmentTypeView, positioningOptionsView,
                topTrackFacioSelect, previewListButton);
        setComponentAlignment(visualizationView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(referenceNameDoorFrameColourView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(cavityDimentionView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(numberOfDivisionsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(fulfillmentHeightView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(fulfillmentTypeView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(positioningOptionsView, Alignment.MIDDLE_CENTER);
        setComponentAlignment(topTrackFacioSelect, Alignment.MIDDLE_CENTER);
        setComponentAlignment(previewListButton, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }

    public static WardrobeFormView create(Navigator navigator, Wardrobe wardrobe) {
        VisualizationView visualizationView = new VisualizationView(wardrobe);

        ReferenceName referenceName = new ReferenceName(wardrobe);
        DoorFrameColourSelect doorFrameColourSelect = new DoorFrameColourSelect(wardrobe);
        ReferenceNameDoorFrameColourView referenceNameDoorFrameColourView = new
                ReferenceNameDoorFrameColourView(referenceName, doorFrameColourSelect);

        FormLayout formLayout = new FormLayout();
        formLayout.setSizeUndefined();
        formLayout.setMargin(false);
        CavityHeight cavityHeight = new CavityHeight(wardrobe);
        CavityWidth cavityWidth = new CavityWidth(wardrobe);
        NumberOfDoors numberOfDoors = new NumberOfDoors(wardrobe);

        CavityDimentionView cavityDimentionView = new CavityDimentionView( new Label(Constants
                .CAVITY_DIMENTIONS), formLayout, cavityHeight, cavityWidth, numberOfDoors);
        NumberOfDivisionsView numberOfDivisionsView = new NumberOfDivisionsView(wardrobe, new HorizontalLayout());
        FulfillmentHeightView fulfillmentHeightView = new FulfillmentHeightView(wardrobe);
        HorizontalLayout fulfillmentSelectsForAllDoorsLayout = new HorizontalLayout();
        fulfillmentSelectsForAllDoorsLayout.setWidthUndefined();
        FulfillmentTypeView fulfillmentTypeView = new FulfillmentTypeView(wardrobe, fulfillmentSelectsForAllDoorsLayout);

        HorizontalLayout positioningOptionsLayout = new HorizontalLayout();
        PositioningOptionsView positioningOptionsView = new PositioningOptionsView(wardrobe, positioningOptionsLayout);
        TopTrackFacioSelect topTrackFacioSelect = new TopTrackFacioSelect(wardrobe);
        BottomTrackCoverSelect bottomTrackCoverSelect = new BottomTrackCoverSelect(wardrobe);
        TrackFacioTrackCoverView trackFacioTrackCoverView = new TrackFacioTrackCoverView
                (topTrackFacioSelect, bottomTrackCoverSelect);

        PreviewListButton previewListButton = new PreviewListButton(new GoToComponentsListAction(navigator));

        //Create actions
        CreateFulfillmentTypeSelectsAction createFulfillmentTypeSelectsAction = new CreateFulfillmentTypeSelectsAction(fulfillmentTypeView);
        UpdateVisualization updateVisualization = new UpdateVisualization(visualizationView);
        UpdateVisualizationWhenCorrectModuleHeights updateVisualizationWhenCorrectModuleHeights = new
                UpdateVisualizationWhenCorrectModuleHeights(visualizationView, fulfillmentHeightView);
        UpdateFulfillmentHeightTextFieldsAction updateFulfillmentHeightTextFieldsAction = new UpdateFulfillmentHeightTextFieldsAction
                (fulfillmentHeightView);
        UpdateValidityOfFulfillmentHeightsAction updateValidityOfFulfillmentHeightsAction = new UpdateValidityOfFulfillmentHeightsAction
                (fulfillmentHeightView);
        UpdateAvailableColorsAction updateAvailableColorsAction = new UpdateAvailableColorsAction
                (topTrackFacioSelect, bottomTrackCoverSelect);
        UpdateVisibility updateVisibility = new UpdateVisibility(visualizationView, referenceName,
                cavityDimentionView, numberOfDivisionsView, fulfillmentHeightView,
                fulfillmentTypeView, positioningOptionsView, trackFacioTrackCoverView, previewListButton );
        CreatePositioningOptionsAction createPositioningOptionsAction = new CreatePositioningOptionsAction
                (positioningOptionsView);
        UpdatePositioningOptionsAction updatePositioningOptionsAction = new UpdatePositioningOptionsAction
                (positioningOptionsView);

        //Set actions
        referenceName.addValueChangeListener(updateVisibility);
        doorFrameColourSelect.addValueChangeListener(updateAvailableColorsAction);;

        cavityHeight.setActions( updateVisibility, updateVisualization, updateFulfillmentHeightTextFieldsAction);

        cavityWidth.setActions(updateVisibility, updateVisualization, updatePositioningOptionsAction);

        numberOfDoors.setActions(updateVisibility, updateVisualization, new CreateNumberOfDivisionFieldsAction
                        (numberOfDivisionsView), createFulfillmentTypeSelectsAction,
                createPositioningOptionsAction);

        numberOfDivisionsView.setActions(updateVisibility, createFulfillmentTypeSelectsAction,
                updateFulfillmentHeightTextFieldsAction, updateVisualization);

        FulfillmentHeightsForDoorLayoutGenerator fulfillmentHeightsForDoorLayoutGenerator =
                new FulfillmentHeightsForDoorLayoutGenerator
                        (updateVisualizationWhenCorrectModuleHeights, updateVisibility, updateValidityOfFulfillmentHeightsAction);
        fulfillmentHeightView.setActions(updateVisibility, fulfillmentHeightsForDoorLayoutGenerator);


        WardrobeFormView wardrobeFormView = new WardrobeFormView(visualizationView,
                referenceNameDoorFrameColourView,
                cavityDimentionView, numberOfDivisionsView, fulfillmentHeightView, fulfillmentTypeView,
                positioningOptionsView,trackFacioTrackCoverView, previewListButton);

        return wardrobeFormView;
    }
}
