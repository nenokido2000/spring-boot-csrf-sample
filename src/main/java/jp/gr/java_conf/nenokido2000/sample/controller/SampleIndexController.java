package jp.gr.java_conf.nenokido2000.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>
 * CSRF対応確認画面表示用Controller
 * </pre>
 * 
 * @author naoki.enokido
 *
 */
@Controller
@RequestMapping(value = "/")
public class SampleIndexController {

    /**
     * <pre>
     * CSRF対応確認画面への遷移処理
     * </pre>
     * 
     * @return CSRF対応確認画面のパス文字列
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
