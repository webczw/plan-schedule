package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.ActivityFlow;
import com.tencent.wxcloudrun.service.ActivityFlowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * counter控制器
 */

@RestController
@RequestMapping(value = "/af/api")
public class ActivityFlowController {
    @Resource
    private ActivityFlowService activityFlowService;
    private final Logger logger = LoggerFactory.getLogger(ActivityFlowController.class);

    /**
     * 创建活动流
     *
     * @return API response json
     */
    @PostMapping(value = "/create")
    ApiResponse createActivityFlow(@RequestBody ActivityFlow activityFlow) {
        try {
            logger.info("createActivityFlow->start");
            ActivityFlow dbActivityFlow = activityFlowService.create(activityFlow);
            return ApiResponse.ok(dbActivityFlow);
        } catch (Exception e) {
            logger.error("createActivityFlow error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 根据当前登录人查询活动流集合
     *
     * @param userId the user id
     * @return the api response
     */
    @GetMapping(value = "/list")
    ApiResponse findList(@RequestParam("userId") String userId) {
        try {
            logger.info("findList->start.");
            List<ActivityFlow> activityFlowList = activityFlowService.findCreateBy(userId);
            return ApiResponse.ok(activityFlowList);
        } catch (Exception e) {
            logger.error("findList error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新活动流信息
     *
     * @param activityFlow the activity flow
     * @return the api response
     */
    @PostMapping(value = "/update")
    ApiResponse updateActivityFlow(@RequestBody ActivityFlow activityFlow) {
        try {
            logger.info("updateActivityFlow->start");
            Integer updateCount = activityFlowService.update(activityFlow);
            return ApiResponse.ok(updateCount);
        } catch (Exception e) {
            logger.error("updateActivityFlow error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 删除活动流信息
     *
     * @param activityFlow the activity flow
     * @return the api response
     */
    @PostMapping(value = "/delete")
    ApiResponse deleteActivityFlow(@RequestBody ActivityFlow activityFlow) {
        try {
            logger.info("deleteActivityFlow->start");
            Integer deleteCount = activityFlowService.delete(activityFlow);
            return ApiResponse.ok(deleteCount);
        } catch (Exception e) {
            logger.error("deleteActivityFlow error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

}