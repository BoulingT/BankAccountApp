import java.util.Random;

public class Checking extends Account {
    // List properties for Savings account
    private String debitCardNumber = "";
    final int debitCardNumberLength = 12;
    private int debitCardPin;
    final static double rateForChecking = 0.15;


    // Constructor to initialise a checking account
    public Checking(String name, String ssn, String typeOfAccount, double initDeposit) {
        super(name, ssn, typeOfAccount, initDeposit);
        setDebitCard();
    }
    // Method to implement rate
    @Override
    public void setRate(){
        rate = getBaseRate() * rateForChecking;

    }    

    public void showInfo(){
        super.showInfo();
        System.out.println("- CHECKING'S ACCOUNT INFORMATIONS:\n" +
        "   DEBIT CARD NUMBER: " + this.debitCardNumber +
        "\n   DEBIT CARD PIN: " + this.debitCardPin +
        "\n   RATE: " + super.rate + "%");
        }

    // START FUNCTIONS TO CREATE A DEBIT CARD
    private void setDebitCard(){
        setDebitCardNumber();
        setDebitCardPin();
    }
        // Function to generate a debit card number
    private void setDebitCardNumber(){
        //this.debitCardNumber = (int) Math.random() * Math.pow(10, 12);
        Random randomNum = new Random();
        for (int i = 0; i <= this.debitCardNumberLength; i++){
            int num = randomNum.nextInt(10);
            this.debitCardNumber += num;
        }
    }
        // Function to generate a debit card PIN number
    private void setDebitCardPin(){
        this.debitCardPin = (int) (Math.random() * Math.pow(10, 4));
    } // END FUNCTIONS TO CREATE DEBIT CARD
}