package com.xyz.sample.apis.controller;

import com.xyz.sample.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.ThreadSafe;

import javax.ws.rs.core.MediaType;

/**
 * Created by sumit.nagariya on 08/11/18.
 */
@Api(produces = "http")
@RestController
@ThreadSafe
@RequestMapping("/v1/")
@ParametersAreNonnullByDefault
public class TestController extends BaseController {
    private final TestService testService;


    public TestController(TestService testService) {
        this.testService = testService;
    }

    @ApiOperation(nickname = "test controller", value = "test controller")
    @ApiResponses({
            @ApiResponse(code = HTTP_OK, message = "Result retrieved successfully"),
            @ApiResponse(code = HTTP_INTERNAL_SERVER_ERROR, message = "Internal server error"),
            @ApiResponse(code = HTTP_BAD_REQUEST, message = "Bad Request")})
    @RequestMapping(path = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public int sampleController(){
         return testService.writeToDB();
    }
}