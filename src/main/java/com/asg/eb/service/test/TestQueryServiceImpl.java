package com.asg.eb.service.test;

import com.asg.eb.api.code.ErrorStatus;
import com.asg.eb.api.exception.handler.TestHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1) {
            throw new TestHandler(ErrorStatus.TEST_EXCEPTION);
        }
    }
}
