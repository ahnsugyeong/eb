package com.asg.eb.api.exception.handler;

import com.asg.eb.api.code.BaseCode;
import com.asg.eb.api.exception.GeneralException;

public class TestHandler extends GeneralException {
    public TestHandler(BaseCode code) {
        super(code);
    }
}
