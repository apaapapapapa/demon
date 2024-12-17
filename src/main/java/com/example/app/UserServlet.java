package com.example.app;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // フォームデータの取得
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // レスポンス設定
        response.setContentType("text/html; charset=UTF-8");

        // 入力値のバリデーション
        if (username == null || username.trim().isEmpty()) {
            response.getWriter().write("<div class='text-red-500'>ユーザー名を入力してください。</div>");
            return;
        }

        if (password == null || password.length() < 6) {
            response.getWriter().write("<div class='text-red-500'>パスワードは6文字以上で入力してください。</div>");
            return;
        }

        // バリデーション成功時のレスポンス
        response.getWriter().write("<div class='text-green-500 font-semibold'>"
                + "ユーザー名: " + username + " で送信されました。</div>");
    }
}
