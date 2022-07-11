package bankAccount;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Users {

    public String name;
    public String password;
    public String dateOfBirth;
    public String marriageStatus;
    public String relativeName;
    public String relativeAge;
    public String isTransferedSuceesfully;
    public int accountNumber;
    public int amountAccount1;
    public int accountNumber2;
    public int amountAccount2;


    public Users(String name, String password, String dateOfBirth, String marriageStatus, int amountAccount1, int amountAccount2) {
        this.name = name;
        this.password = password;
        this.dateOfBirth = checkAge(dateOfBirth);
        this.marriageStatus = CheckMariageStatus(marriageStatus);
        this.amountAccount1 = amountAccount1;
        this.amountAccount2 = amountAccount2;
        this.accountNumber = randomNumberCreater();
        this.accountNumber2 = randomNumberCreater();
    }


    public String CheckMariageStatus(String marriageStatus) {
        Scanner sc = new Scanner(System.in);
        String don = "";

        if (marriageStatus.equalsIgnoreCase("Married")) {

            System.out.print("Do you want to add add your relative? (Yes/No): ");
            String answer = sc.nextLine();
            if (answer.equalsIgnoreCase("Yes")) {

                System.out.print("What is your relative's name?: ");
                String name = sc.nextLine();
                //partner.fullName=relativeName;

                System.out.print("What is your relative's date of birth?: ");
                String birth = sc.nextLine();
                // partner.age=relativeAge;
                this.relativeName = name;
                this.relativeAge = checkAge(birth);
                don = "Married";

            }
            if (answer.equalsIgnoreCase("No")) {
              don="Married";
            }
        } if (marriageStatus.equalsIgnoreCase("Single")) {don="Single";};

        return don;
    }

    public static String checkAge(String myDOB) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(myDOB, format);

        LocalDate today = LocalDate.now();

        Period difference = Period.between(date, today);

        int age = difference.getYears();

        if (age >= 18) {

            return myDOB;
        } else

            return "You should be at least 18 years old to get a credit card.";

      /*  LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String text = date.format(formatters);
        LocalDate today = LocalDate.parse(text, formatters);

        LocalDate myAge = LocalDate.parse(age, formatters);

        int num = today.compareTo(LocalDate.parse(age, formatters));

        String result ="";

        if(num>18){

            result = "You can get a credit card";

        }else if(num < 18){

            result = "You should be at least 18 years old to get a credit card.";

        } else if(num==18){

            if( today.getMonthValue()>myAge.getMonthValue()){

                result = "You can get a credit card";

            }else if(today.getMonthValue()<myAge.getMonthValue()){

                result = "You should be at least 18 years old to get a credit card.";

            }else if(today.getMonthValue()==myAge.getMonthValue()){

                if(today.getDayOfMonth()>myAge.getDayOfMonth()){

                    result = "You can get a credit card";

                }else {

                    result =  "You should be at least 18 years old to get a credit card.";
                }
            }
        }

        return result; */

    }

    public static int randomNumberCreater() {
        int hesapNo = (int) ((Math.random() * (99999999 - 10000000) + 1) + 10000000);

        return hesapNo;
    }

    @Override
    public String toString() {
        return "Name= " + name + "\nSurname= " + password + "\nDate of Birth= " + dateOfBirth +
                "\nMarital Status= " + this.marriageStatus + "\nYour Spouse's Name= " + relativeName + "\nYour Spouses's Birthday= " + relativeAge +
                "\nAccount Number= " + accountNumber + "\nBalance=" + amountAccount1 + "\nAccount Number 2= " + accountNumber2 +
                "\nBalance=" + amountAccount2;
    }

    public void transferDifferent(Users u1, Users u2, int transferAmount) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Do you want to transfer between your accounts or different user :");
        String cevap = sc.nextLine();

        System.out.print("How much do you want to transfer? : ");
        transferAmount = sc2.nextInt();


            Account.transferOtherUser(u1, u2, transferAmount);

        }




    public void transferOwn(Users u1, int transferAmount) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Do you want to transfer between your accounts or different user :");
        String cevap = sc.nextLine();

        System.out.print("How much do you want to transfer? : ");
        transferAmount = sc2.nextInt();

        Account.transferToOwnAccount(u1, transferAmount);


    }

}
