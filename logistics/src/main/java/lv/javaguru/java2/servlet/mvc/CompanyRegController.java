package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lv.javaguru.java2.database.CompanyDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.CompanyDAOImpl;
import lv.javaguru.java2.domain.Company;

/**
 * Created by andre on 17.02.2015.
 */
@Component
public class CompanyRegController implements MVCController {

    private CompanyDAO companyDAO = new CompanyDAOImpl();


    @Override
    public MVCModel processRequest(HttpServletRequest request,
                                   HttpServletResponse response) {
        if (request.getMethod().equals("POST"))
            System.out.println("Metod POST ispolzuetsa");
        else
            if (request.getMethod().equals("GET"))
                System.out.println("Metod GET ispolzuetsa");

        String name = request.getParameter("name");
        String regNumber = request.getParameter("regNumber");
        String regAddress = request.getParameter("regAddress");
        String actualAddress = request.getParameter("actualAddress");
        String bank = request.getParameter("bank");
        String iban = request.getParameter("iban");
        String country = request.getParameter("country");
        String type = request.getParameter("type");

        
        Company companyNew = new Company(name, regNumber, regAddress, actualAddress, bank, iban, country, type);

        try {
            companyDAO.create(companyNew);
        } catch (DBException e) {
            System.out.println("Exception while creating new company mvc/CompanyRegController");
            e.printStackTrace();
        }

//        String message = "New Company -" + name + "- created! :)";
//        MVCModel model = new MVCModel("/jsp/userreg.jsp", message);
        MVCModel model = new MVCModel("/jsp/companyreg.jsp", companyNew);
        return model;


    }
}

