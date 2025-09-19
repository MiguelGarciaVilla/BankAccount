package model;

public class BankAccount {
    protected float balance;
    protected int numConsignments;
    protected int numWithdrawals;
    protected float anunalRate;
    protected float monthlyCommission;


    public BankAccount(float balance, float anunalRate) {
        this.balance = balance;
        this.anunalRate = anunalRate;
        this.monthlyCommission = 0;
        this.numConsignments = 0;
        this.numWithdrawals = 0;

    }

    @Override
    public String toString() {
        return "\nSaldo en la cuenta: "+balance+"\nNumero de consignaciones: "+ numConsignments+"\nNumero de retiros: "
                +numWithdrawals+"\nInteres anual: "+anunalRate+"\nComision mensual: "+monthlyCommission;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getNumConsignments() {
        return numConsignments;
    }

    public void setNumConsignments(int numConsignments) {
        this.numConsignments = numConsignments;
    }

    public int getNumWithdrawals() {
        return numWithdrawals;
    }

    public void setNumWithdrawals(int numWithdrawals) {
        this.numWithdrawals = numWithdrawals;
    }

    public float getAnunalRate() {
        return anunalRate;
    }

    public void setAnunalRate(float anunalRate) {
        this.anunalRate = anunalRate;
    }

    public float getMonthlyCommission() {
        return monthlyCommission;
    }

    public void setMonthlyCommission(float monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }

    /**
     * Metodo para depositar dinero en una cuenta bancaria.
     * @param amount
     * @return
     */
    public String depositMoney(float amount) {
        String resultado = "Error el monto ingresado es incorrecto";
        if (amount > 0) {
            balance += amount;
            resultado= "Consignacion exitosa";
            numConsignments++;
        }
        return resultado;
    }

    /**
     * Metodo para retirar dinero de una cuenta bancaria.
     * @param amount
     * @return
     */
    public String withdrawMoney(float amount) {
        String result = "Error el monto a retirar es incorrecto";
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            result= "Operacion exitosa";
            numWithdrawals++;
        }
        return result;
    }

    /**
     * Metodo para obtener el interes mensual de una cuenta bancaria.
     * @return
     */
    public float monthlyInterest() {
        float monthlyInterest = balance * (anunalRate / 12);
        return  monthlyInterest;
    }

    /**
     * Metodo para obtener la comision mensual de una cuenta bancaria.
     * @return
     */
    public float monthlyComission(){
        float commission = balance * monthlyCommission;
        return commission;
    }

    /**
     * Metodo para generar el extracto de una cuenta bancaria, este metodo tambien actualiza el saldo de la cuenta bancaria con el interes y comision mensual.
     * @return
     */
    public String generateExtract(){
        String result= "Extracto generado con exito";
        balance += monthlyInterest();
        balance -= monthlyComission();
        return  result;
    }




}
