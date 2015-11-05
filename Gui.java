package assignment4;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by JMG on 11/3/2015.
 */
public class Gui extends Driver{
    Food selection;
    public Gui()
    {
    }
    public Scene setBase()
    {
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10,50,50,50));
        vb.setSpacing(10);
        Label lbl = new Label("ADMIN");
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setPadding(new Insets(5));
        grid1.setHgap(10);
        grid1.setVgap(10);

        Button buttonImportT = new Button("Import from .TXT");
        Button buttonImportX = new Button("Import from .XLS");
        Button buttonImportJ = new Button("Add new entry");
        buttonImportT.setMinWidth(150);
        buttonImportX.setMinWidth(150);
        buttonImportJ.setMinWidth(150);
        GridPane.setConstraints(buttonImportT, 0, 0);
        GridPane.setConstraints(buttonImportX, 1, 0);
        GridPane.setConstraints(buttonImportJ, 2, 0);
        grid1.getChildren().add(buttonImportT);
        grid1.getChildren().add(buttonImportX);
        grid1.getChildren().add(buttonImportJ);
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(5));
        grid2.setHgap(10);
        grid2.setVgap(10);

        Button buttonExportT = new Button("Export to .TXT");
        Button buttonExportX = new Button("Export to .XLS");
        buttonExportT.setMinWidth(230);
        buttonExportX.setMinWidth(230);
        GridPane.setConstraints(buttonExportT, 0, 0);
        GridPane.setConstraints(buttonExportT, 1, 0);
        grid2.getChildren().add(buttonExportT);
        grid2.getChildren().add(buttonExportX);
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setPadding(new Insets(5));
        grid3.setHgap(10);
        grid3.setVgap(10);

        Button buttonSearch = new Button("Search");
        Button buttonViewAll = new Button("View all items");
        Button buttonViewCategory = new Button("View categories");
        buttonSearch.setMinWidth(150);
        buttonViewAll.setMinWidth(150);
        buttonViewCategory.setMinWidth(150);
        GridPane.setConstraints(buttonSearch, 0, 0);
        GridPane.setConstraints(buttonViewAll, 1, 0);
        GridPane.setConstraints(buttonViewCategory, 2, 0);
        grid3.getChildren().add(buttonSearch);
        grid3.getChildren().add(buttonViewAll);
        grid3.getChildren().add(buttonViewCategory);
        Button buttonExit = new Button("Exit");

        vb.getChildren().add(lbl);
        vb.getChildren().add(grid1);
        vb.getChildren().add(grid2);
        vb.getChildren().add(grid3);
        vb.getChildren().add(buttonExit);

        buttonImportT.setOnAction(event -> newFoodItemFromTxt()
        );
        buttonImportX.setOnAction(event -> newFoodItemFromExcel()
        );
        buttonImportJ.setOnAction(event -> window.setScene(gui.setInput("Add Data",new Food("")))
        );
        buttonSearch.setOnAction(event -> window.setScene(gui.setList("search"))
        );
        buttonViewAll.setOnAction(event -> window.setScene(gui.setList("name"))
        );
        buttonViewCategory.setOnAction(event -> window.setScene(gui.setList("name"))
        );
        buttonExit.setOnAction(event -> Platform.exit()
        );

        return new Scene(vb);
    }
    public Scene setList(String filter)
    {
        //newFoodItemFromTxt();
        Queue q = list.traversal(BST.Order.INORDER);
        //int qi = q.getIndexOf(focus);


        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10,50,50,50));
        vb.setSpacing(10);

        Label lbl = new Label();
        if(filter.contains("name")) {
            lbl.setText("View All");
        }
        else if(filter.contains("search")) {
            lbl.setText("Search All Records");
        }
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));

        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setPadding(new Insets(5));
        grid1.setHgap(10);
        grid1.setVgap(10);

        Label lSearch = new Label("Search:");
        lSearch.setAlignment(Pos.CENTER_RIGHT);
        TextField tSearch = new TextField();
        lSearch.setMinWidth(230);
        tSearch.setMinWidth(230);
        GridPane.setConstraints(lSearch, 0, 0);
        GridPane.setConstraints(tSearch, 1, 0);
        grid1.getChildren().add(lSearch);
        grid1.getChildren().add(tSearch);

        ListView<String> listview;
        listview = new ListView<>();
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listview.setMinWidth(470);

        //create list / update values
        if(!list.isEmpty()) {
            for (int i=0;i<q.inQueue();i++){
                listview.getItems().add(((Food)q.dequeue()).name);
            }
            /*
                    if (filter.contains("name") || filter.contains("search") ||(filter.contains("specific") && catName[i].contains(selected)))
                    {
                        if(i>0)
                        {
                            catindex[i] = items.length+catindex[i-1];
                        }
                        else
                        {
                            catindex[i]=items.length;
                        }
                        for (String item : items) {
                            listview.getItems().add(item);
                        }
                    }*/
        }
        else //null categories
        {
            listview.getItems().add("");
            System.out.println("ERROR IN LISTVIEW CATEGORIES: INVALID SUBORDINATES");
        }

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(5));
        grid2.setHgap(10);
        grid2.setVgap(10);
        Button buttonReturn = new Button("Return");
        Button buttonDelete = new Button("Delete");
        Button buttonSelect = new Button("Select");
        buttonReturn.setMinWidth(150);
        buttonDelete.setMinWidth(150);
        buttonSelect.setMinWidth(150);
        GridPane.setConstraints(buttonReturn, 0, 0);
        GridPane.setConstraints(buttonDelete, 1, 0);
        GridPane.setConstraints(buttonSelect, 2, 0);
        grid2.getChildren().add(buttonReturn);
        grid2.getChildren().add(buttonDelete);
        grid2.getChildren().add(buttonSelect);

        vb.getChildren().add(lbl);
        vb.getChildren().add(grid1);
        vb.getChildren().add(listview);
        vb.getChildren().add(grid2);

        EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>()
        {
            private boolean willConsume = false;
            @Override
            public void handle(KeyEvent event)
            {
                if (willConsume)
                {
                    event.consume();
                    listview.getItems().clear();
                    if(!list.isEmpty()) {
                        Queue q = list.traversal(BST.Order.INORDER);

                        for (int i = 0; i < q.inQueue(); i++) {
                            if(((Food) q.getElement(i)).name.contains(tSearch.getText())){
                                listview.getItems().add(((Food)q.getElement(i)).name);
                            }
                        }
                    }
                }
                if (event.getEventType() == KeyEvent.KEY_PRESSED)
                {
                    willConsume = true;
                    int cPos = tSearch.getCaretPosition();
                    String bText = tSearch.getText().substring(0, cPos);
                    String aText = tSearch.getText().substring(cPos,tSearch.getText().length());
                    if (event.getCode().isLetterKey())
                    {
                        tSearch.setText(bText + event.getText() + aText);
                        tSearch.positionCaret(cPos+1);
                    }
                }
                else if (event.getEventType() == KeyEvent.KEY_RELEASED)
                {
                    willConsume = false;
                }
            }
        };

        tSearch.addEventFilter(javafx.scene.input.KeyEvent.ANY, handler);
        buttonReturn.setOnAction(event -> {
                    window.setScene(base);
                    selected = null;
                }
        );
        buttonDelete.setOnAction(event -> {
                        /*if (selected==null) {
                            boolean found=false;
                            for (int i = 0; i < catindex.length; i++) {
                                if(listview.getSelectionModel().getSelectedIndex()<catindex[i] && !found){
                                    selected=catName[i];
                                    found=true;
                                }
                            }
                        }*/
                        System.out.println(selected);
                        System.out.println(listview.getSelectionModel().getSelectedItem());
                        list.remove(listview.getSelectionModel().getSelectedItem());
                        listview.getItems().remove(listview.getSelectionModel().getSelectedIndex());
                }
        );
        buttonSelect.setOnAction(event -> {
                        selected = listview.getSelectionModel().getSelectedItem();
                        window.setScene(setInput("view/update", (Food) list.contains(selected)));
                }
        );

        return new Scene(vb);
    }
    public Scene setInput(String header,Food focus) {
        Queue q = list.traversal(BST.Order.INORDER);
        int qi = q.getIndexOf(focus);

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10, 50, 50, 50));
        vb.setSpacing(10);

        Label lbl = new Label(header);////////////////HEADER
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        //{
            GridPane grid1 = new GridPane();
            grid1.setAlignment(Pos.CENTER);
            grid1.setPadding(new Insets(5));
            grid1.setHgap(10);
            grid1.setVgap(10);

            Button buttonPrevious = new Button("PREVIOUS");
            Button buttonReturn = new Button("RETURN");
            Button buttonNext = new Button("NEXT");
            buttonPrevious.setMinWidth(150);
            buttonReturn.setMinWidth(150);
            buttonNext.setMinWidth(150);
            GridPane.setConstraints(buttonPrevious, 0, 0);
            GridPane.setConstraints(buttonReturn, 1, 0);
            GridPane.setConstraints(buttonNext, 2, 0);
            grid1.getChildren().setAll(buttonPrevious, buttonReturn, buttonNext);
        //}
        //{
            GridPane grid2 = new GridPane();
            grid2.setAlignment(Pos.CENTER);
            grid2.setPadding(new Insets(5));
            grid2.setHgap(10);
            grid2.setVgap(10);

            Label lName = new Label("Name:");
            Label lPrice = new Label("Price:");
            Label lQuantity = new Label("Quantity:");
            Label lDescription = new Label("Description:");
            Label lSize = new Label("Size:");
            Label lSpecialOrder = new Label("SpecialOrder:");

            TextField tName = new TextField();
            TextField tPrice = new TextField();
            TextField tQuantity = new TextField();
            TextField tDescription = new TextField();
            TextField tSize = new TextField();
            TextField tSpecialOrder = new TextField();

            tName.setText(focus.getName());
            tPrice.setText(focus.getPrice());
            tQuantity.setText(focus.getQuantity());
            tDescription.setText(focus.getDescription());
            tSize.setText(focus.getSize());
            tSpecialOrder.setText(focus.getSpecialOrder());

            lName.setMinWidth(100);
            lPrice.setMinWidth(100);
            lQuantity.setMinWidth(100);
            lDescription.setMinWidth(100);
            lSize.setMinWidth(100);
            lSpecialOrder.setMinWidth(100);
            lName.setAlignment(Pos.CENTER_RIGHT);
            lPrice.setAlignment(Pos.CENTER_RIGHT);
            lQuantity.setAlignment(Pos.CENTER_RIGHT);
            lDescription.setAlignment(Pos.CENTER_RIGHT);
            lSize.setAlignment(Pos.CENTER_RIGHT);
            lSpecialOrder.setAlignment(Pos.CENTER_RIGHT);

            tName.setMinWidth(360);
            tPrice.setMinWidth(360);
            tQuantity.setMinWidth(360);
            tDescription.setMinWidth(360);
            tSize.setMinWidth(360);
            tSpecialOrder.setMinWidth(360);

            GridPane.setConstraints(lName, 0, 0);
            GridPane.setConstraints(lPrice, 0, 1);
            GridPane.setConstraints(lQuantity, 0, 2);
            GridPane.setConstraints(lDescription, 0, 3);
            GridPane.setConstraints(lSize, 0, 4);
            GridPane.setConstraints(lSpecialOrder, 0, 5);
            GridPane.setConstraints(tName, 1, 0);
            GridPane.setConstraints(tPrice, 1, 1);
            GridPane.setConstraints(tQuantity, 1, 2);
            GridPane.setConstraints(tDescription, 1, 3);
            GridPane.setConstraints(tSize, 1, 4);
            GridPane.setConstraints(tSpecialOrder, 1, 5);

            grid2.getChildren().add(lName);
            grid2.getChildren().add(lPrice);
            grid2.getChildren().add(lQuantity);
            grid2.getChildren().add(lDescription);
            grid2.getChildren().add(lSize);
            grid2.getChildren().add(lSpecialOrder);
            grid2.getChildren().add(tName);
            grid2.getChildren().add(tPrice);
            grid2.getChildren().add(tQuantity);
            grid2.getChildren().add(tDescription);
            grid2.getChildren().add(tSize);
            grid2.getChildren().add(tSpecialOrder);
        //}
        //{
            GridPane grid3 = new GridPane();
            grid3.setAlignment(Pos.CENTER);
            grid3.setPadding(new Insets(5));
            grid3.setHgap(10);
            grid3.setVgap(10);

            Button buttonUpdate = new Button("UPDATE");
            Button buttonAdd = new Button("ADD");
            Button buttonDelete = new Button("DELETE");
            buttonUpdate.setMinWidth(150);
            buttonAdd.setMinWidth(150);
            buttonDelete.setMinWidth(150);
            GridPane.setConstraints(buttonUpdate, 0, 0);
            GridPane.setConstraints(buttonAdd, 1, 0);
            GridPane.setConstraints(buttonDelete, 2, 0);
            grid3.getChildren().setAll(buttonUpdate, buttonAdd, buttonDelete);
        //}
        vb.getChildren().addAll(lbl,grid1,grid2,grid3);

        //toggle directions due to a null entry)
        if ((Food)list.contains(focus)==null){
            buttonPrevious.setDisable(true);
            buttonNext.setDisable(true);
        } else { //toggle directions based on values
            buttonPrevious.setDisable(qi > 0);
            buttonNext.setDisable(qi < q.inQueue());
        }

        buttonPrevious.setPrefWidth(100);
        buttonPrevious.setOnAction(event -> {
                    if (qi>0) window.setScene(setInput(header,(Food)q.getElement(qi-1)));
                }
        );

        buttonNext.setPrefWidth(100);
        buttonNext.setOnAction(event -> {
                    if (qi<q.inQueue()) window.setScene(setInput(header,(Food)q.getElement(qi+1)));
                }
        );

        buttonUpdate.setPrefWidth(100);
        buttonUpdate.setOnAction(event -> {
                    System.out.println(tName.getText());
                    list.remove(focus);
                    list.add(new Food
                        (
                            tName.getText(),
                            tPrice.getText(),
                            tQuantity.getText(),
                            tDescription.getText(),
                            tSize.getText(),
                            tSpecialOrder.getText()
                        )
                    );
                }
        );

        buttonAdd.setPrefWidth(100);
        buttonAdd.setOnAction(event -> {
                    list.add(new Food
                        (
                            tName.getText(),
                            tPrice.getText(),
                            tQuantity.getText(),
                            tDescription.getText(),
                            tSize.getText(),
                            tSpecialOrder.getText()
                        )
                    );
                    if (buttonPrevious.isDisabled()) buttonPrevious.setDisable(false);
                }
        );

        buttonDelete.setPrefWidth(100);
        buttonDelete.setOnAction(event -> {
                    list.remove(focus);
                }
        );
        buttonReturn.setPrefWidth(100);
        buttonReturn.setOnAction(event -> {
                    window.setScene(base);
                    selected = null;
                }
        );

        return new Scene(vb);
    }
}
