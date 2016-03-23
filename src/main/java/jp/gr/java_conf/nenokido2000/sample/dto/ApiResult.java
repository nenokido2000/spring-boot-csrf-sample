package jp.gr.java_conf.nenokido2000.sample.dto;

/**
 * <pre>
 * サンプルAPIの成功情報を格納するDTO
 * </pre>
 * 
 * @author naoki.enokido
 *
 */
public class ApiResult {

    /** 成功メッセージ */
    private String message;

    /**
     * <pre>
     * コンストラクタ
     * </pre>
     * 
     * @param message
     *            成功メッセージ
     */
    public ApiResult(final String message) {
        this.message = message;
    }

    /**
     * <pre>
     * 成功メッセージを返却します。
     * </pre>
     * 
     * @return 成功メッセージ
     */
    public String getMessage() {
        return message;
    }
}
