package org.bc.common.driver;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/5/16 10:15
 *         saas-common
 *         com.ikang.saas.common.driver
 */
public class MybatisSelectInExtendedLanguageDriver extends XMLLanguageDriver implements LanguageDriver {

    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");
    private final Pattern ifPattern = Pattern.compile("if (\\w+) = #\\{(\\w+)\\}");

    @Override
    public SqlSource createSqlSource(Configuration configuration,
                                     String script, Class<?> parameterType) {

        Matcher inMatcher = inPattern.matcher(script);
        if (inMatcher.find()) {
            script = inMatcher.replaceAll("(<foreach collection=\"$1\" item=\"__item\" separator=\",\" >#{__item}</foreach>)");
        }

        Matcher ifMatcher = ifPattern.matcher(script);
        if (ifMatcher.find()) {
            script = ifMatcher.replaceAll("<if test=\"$2 != null\">AND $1 = #{$2}</if>");
        }
        script = "<script>" + script + "</script>";
        return super.createSqlSource(configuration, script, parameterType);
    }
}
