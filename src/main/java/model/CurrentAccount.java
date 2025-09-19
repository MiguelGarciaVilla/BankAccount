package model;

import static java.lang.Math.abs;

public class CurrentAccount extends BankAccount{
    protected float sobregiro;

    public CurrentAccount(float balance, float anunalRate) {
        super(balance, anunalRate);
        this.sobregiro = 0;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    /**
     * Metodo para retirar dinero de la cuenta corriente, sin embargo es posible retirar una cantidad mayor al saldo, una vez que el retiro supere el saldo de la cuenta el resto sera almacenado como sobrecosto.
     * @param amount
     * @return
     */
    public String withdrawMoney(float amount) {
        String result = "Error el monto a retirar es incorrecto";
        if (amount > 0) {
            balance -= amount;
            result= "Operacion exitosa";
        }

        if(balance < 0){
            sobregiro+= abs(balance); //Guarda la cantidad negativa del saldo como un valor a pagar en el sobregiro.
            balance = 0; //Se establece el balance en cero una vez se actualize el sobregiro.
        }
        return result;
    }

    /**
     * Metodo para depositar dinero en la cuenta corriente, este primero actualiza el sobre costo y luego si es necesario, el saldo.
     * @param amount
     * @return
     */
    public String depositMoney(float amount) {
        String result = super.depositMoney(amount);
        if(sobregiro > 0){ //Se verifica si se debe cobrar el sobregiro.
            sobregiro -= amount; //Resta el valor al sobregiro
            balance -= amount;//Se debe restar el mismo valor al saldo, ya que al llamar el metodo "super.depositMoney()" se esta sumando este valor al saldo, esto ocacionara una duplicacion del saldo a depositar.
            if(sobregiro < 0){ //Se verifica si el sobregiro ha sido totalmente solventado.
                balance += abs(sobregiro); //Se suma el valor restante al saldo si es necesario.
            }
        }
        return result;
    }

}
