package ru.geekbrains.hw1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/list")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);
    private Product[] products = {
            new Product(1, "Milk", 54),
            new Product(2, "Cheese", 540),
            new Product(3, "Sour cream", 69),
            new Product(4, "Meat", 300),
            new Product(5, "Sausage", 400),
            new Product(6, "Bread", 60),
            new Product(7, "Egg", 75),
            new Product(8, "Butter", 130),
            new Product(9, "Cottage cheese", 170),
            new Product(10, "Candies", 500),
    };

    // GET http://localhost:8080/firstapp/list
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        out.println("<html><body><h2>Products</h2></body></html>");
        for (int i=0; i<10; i++) {
            out.println("<html><body><h3>" +
                    String.format(" %d %s %d", products[i].getId(),
                            products[i].getTitle(), products[i].getCost()) + "</h3></body></html>");
        }
        out.close();
    }

}
