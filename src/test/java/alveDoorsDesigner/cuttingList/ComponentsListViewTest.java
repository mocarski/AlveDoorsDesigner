package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.cuttingList.table.action.FillTableAction;
import alveDoorsDesigner.cuttingList.table.action.SetTableTitleAction;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(EasyMockRunner.class)
public class ComponentsListViewTest {

    @Mock
    SetTableTitleAction setTableTitleAction;

    @Mock
    FillTableAction fillTableAction;

    @Test
    public void name() throws Exception {

    }

    //    @Test
//    public void whenComponentsListViewEnter_ThenExecuteSetTableTitleAction() throws Exception {
//        ComponentsListView view = createComponentsListView();
//        setTableTitleAction.execute();
//        replay(setTableTitleAction);
//
//        view.enter(null);
//
//        verify(setTableTitleAction);
//    }
//
//    private ComponentsListView createComponentsListView() {
//
//        Label tableTitle = new Label();
//        TableOfIntermediates table = TableOfIntermediates.createWardrobeIntermediates();
//
//        Navigator navigation = null;
//        Wardrobe wardrobe = new Wardrobe();
//        Button backButton = BackButton.createWardrobeIntermediates(new GoToDoorDesigningAction(navigation));
//        Button downloadButton = DownloadButton.createWardrobeIntermediates(new DownloadPdfExtension(wardrobe));
//        Button printButton = PrintButton.createWardrobeIntermediates(new OpenPdfExtension(wardrobe));
//
//        return new ComponentsListView(tableTitle, table, backButton, printButton, downloadButton,
//                setTableTitleAction, fillTableAction, wardrobe);
//    }
}