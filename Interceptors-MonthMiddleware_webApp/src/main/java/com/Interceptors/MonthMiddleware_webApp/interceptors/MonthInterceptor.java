package com.Interceptors.MonthMiddleware_webApp.interceptors;

import com.Interceptors.MonthMiddleware_webApp.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public static List<Month> months = new ArrayList<>(Arrays.asList(
                new Month(3, "March", "Marzo", "März"),
                new Month(4, "April", "Aprile", "April"),
                new Month(5, "May", "Maggio", "Mai"),
                new Month(6, "June", "Giugno", "Juni"),
                new Month(11, "November", "Novembre", "November"),
                new Month(12, "December", "Dicembre", "Dezember")
    ));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null || monthNumberHeader.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid monthNumber header: monthNumber header is missing or empty");
            // alternativa: response.setStatus(400);
            return false;
        } else {

            int monthNumber;

            try {
                monthNumber = Integer.parseInt(monthNumberHeader);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid monthNumber header: monthNumber must be an integer");
                return false;
            }

            Month monthFound = months.stream().filter(month -> month.getMonthNumber() == monthNumber)
                    .findFirst()
                    .orElse(new Month(monthNumber, "nope", "nope", "nope"));

            request.setAttribute("monthAttribute", monthFound);
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

    }

}