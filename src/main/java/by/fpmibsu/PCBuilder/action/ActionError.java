package by.fpmibsu.PCBuilder.action;

import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletResponse;

public class ActionError {
    private static final int DEFAULT_STATUS = 999;
    private static final String DEFAULT_HEADER_TEXT = "some error happened";
    private static final String DEFAULT_HEADER = "errorType";
    public static void sendError(@NotNull HttpServletResponse r, int status, String text) {
        r.setHeader(DEFAULT_HEADER, text);
        r.setStatus(status);
    }
    public static void sendError(@NotNull HttpServletResponse r, int status, String headerName, String headerText) {
        r.setHeader(headerName, headerText);
        r.setStatus(status);
    }
    public static void sendError(@NotNull HttpServletResponse r, String headerName, String headerText) {
        r.setHeader(headerName, headerText);
        r.setStatus(DEFAULT_STATUS);
    }
    public static void sendError(@NotNull HttpServletResponse r, int status) {
        r.setHeader(DEFAULT_HEADER, DEFAULT_HEADER_TEXT);
        r.setStatus(status);
    }
    public static void sendError(@NotNull HttpServletResponse r) {
        r.setHeader(DEFAULT_HEADER, DEFAULT_HEADER_TEXT);
        r.setStatus(DEFAULT_STATUS);
    }
    public static void sendError(@NotNull HttpServletResponse r,  String text) {
        r.setHeader(DEFAULT_HEADER, text);
        r.setStatus(DEFAULT_STATUS);
    }
}

