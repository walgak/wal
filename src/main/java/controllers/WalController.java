package controllers;

import com.example.wal.MainWAL;
import com.example.wal.MyEventListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import models.Drug;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WalController implements Initializable {
    @FXML
    private Button addToCart;

    @FXML
    private VBox selectedDrug;

    @FXML
    private ImageView selectedDrugImage;

    @FXML
    private Label selectedDrugName;

    @FXML
    private Label selectedDrugPrice;

    @FXML
    private GridPane grid;

    private Image image;

    private List<Drug> drugs = new ArrayList<>();

    private MyEventListener myEventListener;

    private List<Drug> getData(){
        List<Drug> drugs = new ArrayList<>();

        Drug drug;

        drug = new Drug();
        drug.setName("Panadol");
        drug.setPrice(200);
        drug.setImgSrc("/images/panadol.png");
        drug.setColor("#F8E3FF");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("ino");
        drug.setPrice(150);
        drug.setImgSrc("/images/ino.jpeg");
        drug.setColor("#82CD47");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("FreshOptic");
        drug.setPrice(150);
        drug.setImgSrc("/images/freshOptic.jpeg");
        drug.setColor("#2192FF");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("Paracitamol");
        drug.setPrice(300);
        drug.setImgSrc("/images/paracitamol.jpeg");
        drug.setColor("#2192FF");
        drugs.add(drug);

        drug.setName("Panadol");
        drug.setPrice(150);
        drug.setImgSrc("/images/ino.jpeg");
        drug.setColor("#bbbbbb");
        drugs.add(drug);


        drug = new Drug();
        drug.setName("Panadol");
        drug.setPrice(200);
        drug.setImgSrc("/images/panadol.png");
        drug.setColor("#F8E3FF");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("ino");
        drug.setPrice(150);
        drug.setImgSrc("/images/ino.jpeg");
        drug.setColor("#82CD47");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("FreshOptic");
        drug.setPrice(150);
        drug.setImgSrc("/images/freshOptic.jpeg");
        drug.setColor("#2192FF");
        drugs.add(drug);

        drug = new Drug();
        drug.setName("Paracitamol");
        drug.setPrice(300);
        drug.setImgSrc("/images/paracitamol.jpeg");
        drug.setColor("#2192FF");
        drugs.add(drug);



        return drugs;
    }

    private void setSelectedDrug(Drug drug){
        selectedDrugName.setText(drug.getName());
        selectedDrugPrice.setText(MainWAL.currency + drug.getPrice());

        this.image = new Image(getClass().getResourceAsStream(drug.getImgSrc()));

        selectedDrugImage.setImage(this.image);

        selectedDrug.setStyle(" -fx-background-color: " + drug.getColor() +
                ";\n    -fx-background-radius: 10;\n" +
                "    -fx-effect: dropShadow(three-pass-box,rgba(180,160,200,0.5),50.0,0.0,0.0,10.0);");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        drugs.addAll(getData());

        if(drugs.size() > 0){

            setSelectedDrug(drugs.get(0));

            myEventListener = new MyEventListener() {
                @Override
                public void onClickListener(Drug drug) {
                    setSelectedDrug(drug);
                }
            };
        }

        int row = 1;
        int column = 0;

            try {

                for (int i = 0; i < drugs.size(); i++){

                    FXMLLoader fxmlLoader = new FXMLLoader();

                    fxmlLoader.setLocation(getClass().getResource("/com/example/wal/item.fxml"));


                    AnchorPane anchorPane = fxmlLoader.load();

                    ItemController itemController = fxmlLoader.getController();

                    itemController.setData(drugs.get(i), myEventListener);

                    if(column == 3){

                        column = 0;
                        row++;
                    }

                    grid.add(anchorPane, column++, row);

                    //set grid item width
                    grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                    grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                    grid.setMinWidth(Region.USE_PREF_SIZE);

                    //set grid item height
                    grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                    grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                    grid.setMinHeight(Region.USE_PREF_SIZE);

                    GridPane.setMargin(anchorPane, new Insets(10));

                }
                } catch (IOException e) {
                throw new RuntimeException(e);
            }




    }
}