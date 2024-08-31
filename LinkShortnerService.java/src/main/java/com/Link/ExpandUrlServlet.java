package com.Link;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/expand")
public class ExpandUrlServlet extends HttpServlet {

    private LinkShortnerService linkShortenerService = new LinkShortnerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shortUrl = request.getParameter("shortUrl");
        String longUrl = linkShortenerService.expandURL(shortUrl);
        request.setAttribute("longUrl", longUrl);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}

