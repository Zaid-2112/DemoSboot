package com.aai.firstproject.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

@Component
public class RequestResponseLogger implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //Logger logger = null;

        MyCustomHttpRequestWrapper requestWrapper = new MyCustomHttpRequestWrapper((HttpServletRequest) request);

        String uri = requestWrapper.getRequestURI();
        //logger.info("Request URI: {}" + uri);
        //logger.info("Request Method: {}" + requestWrapper.getMethod());
        /*String requestResult = new String(requestWrapper.getByteArray()).replaceAll("\n"," ");
        if ("/category/".equalsIgnoreCase(uri)) {
            Category category = objectMapper.readValue(requestResult, Category.class);
            category.setDescription("****");
            requestResult = objectMapper.writeValueAsString(category);
        } else if ("/hsn/".equalsIgnoreCase(uri)) {
            Hsn hsn = objectMapper.readValue(requestResult, Hsn.class);
            hsn.setIntegratedTax(0);
            requestResult = objectMapper.writeValueAsString(hsn);
        }
        log.info("Request Body: {}", requestResult);*/
        //logger.info("Request Body: {}" + new String(requestWrapper.getByteArray()).replaceAll("\n"," "));

        MyCustomHttpResponseWrapper responseWrapper = new MyCustomHttpResponseWrapper((HttpServletResponse) response);
        chain.doFilter(requestWrapper, responseWrapper);

        //logger.info("Response Status: {}" + responseWrapper.getStatus());
        /*String responseResult =  new String(responseWrapper.getBaos().toByteArray()).replaceAll(",", ",    ");
        if ("/category/".equalsIgnoreCase(uri)) {
            Category category = objectMapper.readValue(responseResult, Category.class);
            category.setDescription("****");
            responseResult = objectMapper.writeValueAsString(category);
        } else if ("/hsn/".equalsIgnoreCase(uri)) {
            Hsn hsn = objectMapper.readValue(responseResult, Hsn.class);
            hsn.setIntegratedTax(0);
            responseResult = objectMapper.writeValueAsString(hsn);
        }
        log.info("Response Body: {}", responseResult);*/
        //logger.info("Response Body: {}" + new String(responseWrapper.getBaos().toByteArray()).replaceAll(",", ",    "));

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    }

    private class MyCustomHttpRequestWrapper extends HttpServletRequestWrapper {

        private byte[] byteArray;

        public byte[] getByteArray() {
            return byteArray;
        }

        public MyCustomHttpRequestWrapper(HttpServletRequest request) {
            super(request);
            try {
                byteArray = IOUtils.toByteArray(request.getInputStream());
            } catch (IOException ioException) {
                throw new RuntimeException("Problem reading the request stream");
            }
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new MyDelegatingServletInputStream(new ByteArrayInputStream(byteArray));
        }


    }

    private class MyCustomHttpResponseWrapper extends HttpServletResponseWrapper {

        private ByteArrayOutputStream baos = new ByteArrayOutputStream();

        public ByteArrayOutputStream getBaos() {
            return baos;
        }

        private PrintStream printStream = new PrintStream(baos);

        public MyCustomHttpResponseWrapper(HttpServletResponse response) {
            super(response);

        }

        @Override
        public ServletOutputStream getOutputStream() throws IOException {
            return new MyDelegatingServletOutputStream(new TeeOutputStream(super.getOutputStream(), printStream));
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(new TeeOutputStream(super.getOutputStream(), printStream));
        }
    }
}
