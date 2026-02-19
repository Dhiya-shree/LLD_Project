package src.design05_SplitWise_App.balance;

public class Balance {

    double owe;
    double lend;

    public Balance(double owe, double lend) {
        this.owe = owe;
        this.lend = lend;
    }

    public Balance() {
        owe=0;lend=0;
    }

    public double getOwe() {
        return owe;
    }

    public void setOwe(double owe) {
        this.owe = owe;
    }

    public double getLend() {
        return lend;
    }

    public void setLend(double lend) {
        this.lend = lend;
    }
}
