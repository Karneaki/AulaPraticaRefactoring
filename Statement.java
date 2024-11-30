public class Statement {
    protected abstract String startResult(Customer aCustomer);
      protected abstract String getFigures(Rental aRental);
      protected abstract String endResult(Customer aCustomer);
  
      public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = startResult(aCustomer);
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           result += getFigures(each);
        }
        result += endResult(aCustomer);
        return result;
     }
  } 