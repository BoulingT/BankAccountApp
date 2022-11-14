import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class BankAccountApp {
    //static boolean otherOperation = true;
    public static void main (String[] args){
        /* Checking chkacc1 = new Checking("Tom Wilson", "1987654321", 30000, "checking");
        Savings savacc1 = new Savings("Lee Dowson","1234567891", 40000, "savings");
        chkacc1.showInfo();
        System.out.println("********");
        savacc1.showInfo(); */

        // CREATE A LIST OF ACCOUNT
        ArrayList<Account> accountList = new ArrayList<>();

        // Read a CSV file and create account based on the data
        File f = new File("/Users/bouling/Documents/Formations/JAVA/Projects/BankAccountApp/NewBankAccounts.csv");
        List<String[]> newAccountHolder = utilities.CSV.read(f);
        // CREATE AN OBJECT FOR EVERY CUSTOMER AND ADD TO THE ACCOUNT LIST
        for(String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String typeOfAccount = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            setTypeOfAccount(typeOfAccount, name, ssn, initDeposit, newAccountHolder, accountList);
            showInfoOfAllAccounts(accountList);
        }
        // ASK  AND EXECUTE FOR OPERATIONS DESIRED
        boolean otherOperation = true;
        while (otherOperation){
            Account accountFound = findAccount(accountList);
            if (accountFound.equals(null)){
                System.out.println("Error: No account found.");
            }
            else {
                makeOperations(accountFound);
                otherOperation = otherOperationMethod();
            }
        }
    }
    // ASK IF ANOTHER OPERATION IS DESIRED
    public static boolean otherOperationMethod(){
        Scanner othOperation = new Scanner(System.in);
        System.out.println("Do you want to make another operation: ");
        String wannaMakeAnotherOperation = othOperation.nextLine();
        if (wannaMakeAnotherOperation.equalsIgnoreCase("no")){return false;}
        else {return true;}
    }
    //EXECUTE OPERATION
    public static void makeOperations(Account accountFound){
        boolean correctInputOperation = false;
        while (!correctInputOperation){
             correctInputOperation = setOperation(accountFound);
            //correctInputOperation = false;
        }
    }
    // DETERMINE WHIXH OPERATION TO EXECUTE
    public static boolean setOperation(Account accountFound){
        double inputAmount;
        String whichOperation;
        Scanner operationInput = new Scanner(System.in);
        Scanner moneyInput = new Scanner(System.in);
        System.out.println("Operations: -Transfert -withdraw -deposit -show info");
        System.out.print("What do you wish to do: ");
        whichOperation = operationInput.nextLine();
        if (whichOperation.equalsIgnoreCase("transfert")){
            System.out.print("How money do you wish to transfert ? ");
            inputAmount = moneyInput.nextInt();
            System.out.print("To where do you wish to transfert: ");
            String inputToWhere = operationInput.nextLine();
            accountFound.transfer(inputToWhere, inputAmount);
            return true; 
        }
        else if (whichOperation.equalsIgnoreCase("withdraw")){
            System.out.print("How money do you wish to withdraw ? ");
            inputAmount = moneyInput.nextInt();
            accountFound.withdraw(inputAmount);
            return true;
        }
        else if (whichOperation.equalsIgnoreCase("deposit")){
            System.out.print("How money do you wish to deposit ? ");
            inputAmount = moneyInput.nextInt();
            accountFound.deposit(inputAmount);
            return true;
        }
        else if (whichOperation.equalsIgnoreCase("show info")){
            accountFound.showInfo();
            return true;
        }
        else { 
            System.out.println("Error: try again");
            return false;}
    }
    // ASK AND SEARCH FOR THE ACCOUNT TO OPERATE ON
    public static Account findAccount(ArrayList<Account> accountList){
        System.out.print("Enter account number: ");
            Scanner strInput = new Scanner(System.in);
            String accountNumberInput = strInput.nextLine();
            for (Account acc : accountList){ // look find first
                if (acc.getAccountNumber().equalsIgnoreCase(accountNumberInput)){
                    return acc;
                }
            }
        return null;
    }

    // SET ACCOUNT TYPE
    public static void setTypeOfAccount(String typeOfAccount, String name, String ssn, double initDeposit, List newAccountHolder, ArrayList accountList){
        if (typeOfAccount.equalsIgnoreCase("checking")) {
            Checking chkacc = new Checking(name, ssn, typeOfAccount, initDeposit);
            accountList.add(chkacc);

        } else if (typeOfAccount.equalsIgnoreCase("savings")){
            Savings savacc = new Savings(name, ssn, typeOfAccount, initDeposit);
            accountList.add(savacc);
        }
    }
    // SHOW ACCOUNT INFOS
    public static void showInfoOfAllAccounts(ArrayList<Account> accountLists){
        for (Account acc : accountLists){
            System.out.println("\n*********");
            acc.showInfo();
        }
    }
}
