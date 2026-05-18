package kr.jongyeol.springstudy.study.week2;

import org.springframework.stereotype.Service;

@Service
public class TextTransformService {
    public String upper(String text) {
        // TODO
        return text.toUpperCase();      
        
    }

    public String lower(String text) {
        // TODO
        return text.toLowerCase();
    }

    public String reverse(String text) {
        // TODO
        return new StringBuilder(text).reverse().toString();
    }

    public int length(String text) {
        // TODO
        return text.length();
    }

    public String replace(ReplaceRequest request) {
        // TODO
        String to = request.to() == null ? "" : request.to();
        return request.text().replace(request.from(), to);
    }

    public int wordCount(String text) {
        // TODO
        return text.trim().split("\\s+").length;
    }

    public String trim(String text) {
        // TODO
        return text.trim();
    }

    public String mask(String text) {
        // TODO
        int len = text.length();
        if (len <= 4) {
            return "*".repeat(len);
        }
        return text.substring(0, 2) + "*".repeat(len - 4) + text.substring(len - 2);
    }

    public String repeat(RepeatRequest request) {
        // TODO
        return request.text().repeat(request.times());
        }

    public boolean palindrome(String text) {
        // TODO
        return text.equals(new StringBuilder(text).reverse().toString());
    }
}