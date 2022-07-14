package com.jh.example.springboot.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<CustomNameValidation, String> {

    private final String HTML_PATTERN = "<(\"[^\"]*+\"|'[^']*+'|[^'\">])*+>";
    private Pattern pattern = Pattern.compile(HTML_PATTERN);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean isResponseHasXSSScript = false;

        if (value != null) {
            Matcher matcher = pattern.matcher(value);

            if (matcher.find()) {
                isResponseHasXSSScript = true;
            } else {
                isResponseHasXSSScript = false;
            }
        }
        return !isResponseHasXSSScript;
    }

}
