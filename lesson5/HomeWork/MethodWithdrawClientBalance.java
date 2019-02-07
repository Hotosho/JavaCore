package lesson5.HomeWork;

public class MethodWithdrawClientBalance {
    public static void main(String[] args) {

        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "Pasza", "Katya"};
        int[] balance = {100, 500, 8432, 99, 12000, -50, 4346,900};

        System.out.println(withdraw(names, balance,"Ann", 100));

    }


    public static int  withdraw(String[] clients, int[] balances, String client, int amount){

        int clientIndex = 0;
        for (String cl : clients){
            if (cl == client){
                break;
            }
            clientIndex++;
        }

        if (amount <= balances[clientIndex]){
            return balances[clientIndex] -= amount;
        }else
            return -1;
    }
}
