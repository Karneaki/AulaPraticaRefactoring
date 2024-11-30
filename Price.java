public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
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
        double charge = 2;
        if (daysRented > 2) {
            charge += (daysRented - 2) * 1.5;
        }
        return charge;
    }
}
