package controllers;

import com.example.wal.MainWAL;
import com.example.wal.MyEventListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import models.Drug;

public class ItemController {

    @FXML
    private ImageView drugImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Drug drug;

    private MyEventListener myEventListener;

    @FXML
    private void click(MouseEvent mouseEvent){
        myEventListener.onClickListener(drug);
    }

    public void setData( Drug drug , MyEventListener myEventListener){

        this.drug = drug;

        this.myEventListener = myEventListener;

        nameLabel.setText(drug.getName());
        priceLabel.setText(MainWAL.currency + drug.getPrice());

        Image image = new Image(getClass().getResourceAsStream(drug.getImgSrc()));

        drugImage.setImage(image);
    }
}
