/*
 * Copyright (C) 2013 Dominik Schadow, dominikschadow@gmail.com
 *
 * This file is part of the Java Security Myths project.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dominikschadow.myths;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Basic unprotected servlet for GET and POST requests. Prints out some command line information and returns the
 * received parameter as response.
 *
 * @author Dominik Schadow
 */
@WebServlet(name = "CSRFServlet", urlPatterns = {"/CSRFServlet"})
public class CSRFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        System.out.println("Unprotected: Processing GET request");

        String name = request.getParameter("name");
        System.out.println("Unprotected: Received " + name + " as GET parameter");

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("Received " + name + " as GET parameter");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        System.out.println("Unprotected: Processing POST request");

        String name = request.getParameter("name");
        System.out.println("Unprotected: Received " + name + " as POST parameter");

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("Received " + name + " as POST parameter");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
