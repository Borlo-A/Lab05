/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;
	List<Anagramma> anagrammiRisultato;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="btnVai"
    private Button btnVai; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorrect"
    private TextArea txtCorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtIncorrect"
    private TextArea txtIncorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) 
    {
    	txtInput.clear();
    	txtCorrect.clear();
    	txtIncorrect.clear();
    }

    @FXML
    void doVai(ActionEvent event) 
    {
    	txtCorrect.clear();
    	txtIncorrect.clear();
    	anagrammiRisultato = this.model.anagramma(txtInput.getText());
    	for (Anagramma a : anagrammiRisultato)
    	{
    		if (a.isCorrect())
    			txtCorrect.appendText(a.getWord()+ "\n");
    		
    		else
    			txtIncorrect.appendText(a.getWord() + "\n");
    	}
    }

    public void setModel(Model model) 
    {
    	this.model= model; 	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnVai != null : "fx:id=\"btnVai\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtIncorrect != null : "fx:id=\"txtIncorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";

    }


}
