package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 19.02.2015.
 */
public class VehiclePageController implements MVCController {
    @SuppressWarnings("UnnecessaryLocalVariable")
    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String lol = ":)";

        MVCModel model = new MVCModel("/jsp/vehicles.jsp", lol);

        return model;
    }
}
