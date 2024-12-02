package AulaPraticaRefactoring.classes;

import java.util.Enumeration;
public abstract class Statement {
    abstract String setHeader(Customer aCustomer);

    abstract String setBody(Rental rental);

    abstract String setFooter(Customer aCustomer);

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = setHeader(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //show figures for each rental
            result += setBody(each);
        }
        //add footer lines
        result += setFooter(aCustomer);
        return result;
    }
}