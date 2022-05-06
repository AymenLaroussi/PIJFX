package boutique.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import boutique.main.MyListener;
import entities.Produit;
import java.io.File;

/**
 *
 * @author Aymen Laroussi
 */
public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(produit);
    }

    private Produit produit;
    private MyListener myListener;
    float total;
    String total1;
    float stq;

    public void setData(Produit produit, MyListener myListener) {
        this.produit = produit;
        this.myListener = myListener;
        nameLabel.setText(produit.getTitre());
        
        float promo=produit.getPromo() ;
        if (promo != 0){
            total = (produit.getPromo()*produit.getPrix())/100;
            if(total == (long) total)
                total1=String.format("%d",(long)total);
         else
                total1 =String.format("%s",total);
        }
        else{
            total=produit.getPrix(); 
        }
        priceLable.setText( total1+" TND");
             String A = "C:\\Pi\\public\\uploads\\"+produit.getImage();
                                          File F1 = new File(A);
                                           Image image = new Image(F1.toURI().toString());
//        Image image = new Image(getClass().getResourceAsStream(produit.getImgSrc()));
        img.setImage(image);
    }
}
