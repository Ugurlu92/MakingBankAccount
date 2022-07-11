package bankAccount;

import java.util.Scanner;

public class Account {



    public static int deposit (int accountAmount , int amountToAdd) {
        return amountToAdd+accountAmount;

    }

    public static int withDraw (int accountAmount , int withdrawAmount) {
        return accountAmount-withdrawAmount;

    }

    public static String transferOtherUser (Users sendingUser, Users receivingUser, int transferAmount) {
        Scanner sc=new Scanner(System.in);
        String donus="";


        if (transferAmount > sendingUser.amountAccount1) {donus="Sender is poor lol :)"; }
        if (transferAmount < sendingUser.amountAccount1)
        {

            sendingUser.amountAccount1-=transferAmount+(transferAmount*0.02);
            receivingUser.amountAccount1+=transferAmount;
            donus="Transaction is completed successfully";
        }
        return donus;
    }
    public static String transferToOwnAccount (Users sendingUser, int transferAmount) {
        String donus="";
        if (transferAmount > sendingUser.amountAccount1) {donus="You need more money dude :)"; }
        if (transferAmount < sendingUser.amountAccount1)
        {
            sendingUser.amountAccount1-=transferAmount;
            sendingUser.amountAccount2+=transferAmount;
            donus="Transaction is completed successfully";
        }
        return donus;


    }




}












