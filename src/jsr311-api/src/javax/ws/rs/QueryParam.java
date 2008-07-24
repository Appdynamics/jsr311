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
 * QueryParam.java
 *
 * Created on November 16, 2006, 2:04 PM
 *
 */

package javax.ws.rs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binds the value(s) of a HTTP query parameter to a resource method parameter, 
 * resource class field, or resource class bean property.
 * Values are URL decoded unless this is disabled using the {@link Encoded}
 * annotation. A default value can be specified using the {@link DefaultValue}
 * annotation.
 * 
 * The type <code>T</code> of the annotated parameter, field or property must 
 * either:
 * <ol>
 * <li>Be a primitive type</li>
 * <li>Have a constructor that accepts a single <code>String</code> argument</li>
 * <li>Have a static method named <code>valueOf</code> that accepts a single 
 * <code>String</code> argument (see, for example, {@link Integer#valueOf(String)})</li>
 * <li>Be <code>List&lt;T&gt;</code>, <code>Set&lt;T&gt;</code> or 
 * <code>SortedSet&lt;T&gt;</code>, where <code>T</code> satisfies 2 or 3 above.
 * The resulting collection is read-only.</li>
 * </ol>
 * 
 * <p>If the type is not one of those listed in 4 above then the first value 
 * (lexically) of the parameter is used.</p>
 *
 * <p>Because injection occurs at object creation time, use of this annotation 
 * on resource class fields and bean properties is only supported for the 
 * default per-request resource class lifecycle. Resource classes using 
 * other lifecycles should only use this annotation on resource method
 * parameters.</p>
 *
 * @see DefaultValue
 * @see Encoded
 * @see javax.ws.rs.core.UriInfo#getQueryParameters
 */
@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParam {
    /**
     * Defines the name of the HTTP query parameter whose value will be used
     * to initialize the value of the annotated method argument, class field or
     * bean property.
     * 
     * <p>The supplied value is automatically percent encoded. Note that percent
     * encoded values are allowed in the value, an implementation will recognize
     * such values and will not double encode the '%' character.</p>
     */
    String value();
}
