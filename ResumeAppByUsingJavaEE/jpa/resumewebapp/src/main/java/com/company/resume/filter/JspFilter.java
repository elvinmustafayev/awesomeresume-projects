package com.company.resume.filter;


import java.io.IOException;
import java.util.logging.Filter;


@WebFilter(filterName = "JSPFileFilter",urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {



    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
         HttpServletResponse res =(HttpServletResponse )response;
         try {

                 res.sendRedirect("error?msg=not found");

         } catch (IOException e) {
             e.printStackTrace();
         }

     }




}
