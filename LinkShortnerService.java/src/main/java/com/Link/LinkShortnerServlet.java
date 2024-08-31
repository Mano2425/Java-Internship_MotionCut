package com.Link;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shorten")
public class LinkShortnerServlet extends HttpServlet {

    private LinkShortnerService linkShortnerService = new LinkShortnerService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String longUrl = request.getParameter("longUrl");
        String shortUrl = linkShortnerService.shortenURL(longUrl);
        request.setAttribute("shortUrl", shortUrl);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}
