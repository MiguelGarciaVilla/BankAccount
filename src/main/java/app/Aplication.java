package app;

import model.BankAccount;
import model.CurrentAccount;
import model.SaveAccount;

public class Aplication {
    public static void main(String[] args) {
        SaveAccount cuentaAhorros= new SaveAccount(10000, 0.2f);
        cuentaAhorros.setMonthlyCommission(0.1f); //Se asigna un valor a la comision mensual para que al generar la misma no de cero.
        cuentaAhorros.depositMoney(5000); //Deposita 5000 correctamente y el saldo se actualiza a 15000.
        cuentaAhorros.withdrawMoney(1000); //Retira 1000 correctamente y el saldo se actualiza a 14000.
        cuentaAhorros.withdrawMoney(1000); //Retira 1000 correctamente y el saldo se actualiza a 13000.
        cuentaAhorros.withdrawMoney(1000); //Retira 1000 correctamente y el saldo se actualiza a 12000.
        cuentaAhorros.withdrawMoney(1000); //Retira 1000 correctamente y el saldo se actualiza a 11000.
        cuentaAhorros.withdrawMoney(20000);//No se retiran 20000 correctamente ya que supera el valor supera el saldo entonces el saldo de queda en 11000.
        cuentaAhorros.withdrawMoney(2000); //Retira 2000 correctamente y el saldo se actualiza a 9000, sin embargo al la cuenta se va a desactivar porque el saldo bajo de 10000 y no se podran realizar mas trnasacciones.

        System.out.println(cuentaAhorros.toString()); //Saldo en la cuenta: 9000, Comision mensual: 1900 (900 de comision fija mas 1000 por 1 transaccion superior a las 4), Numero de transacciones: 6.

        System.out.println(cuentaAhorros.generateExtract());// Al generar el extracto se actualiza el saldo restando la comision mensual y sumando el interes mensual, finalmente dice el estado de su cuenta, en este caso sera desactivado.





    }
}
