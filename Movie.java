public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    /**
     * Calcula o valor de aluguel baseado no código de preço e no número de dias alugados.
     * @param daysRented O número de dias alugados.
     * @return O valor a ser cobrado pela locação.
     */
    public double getCharge(int daysRented) {
        double charge = 0;

        switch (_priceCode) {
            case REGULAR:
                charge += 2;
                if (daysRented > 2) {
                    charge += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                charge += daysRented * 3;
                break;
            case CHILDRENS:
                charge += 1.5;
                if (daysRented > 3) {
                    charge += (daysRented - 3) * 1.5;
                }
                break;
        }

        return charge;
    }
}
