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
 * Binds a HTTP query parameter to a Java method parameter, class field or bean
 * property.
 * The class of the annotated parameter, field or bean must have a constructor
 * that accepts a single String or List<String> argument, or a static method 
 * named <code>valueOf</code> that accepts a single String argument
 * (see, for example, {@link Integer#valueOf(String)}).
 * @see DefaultValue
 */
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryParam {
    /**
     * Defines the name of the HTTP query parameter whose value will be used
     * to initialize the value of the annotated method argument, class field or
     * bean property.
     */
    String value();
}