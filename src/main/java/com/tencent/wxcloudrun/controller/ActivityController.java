package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * counter控制器
 */

@RestController
@RequestMapping(value = "/at/api")
public class ActivityController {

    @Resource
    private ActivityService activityService;
    private final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    /**
     * 创建活动
     *
     * @param activity the activity
     * @return API response json
     */
    @PostMapping(value = "/create")
    ApiResponse createActivity(@RequestBody Activity activity) {
        try {
            logger.info("createActivity->start");
            Activity dbActivity = activityService.create(activity);
            return ApiResponse.ok(dbActivity);
        } catch (Exception e) {
            logger.error("createActivity error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 根据活动流ID查询活动集合
     *
     * @param activityFlowId the activity flow id
     * @return the api response
     */
    @GetMapping(value = "/list")
    ApiResponse findActivityList(@RequestParam("activityFlowId") Long activityFlowId) {
        try {
            logger.info("findActivityList->start.");
            List<Activity> activityList = activityService.findByActivityFlowId(activityFlowId);
            return ApiResponse.ok(activityList);
        } catch (Exception e) {
            logger.error("findActivityList error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 更新活动信息
     *
     * @param activity the activity
     * @return the api response
     */
    @PostMapping(value = "/update")
    ApiResponse updateActivity(@RequestBody Activity activity) {
        try {
            logger.info("updateActivity->start");
            Integer updateCount = activityService.update(activity);
            return ApiResponse.ok(updateCount);
        } catch (Exception e) {
            logger.error("updateActivity error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

    /**
     * 删除活动信息
     *
     * @param activity the activity
     * @return the api response
     */
    @PostMapping(value = "/delete")
    ApiResponse deleteActivity(@RequestBody Activity activity) {
        try {
            logger.info("deleteActivity->start");
            Integer deleteCount = activityService.delete(activity);
            return ApiResponse.ok(deleteCount);
        } catch (Exception e) {
            logger.error("deleteActivity error.", e);
            return ApiResponse.error(e.getMessage());
        }
    }

}