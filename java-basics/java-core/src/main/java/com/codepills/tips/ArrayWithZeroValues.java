package com.codepills.tips;

import java.util.Arrays;

import com.codepills.BankAccount;

public class ArrayWithZeroValues {

    private void showCodePrimitiveDouble() {
        double[] treePrimitiveDoubles = new double[3];
        double zeroElementPrimitive = treePrimitiveDoubles[0];
        System.out.print(zeroElementPrimitive);
    }


    private void showCodeReferenceDouble() {
        Double[] treeReferenceDoubles = new Double[3];
        Double zeroElementReference = treeReferenceDoubles[0];
        System.out.print(zeroElementReference);
    }

    private void showCodeFillArrayLoop() {
        BankAccount[] arrayOfAllBankAccounts = new BankAccount[50];
        for(int i = 0; i < arrayOfAllBankAccounts.length; i++) {
            arrayOfAllBankAccounts[i] = new BankAccount();
        }
    }

    private void showCodeFillArrayArraysMethod() {
        BankAccount[] arrayOfAllBankAccounts = new BankAccount[50];
        Arrays.fill(arrayOfAllBankAccounts, new BankAccount());
    }

}
