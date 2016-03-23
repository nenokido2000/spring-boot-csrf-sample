package jp.gr.java_conf.nenokido2000.sample.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

/**
 * <pre>
 * API通信に対してCSRFトークンをCookieで設定するためのFilter
 * </pre>
 * 
 * @author naoki.enokido
 *
 */
public class CsrfCookieFilter extends OncePerRequestFilter {

    /** CookieにCSRFを設定する際の名称 */
    private static final String CSRF_COOKIE_NAME = "_ctkn";

    /** CookieにCSRFを設定する際の有効範囲 */
    private static final String CSRF_COOKIE_PATH = "/";

    /*
     * { @inheritDoc }
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                .getName());

        if (csrf != null) {
            final String token = csrf.getToken();
            Cookie cookie = WebUtils.getCookie(request, CSRF_COOKIE_NAME);
            if (cookie == null || token != null
                    && !token.equals(cookie.getValue())) {
                cookie = new Cookie(CSRF_COOKIE_NAME, token);
                cookie.setPath(CSRF_COOKIE_PATH);
                response.addCookie(cookie);
            }
        }

        filterChain.doFilter(request, response);
    }
}