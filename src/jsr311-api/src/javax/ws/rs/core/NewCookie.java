/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.php
 * See the License for the specific language governing
 * permissions and limitations under the License.
 */

/*
 * NewCookie.java
 *
 * Created on March 12, 2007, 5:08 PM
 *
 */

package javax.ws.rs.core;

import java.net.URI;
import java.util.regex.Matcher;

/**
 * Used to create a new HTTP cookie, transferred in a response.
 * @see <a href="http://www.ietf.org/rfc/rfc2109.txt">IETF RFC 2109</a>
 */
public class NewCookie extends Cookie {
    
    /**
     * Specifies that the cookie expires with the current application/browser session.
     */
    public static final int DEFAULT_MAX_AGE = -1;
    
    private String comment = null;
    private int maxAge = DEFAULT_MAX_AGE;
    private boolean secure = false;
    
    /**
     * Create a new instance.
     * @param name the name of the cookie
     * @param value the value of the cookie
     */
    public NewCookie(String name, String value) {
        super(name, value);
    }
    
    /**
     * Create a new instance.
     * @param name the name of the cookie
     * @param value the value of the cookie
     * @param path the URI path for which the cookie is valid
     * @param domain the host domain for which the cookie is valid
     * @param comment the comment
     * @param maxAge the maximum age of the cookie in seconds
     * @param secure specifies whether the cookie will only be sent over a secure connection
     */
    public NewCookie(String name, String value, String path, String domain, String comment, int maxAge, boolean secure) {
        super(name, value, path, domain);
        this.comment = comment;
        this.maxAge = maxAge;
        this.secure = secure;
    }
    
    /**
     * Create a new instance.
     * @param name the name of the cookie
     * @param value the value of the cookie
     * @param path the URI path for which the cookie is valid
     * @param domain the host domain for which the cookie is valid
     * @param version the version of the specification to which the cookie complies
     * @param comment the comment
     * @param maxAge the maximum age of the cookie in seconds
     * @param secure specifies whether the cookie will only be sent over a secure connection
     */
    public NewCookie(String name, String value, String path, String domain, int version, String comment, int maxAge, boolean secure) {
        super(name, value, path, domain, version);
        this.comment = comment;
        this.maxAge = maxAge;
        this.secure = secure;
    }
    
    /**
     * Create a new instance copying the information in the supplied cookie.
     * @param cookie the cookie to clone
     */
    public NewCookie(Cookie cookie) {
        super(cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain(), cookie.getVersion());
    }

    /**
     * Create a new instance supplementing the information in the supplied cookie.
     * @param cookie the cookie to clone
     * @param comment the comment
     * @param maxAge the maximum age of the cookie in seconds
     * @param secure specifies whether the cookie will only be sent over a secure connection
     */
    public NewCookie(Cookie cookie, String comment, int maxAge, boolean secure) {
        this(cookie.getName(), cookie.getValue(), cookie.getPath(), cookie.getDomain(), cookie.getVersion(), comment, maxAge, secure);
    }

    /**
     * Get the comment associated with the cookie.
     * @return the comment or null if none set
     */
    public String getComment() {
        return comment;
    }

    /**
     * Get the maximum age of the the cookie in seconds. Cookies older than
     * the maximum age are discarded. A cookie can be unset by sending a new
     * cookie with maximum age of 0 since it will overwrite any existing cookie
     * and then be immediately discarded. The default value of -1 indicates that the cookie
     * will be discarded at the end of the browser/application session.
     * @return the maximum age in seconds
     */
    public int getMaxAge() {
        return maxAge;
    }

    /**
     * Whether the cookie will only be sent over a secure connection. Defaults
     * to false.
     * @return true if the cookie will only be sent over a secure connection,
     * false otherwise.
     */
    public boolean isSecure() {
        return secure;
    }

}
