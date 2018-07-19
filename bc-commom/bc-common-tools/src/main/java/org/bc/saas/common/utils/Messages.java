/**
 *    Copyright 2006-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.bc.saas.common.utils;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author Jeff Butler
 */
public class Messages {
    private static final String BUNDLE_NAME = "messages.messages";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME ,new Locale("zh", "CN"));

    private Messages() {
    }

    public static String getString(String key) {
        try {
            return unicode(key);
        } catch (Exception e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1) {
        try {
            return MessageFormat.format(unicode(key), parm1);
        } catch (Exception e) {
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1, String parm2) {
        try {
            return MessageFormat.format(unicode(key), parm1, parm2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return '!' + key + '!';
        }
    }

    public static String getString(String key, String parm1, String parm2,
            String parm3) {
        try {
            return MessageFormat.format(unicode(key), parm1, parm2, parm3);
        } catch (Exception e) {
            return '!' + key + '!';
        }
    }

    private static String unicode(String str) throws UnsupportedEncodingException {
        if (Objects.equals(RESOURCE_BUNDLE.getLocale().getLanguage() , "zh")) {
            return new String(RESOURCE_BUNDLE.getString(str).getBytes("ISO-8859-1"),"UTF-8");
        }
        else {
            return RESOURCE_BUNDLE.getString(str);
        }
    }
}
