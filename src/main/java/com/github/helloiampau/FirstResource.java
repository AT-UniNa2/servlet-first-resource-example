package com.github.helloiampau;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * telematics
 * Created by Pasquale Boemio <boemianrapsodi@gmail.com>
 * <p/>
 * 16 August 2014.
 */
public class FirstResource extends HttpServlet {
                                   //  Does nothing, because this is an abstract class.
  @Override
  public void init() {
    // Called by the servlet container to indicate to a servlet that the servlet is being placed into service.
    System.out.println("I'm the init() method");
  }

  @Override
  public void destroy() {
    // Called by the servlet container to indicate to a servlet that the servlet is being taken out of service.
    System.out.println("I'm the destroy() method");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    // Called by the server (via the service method) to allow a servlet to handle a GET request.
    System.out.println("I'm the doGet() method");

    response.setContentType("text/plain");
    try {
      PrintWriter responseWriter = response.getWriter();
      responseWriter.println("Here some data from the server:");

      String queryParameter = request.getParameter("parameter");
      if(queryParameter != null) {
        System.out.println("I've received \"" + queryParameter + "\" as query parameter!");
        responseWriter.println("your query parameter is " + queryParameter);
      }

      String bodyContent = this.readBody(request.getReader());
      if(!bodyContent.equals("")) {
        System.out.println("I've received \"" + bodyContent + "\" as body of request!");
        responseWriter.println("your request body is " + bodyContent);
      }

      response.setStatus(HttpServletResponse.SC_OK);
    } catch (IOException e) {
      e.printStackTrace();
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    // Called by the server (via the service method) to allow a servlet to handle a POST request.
    System.out.println("I'm the doPost() method");
  }

  @Override
  public void doPut(HttpServletRequest request, HttpServletResponse response) {
    // Called by the server (via the service method) to allow a servlet to handle a PUT request.
    System.out.println("I'm the doPut() method");
  }

  @Override
  public void doDelete(HttpServletRequest request, HttpServletResponse response) {
    // Called by the server (via the service method) to allow a servlet to handle a DELETE request.
    System.out.println("I'm the doDelete() method");
  }

  private String readBody(BufferedReader reader) throws IOException {
    StringBuilder builder = new StringBuilder();
    String aux;

    while ((aux = reader.readLine()) != null)
      builder.append(aux);

    return builder.toString();

  }

}
