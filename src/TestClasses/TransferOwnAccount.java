package TestClasses;

import bankAccount.Account;
import bankAccount.Users;

import java.time.LocalTime;

public class TransferOwnAccount {



    public static void main(String[] args) throws InterruptedException {

        Users u1 = new Users("Steve" , "Gerard",
                "01/01/2000", "Married",
                1000 , 2000);



        u1.transferOwn(u1, 0);

       Account ownAccount=new Account();

        System.out.println(ownAccount.transferToOwnAccount(u1, 0));

        int counter=5;

        while (counter>=0) {
            System.out.print("\rYour account report is getting prepared... " + counter);
            counter--;
            Thread.sleep(1000);

        }
        System.out.println();
        System.out.println("*****************************");
        System.out.println(u1.toString());





//        u1.amountAccount1==901;
//        u1.amountAccount2==2099;

        /*
      Do you want to add add your relative?
        Yes
        What is your relative name?
        gerry
        Date of birth relative?
        11/11/2002
        Do you want to transfer between your accounts or different user
        own
        Enter amount of money you want to enter
        100
         */


        /*

        Result should be:
        name: Steven
        password: Gerard
        dateOfBirth: You can get a credit card
        marriageStatus: Relative should be more then 18 years old
        accountNumber: 77650360
        amount in account 1 : 901
        accountNumber2: 95990730
        amount in account 2 : 2099
        relativeName: Relative should be more then 18 years old
        relativeAge: Relative should be more then 18 years old

         */


    }



}
