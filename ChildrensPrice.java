public class ChildrensPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public double getCharge(int daysRented) {
        return calculateCharge(daysRented);
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }

    private double calculateCharge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3) {
            charge += (daysRented - 3) * 1.5;
        }
        return charge;
    }
}
