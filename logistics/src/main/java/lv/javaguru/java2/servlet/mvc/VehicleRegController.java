package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Created by user on 17.02.2015.
 */
@Component
public class VehicleRegController implements MVCController {
    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {

       String lol = ":)";

        MVCModel model = new MVCModel("/jsp/vehiclereg.jsp", lol);

        return model;
    }
}
