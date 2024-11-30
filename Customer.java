public class Customer {
    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental each : _rentals) {
            result.append("\t").append(each.getMovie().getTitle()).append("\t")
                  .append(each.getCharge()).append("\n");
        }

        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");

        for (Rental each : _rentals) {
            result.append(each.getMovie().getTitle()).append(": ")
                  .append(each.getCharge()).append("<BR>\n");
        }

        result.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        result.append("On this rental you earned <EM>")
              .append(getTotalFrequentRenterPoints())
              .append("</EM> frequent renter points<P>");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental each : _rentals) {
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : _rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}


    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : _rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
