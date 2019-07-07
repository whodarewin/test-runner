package com.hc.test.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by congcong.han on 2019/7/7.
 */
public class ResponseUtil {
    public static void setJsonMeta(HttpServletResponse resp){
        resp.setHeader("content-type","application/json");
    }

    public static void setUTF_8Meta(HttpServletResponse resp){
        resp.setCharacterEncoding("utf-8");
    }

    public static void setUTF_8Meta(HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
    }
}
