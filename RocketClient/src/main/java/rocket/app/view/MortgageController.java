package rocket.app.view;

import java.net.URL;
import java.util.ResourceBundle;
import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController implements Initializable {

	private MainApp mainApp;
	
	@FXML private Label lblCreditsScore;
	@FXML private Label lblTerm;
	@FXML private Label lblIncome;
	@FXML private Label lblRate;
	@FXML private Label lblAmount;
	@FXML private Label lblDownPayment;
	@FXML private Label lblPayment;
	@FXML private Label lblExpenses;
	@FXML private Label lblHouseCost;
	@FXML private TextField txtIncome;
	@FXML private TextField txtExpenses;
	@FXML private TextField txtCreditScore;
	@FXML private TextField txtDownPayment;
	@FXML private TextField txtHouseCost;
	@FXML private TextField txtRate;
	@FXML private Label lblMortgagePayment;
	@FXML private Button btnPayment = new Button("Payment");
	@FXML private ComboBox cmbTerm;
	private int Term;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//lq.setdIncome(Double.parseDouble((txtIncome.getText())));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		//lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiTerm(Integer.parseInt(cmbTerm.getPromptText()));
		lq.setdRate(Double.parseDouble(txtHouseCost.getText()));
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		
		double dIncome = 0; //Change from 0 to whatever user enters in txtIncome
		//lq.setdIncome(dIncome);

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cmbTerm.getItems().add("15");
		cmbTerm.getItems().add("30");
	
	}
	
}