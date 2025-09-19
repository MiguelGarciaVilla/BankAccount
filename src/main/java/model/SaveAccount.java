package model;

public class SaveAccount extends BankAccount{
    protected boolean status;

    public SaveAccount(float balance, float anunalRate) {
        super(balance, anunalRate);
        if(balance < 10000) { //Se verifica si la cuenta inicialmente esta activa o deshabilitada.
            status = false;
        }else{
            status = true;
        }
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Metodo para depositar dinero en la cuenta de ahorros, sin embargo verifica que la cuenta este activa.
     * @param amount
     * @return
     */
    public String depositMoney(float amount) {
        String resultado = "Error, su cuenta esta inactiva";
        if (status == true) {  //Si la cuenta llega a bajar de 10000 nunca mas se podra volver a consignar dinero.
            resultado= super.depositMoney(amount);
        }
        return resultado;
    }

    /**
     * Metodo para retirar dinero de la cuenta de ahorros, sin embargo solo modificara el saldo si la cuenta esta activa.
     * @param amount
     * @return
     */
    public String withdrawMoney(float amount) {
        String resultado = "Error, su cuenta esta inactiva";
        if (status == true) {  //Si la cuenta llega a bajar de 10000 nunca mas se podra volver a consignar ni retirar dinero.
            resultado= super.withdrawMoney(amount);
        }
        return resultado;
    }

    /**
     * Metodo que calcula la comision mensual, habra un sobre costo superior si se superan 4 retiros, cada retiro despues del limite (4 retiros) tendra un sobre costo de 1000 para la comision mensual.
     * @return
     */
    public float monthlyComission() {
        float result = super.monthlyComission();
        if (numWithdrawals > 4) {
            float withdrawsExtraValue = (numWithdrawals - 4) * 1000;
            result += withdrawsExtraValue;
        }
        return result;
    }

    /**
     * Metodo para generar el extracto de la cuenta de ahorros, luego de que se modifica el saldo de la cuenta se verifica si puede seguir estando activa o debe ser desabilitada.
     * @return
     */
    public String generateExtract(){
        String result = "Extracto generado con exito";
        balance += monthlyInterest();
        balance -= monthlyComission();

        if(balance < 10000){
            status = false;
            result= "Su cuenta se ha desactivado";
        }
        result += ", el saldo en su cuenta es de: "+balance;
        return result;
    }

    public String toString(){ //A diferencia del metodo toString de la clase padre (retorna todos los atributos) este solo retorna unos datos especificos.
        return "\nSaldo en la cuenta: "+ balance+"\nComision mesual: "+monthlyComission()+"\nNumero de transacciones: "+(numWithdrawals+numConsignments);
    }












}
