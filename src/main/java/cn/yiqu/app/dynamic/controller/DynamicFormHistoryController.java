package cn.yiqu.app.dynamic.controller;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.yiqu.app.dynamic.domain.DynamicFormHistory;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormHistoryVo;
import cn.yiqu.app.dynamic.service.DynamicFormHistoryService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 动态表单历史Controller
 *
 * @author zhanghengtong 2023/8/14 10:31
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicFormHistoryController {

    @Autowired
    private DynamicFormHistoryService dynamicFormHistoryService;

    /**
     * 分页查询集合
     */
    @PostMapping("/form/history/pager")
    PageResult<DynamicFormHistory> pager(@RequestBody PageRequester<DynamicFormHistory> requester) {
        return dynamicFormHistoryService.pager(requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/form/history/vo/pager")
    PageResult<DynamicFormHistoryVo> pagerVo(@RequestBody PageRequester<DynamicFormHistoryVo> requester) {
        return dynamicFormHistoryService.pagerVo(requester);
    }

    /**
     * 分页查询集合
     */
    @PostMapping("/form/history/condition/pager")
    PageResult<DynamicFormHistory> pagerCondition(@RequestBody PageRequesterFormCondition<DynamicFormHistory> requester) {
        return dynamicFormHistoryService.pager(DynamicFormHistory.class, requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/form/history/condition/vo/pager")
    PageResult<DynamicFormHistoryVo> pagerConditionVo(@RequestBody PageRequesterFormCondition<DynamicFormHistory> requester) {
        return dynamicFormHistoryService.pagerVo(DynamicFormHistory.class, requester);
    }

    /**
     * 通过id查询vo对象
     */
    @GetMapping("/form/history/get")
    DynamicFormHistoryVo get(Long id) {
        return dynamicFormHistoryService.selById(id);
    }

    /**
     * 查询集合
     */
    @PostMapping("/form/history/list")
    List<DynamicFormHistory> list(@RequestBody DynamicFormHistory project) {
        Wrapper<DynamicFormHistory> wrapper = dynamicFormHistoryService.builder(project);
        return dynamicFormHistoryService.list(wrapper);
    }

    /**
     * 查询vo集合
     */
    @PostMapping("/form/history/list/vo")
    List<DynamicFormHistoryVo> listVo(@RequestBody DynamicFormHistoryVo vo) {
        return dynamicFormHistoryService.listVo(vo);
    }

    /**
     * 保存
     */
    @PostMapping("/form/history/save")
    DynamicFormHistory save(@RequestBody DynamicFormHistoryVo vo) {
        return dynamicFormHistoryService.saver(vo);
    }

    /**
     * 保存或修改
     */
    @PostMapping("/form/history/saver/or/update")
    void saverOrUpdate(@RequestBody DynamicFormHistoryVo vo) {
        dynamicFormHistoryService.saverOrUpdater(vo);
    }

    /**
     * 通过id删除
     */
    @GetMapping("/form/history/remove")
    void remove(Long id) {
        dynamicFormHistoryService.removeById(id);
    }

}
