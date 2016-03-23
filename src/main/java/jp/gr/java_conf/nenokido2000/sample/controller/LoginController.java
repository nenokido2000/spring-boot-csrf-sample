package jp.gr.java_conf.nenokido2000.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>
 * ログイン画面表示用Controller
 * </pre>
 * 
 * @author naoki.enokido
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /**
     * <pre>
     * ログイン画面への遷移処理
     * </pre>
     * 
     * @return ログイン画面のパス文字列
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    /**
     * <pre>
     * ログインエラー画面への遷移処理
     * </pre>
     * 
     * @return ログインエラー画面のパス文字列
     */
    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String error() {
        return "login-error";
    }
}
