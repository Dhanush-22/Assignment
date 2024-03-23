import java.util.Scanner;


record MileObj(double mileValue){};


class RewardValue{
    
    private double cashValue;
    private MileObj mileObj;

    RewardValue(double cashValue){
        this.cashValue = cashValue;
    }

    RewardValue(MileObj mileObj){ // Assumed data type of mileValue as an Object, Need more info about the type of mielObj.
        this.mileObj = new MileObj(mileObj.mileValue());
    }

    // miles to cash at a rate of 0.0035.
    double getCashValue(){
        return this.mileObj.mileValue()*0.0035;
    }

    double getMilesValue(){
        return this.cashValue/0.0035;
    }
}

public class RewardsConverter {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Please enter a cash value to convert to airline miles: ");
        var input_value = scanner.nextLine();

        double cashValue;
        
        try {
            cashValue = Double.parseDouble(input_value);
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse input value as a double, exiting");
            return;
        }

        System.out.println("converting $" + input_value + " to miles");
        
        var rewardsValue = new RewardValue(cashValue);
        
        System.out.println("$" + input_value + " is worth " + rewardsValue.getMilesValue() + " miles");

    }
}