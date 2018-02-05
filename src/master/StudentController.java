package master;
import javax.swing.*;
import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class StudentController implements Initializable{
    @FXML
    private JFXTextField adminNotxt, Fnamet, Snamet, oNamet, regionNt,Nation, pFName1, pFName2, pSName1, pSName2, pOName1, pOName2;
    @FXML
    private JFXButton next;
    @FXML
    private Button uploadBtn, delBtn;
    @FXML
    private JFXDatePicker dateOfBirth,dateOfReg;
    @FXML
    private ImageView imageView;
    @FXML
    private Image image;
    @FXML
    private Pane stdImg;
    @FXML
    private ComboBox<String> gender,religion;



    public void nextAction(){
             String firstname = Fnamet.getText().trim();
             String  othername = oNamet.getText();
             String surname = Snamet.getText();


             System.out.println(firstname + " "+  surname + " " + othername );
    }

    public void upload(){
        /*
        if this button is clicked then the windows folder will popup to prompt user to show the location of the image,
        dimension of the image will be set automatically if does not fit.

        if the upload is sucessful then the upload button should change to "change photo"

*/
        //System.out.println(Nation.getText());
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("image files (*.png* *.jpeg*)", "*.png","*.jpeg"));
        File file= fc.showOpenDialog(null);
         image= new Image(file.toURI().toString(),200,200,true,true);
         imageView = new ImageView(image);
         imageView.setFitWidth(200);
         imageView.setFitHeight(200);
         imageView.setPreserveRatio(false);
         stdImg.getChildren().add(imageView);


        if(imageView != null){
            uploadBtn.setText("Change");
         }


    }

    public void delete(){
        /*// create a popup message that will ask a user to confirm, the deletion of his/her photo

        method , if photo present then delete it and the upload button change from change to upload
        else if photo not present then do nothing
    */
        uploadBtn.setText("Upload");
        stdImg.getChildren().remove(imageView);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list = FXCollections.observableArrayList("M","F");

        gender.setItems(list);
        ComboBox<String> religion=new ComboBox<>(FXCollections.observableArrayList("chriatiN","muslim"));

    }
}
