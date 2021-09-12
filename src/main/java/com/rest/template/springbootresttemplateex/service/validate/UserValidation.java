package com.rest.template.springbootresttemplateex.service.validate;

import com.rest.template.springbootresttemplateex.exception.JobNotFoundException;
import com.rest.template.springbootresttemplateex.exception.NameNotFoundException;
import org.springframework.util.StringUtils;

public class UserValidation {

    public boolean checkUserValidation(String name, String job){

        if(StringUtils.isEmpty(name)){
            throw new NameNotFoundException("Not a valid name");
        }
        if(StringUtils.isEmpty(job)){
            throw new JobNotFoundException("Not a valid job");
        }

        return false;
    }

}
