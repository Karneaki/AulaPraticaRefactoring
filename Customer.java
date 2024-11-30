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
       double totalAmount = 0;
       int frequentRenterPoints = 0;
       StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
       
       for (Rental each : _rentals) {
          // Calcula o valor para esta locação
          double thisAmount = amountFor(each);
 
          // Adiciona pontos de locador frequente
          frequentRenterPoints++;
          if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
             frequentRenterPoints++;
          }
 
          // Exibe os valores para esta locação
          result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
          totalAmount += thisAmount;
       }
 
       // Adiciona as linhas de rodapé
       result.append("Amount owed is ").append(totalAmount).append("\n");
       result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
       return result.toString();
    }
 
    /**
     * Calcula o valor devido para uma locação específica.
     */
    private double amountFor(Rental each) {
       double thisAmount = 0;
 
       switch (each.getMovie().getPriceCode()) {
          case Movie.REGULAR:
             thisAmount += 2;
             if (each.getDaysRented() > 2) {
                thisAmount += (each.getDaysRented() - 2) * 1.5;
             }
             break;
          case Movie.NEW_RELEASE:
             thisAmount += each.getDaysRented() * 3;
             break;
          case Movie.CHILDRENS:
             thisAmount += 1.5;
             if (each.getDaysRented() > 3) {
                thisAmount += (each.getDaysRented() - 3) * 1.5;
             }
             break;
       }
 
       return thisAmount;
    }
 }
 