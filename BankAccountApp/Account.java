import java.util.Random;

public abstract class Account implements IBaseRate {
// abstract means we'll not be able to create object fom this class

    // List common propreties for savings & checking accounts
    private String name;
    private String ssn;
    private String accountNumber;
    private String accountType;
    static int index = 10000;
    protected double balance;
    protected double rate;
    
    // Constructor to set base properties and initialise account
    public Account(String name, String ssn,String typeOfAccount, double initDeposit){
        this.name = name;
        this.ssn = ssn;
        this.balance = initDeposit;
        this.accountType = typeOfAccount;
        setAccountNumber();
        setRate();
    }

    // GETTER FOR ACCOUN NUMBER
    public String getAccountNumber(){
        return this.accountNumber;
    }
    
    // START OF FUNCTIONS TO GENERATE THE ACCOUNT NUMBER
        /* Account number : 11 digit
            1st  = 1 - ok / 5 unique digits - ok / 3 random digits - ok / last 2 digits of SSN - ok */
    private void setAccountNumber(){
        String firstDigit = returnAccountTypeNumber();
        String threeRandomDigit = returnRandomDigit();
        String lastTwoDigit = ssn.substring(ssn.length()-2, ssn.length());
        String fiveUniqueDigit = returnUpdatedAndConvertedIndex();
        this.accountNumber = firstDigit + threeRandomDigit + fiveUniqueDigit + lastTwoDigit;
    }
    private String returnAccountTypeNumber(){
        if (this.accountType.equalsIgnoreCase("checking")) {return "1";}
        else if (this.accountType.equalsIgnoreCase("savings")){return "2";}
        return "ERROR";
    }
    private String returnRandomDigit(){
        Random random = new Random();
        int random1 = random.nextInt(10);
        int random2 = random.nextInt(10);
        int random3 = random.nextInt(10);
        return random1 + "" + random2 + "" + random3;
    }
    private String returnUpdatedAndConvertedIndex(){
        int updatedIndex = Account.index++;
        return updatedIndex + "";
    } // END OF FUNCTIONS TO GENERATE THE ACCOUNT NUMBER

    // Set rate method
    public abstract void setRate();

    // Set method for compound interest
    public void compound(){
        double accruedInterest = this.balance * (rate/100);
        this.balance += accruedInterest;
        System.out.println("Accrued interest: " + accruedInterest);
    }

    // List common methods (deposit / withdraw / transfer / showinfo / ...)
        // Transfer()
    public void transfer(String toWhere, double amount){
        this.balance -= amount;
        System.out.println("Transfering " + amount + "$ to " + toWhere);
        printBalance();
    }
        // Deposit()
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
        // Witdraw()
    public void withdraw(double amount){
        this.balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
        // Print balance
    public void printBalance(){
        System.out.println("Your balance is: $" + this.balance);
    }
        // Showinfo()
            /* Should reveal relevant account infos & infos specific to the checking or savings account */
    public void showInfo(){
        System.out.println("NAME: " + this.name.toUpperCase());
        System.out.println("BALANCE: " + this.balance);
        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        System.out.println("ACCOUNT TYPE: " + this.accountType.toUpperCase());
    }

}
    
            

