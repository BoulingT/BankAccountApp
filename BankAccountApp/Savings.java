import java.util.Random;
public class Savings extends Account {
// extends means the class wil inherite from the "Account" class
    // List properties specific to a checking account
    private int safetyDepositBoxId;
    private int safetyDepositBoxKey;
    final double rateForSavings = 0.25;

    // Constructor to initialise setttings for savings properties
    public Savings(String name, String ssn, String typeOfAccount, double initDeposit){
        super(name, ssn, typeOfAccount, initDeposit); // "super" refers to the super constructor in this case the class "Account"
        setSafetyDepositBox();
    }

    // SHOW INFO METHOD RELATIVE TO SAVINGS ACCOUNTS
    public void showInfo(){
        super.showInfo();
        System.out.println("- SAVINGS' ACCOUNT INFORMATIONS:\n" +
        "   SAFETY DEPOSIT BOX ID: " + this.safetyDepositBoxId +
        "\n   SAFETY DEPOSIT BOX KEY: " + this.safetyDepositBoxKey +
        "\n   RATE: " + super.rate + "%");
    }

    // Method to implement rate
    @Override
    public void setRate(){
        rate = getBaseRate() - rateForSavings;
    }

    // START FUNCTIONS TO CREATE SAFETY DEPOSIT BOX
    private void setSafetyDepositBox(){
        setSafetyDepositBoxId();
        setSafetyDepositBoxAccessKey();
    }
    // Function to create safetydepositebox id with 3 digit number
    private void setSafetyDepositBoxId(){
        this.safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
    }
    // Function to create safetydepositbox access code with a 4 digit code
    private void setSafetyDepositBoxAccessKey(){
        Random random = new Random();
        int random1 = random.nextInt(10);
        int random2 = random.nextInt(10);
        int random3 = random.nextInt(10);
        int random4 = random.nextInt(10);
        this.safetyDepositBoxKey = Integer.parseInt("" + random1 + random2 + random3 + random4);
    } // END FUNCTIONS TO CREATE SAFETY DEPOSIT BOX
}