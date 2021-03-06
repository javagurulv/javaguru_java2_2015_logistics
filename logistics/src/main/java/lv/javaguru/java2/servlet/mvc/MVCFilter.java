/*
package lv.javaguru.java2.servlet.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Component;
import lv.javaguru.java2.servlet.model.URL;

public class MVCFilter implements Filter {

    private static Logger logger = Logger.getLogger(MVCFilter.class.getName());
    
    private ApplicationContext springContext;
    
    private Map<String, MVCController> controllerMapping;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            springContext =
                    new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {
            logger.log(Level.INFO, "Spring context failed to start", e);
        }

        try {
            putControllersIntoMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MVCController getBean(Class clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    public void putControllersIntoMap() throws Exception {

        controllerMapping = new HashMap<String, MVCController>();
        for (Map.Entry<String,MVCController> entry : springContext.getBeansOfType(MVCController.class).entrySet()) {
            Class clas = entry.getValue().getClass();
            if(clas.isAnnotationPresent(Component.class) && clas.isAnnotationPresent(URL.class)) {
                String url = entry.getValue().getClass().getAnnotation(URL.class).value();
                controllerMapping.put(url, getBean(clas));
            }
        }
    }
    
    public void doFilter(ServletRequest request,
                         ServletResponse response) throws IOException, ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, 
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        String contextURI = req.getServletPath();

        if (controllerMapping.keySet().contains(contextURI)){

            MVCController controller = controllerMapping.get(contextURI);
            MVCModel model = controller.processRequest(req, resp);

            req.setAttribute("model", model.getData());

            ServletContext context = req.getServletContext();

            RequestDispatcher requestDispacher =
                    context.getRequestDispatcher(model.getView());
            requestDispacher.forward(req, resp);

        }
        else filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
*/
