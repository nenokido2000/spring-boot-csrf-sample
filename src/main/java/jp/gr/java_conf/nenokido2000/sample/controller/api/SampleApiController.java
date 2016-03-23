package jp.gr.java_conf.nenokido2000.sample.controller.api;

import jp.gr.java_conf.nenokido2000.sample.dto.ApiResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * CSRF対応サンプルAPI
 * </pre>
 * 
 * @author naoki.enokido
 *
 */
@RestController
@RequestMapping(value = "/api")
public class SampleApiController {

    /**
     * <pre>
     * GET要求を受け付けるIF
     * </pre>
     * 
     * @return 成功情報のJSON
     */
    @RequestMapping(method = RequestMethod.GET)
    public ApiResult sampleGet() {
        return new ApiResult("sample get called");
    }

    /**
     * <pre>
     * PUT要求を受け付けるIF
     * </pre>
     * 
     * @return 成功情報のJSON
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ApiResult samplePut() {
        return new ApiResult("sample put called");
    }
}
