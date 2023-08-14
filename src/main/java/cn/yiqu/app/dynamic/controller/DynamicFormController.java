package cn.yiqu.app.dynamic.controller;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.yiqu.app.dynamic.domain.DynamicForm;
import cn.yiqu.app.dynamic.domain.vo.DynamicFormVo;
import cn.yiqu.app.dynamic.service.DynamicFormService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 动态表单Controller
 *
 * @author zhanghengtong 2023/8/14 10:31
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicFormController {

    @Autowired
    private DynamicFormService dynamicFormService;

    /**
     * 分页查询集合
     */
    @PostMapping("/form/pager")
    PageResult<DynamicForm> pager(@RequestBody PageRequester<DynamicForm> requester) {
        return dynamicFormService.pager(requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/form/vo/pager")
    PageResult<DynamicFormVo> pagerVo(@RequestBody PageRequester<DynamicFormVo> requester) {
        return dynamicFormService.pagerVo(requester);
    }

    /**
     * 分页查询集合
     */
    @PostMapping("/form/condition/pager")
    PageResult<DynamicForm> pagerCondition(@RequestBody PageRequesterFormCondition<DynamicForm> requester) {
        return dynamicFormService.pager(DynamicForm.class, requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/form/condition/vo/pager")
    PageResult<DynamicFormVo> pagerConditionVo(@RequestBody PageRequesterFormCondition<DynamicForm> requester) {
        return dynamicFormService.pagerVo(DynamicForm.class, requester);
    }

    /**
     * 通过id查询vo对象
     */
    @GetMapping("/form/get")
    DynamicFormVo get(Long id) {
        return dynamicFormService.selById(id);
    }

    /**
     * 查询集合
     */
    @PostMapping("/form/list")
    List<DynamicForm> list(@RequestBody DynamicForm project) {
        Wrapper<DynamicForm> wrapper = dynamicFormService.builder(project);
        return dynamicFormService.list(wrapper);
    }

    /**
     * 查询vo集合
     */
    @PostMapping("/form/list/vo")
    List<DynamicFormVo> listVo(@RequestBody DynamicFormVo vo) {
        return dynamicFormService.listVo(vo);
    }

    /**
     * 保存
     */
    @PostMapping("/form/save")
    DynamicForm save(@RequestBody DynamicFormVo vo) {
        return dynamicFormService.saver(vo);
    }

    /**
     * 保存或修改动态表单
     *
     * @param vo 表单Vo对象
     */
    @PostMapping("/form/saver/or/update")
    void saverOrUpdate(@RequestBody DynamicFormVo vo) {
        dynamicFormService.saverOrUpdater(vo);
    }

    /**
     * 通过id删除
     */
    @GetMapping("/form/remove")
    void remove(Long id) {
        dynamicFormService.removeById(id);
    }

    /**
     * 分页查询关系vo集合
     */
    @PostMapping("/form/vo/relation/pager")
    PageResult<DynamicFormVo> pagerRelationVo(@RequestBody PageRequester<DynamicFormVo> requester) {
        return dynamicFormService.pagerRelationVo(requester);
    }

    /**
     * 分页查询关系vo集合
     */
    @PostMapping("/form/condition/relation/vo/pager")
    PageResult<DynamicFormVo> pagerConditionRelationVo(@RequestBody PageRequesterFormCondition<DynamicForm> requester) {
        return dynamicFormService.pagerRelationVo(DynamicForm.class, requester);
    }

    /**
     * 通过id查询关系vo对象
     */
    @GetMapping("/form/get/relation")
    DynamicFormVo getRelation(Long id) {
        return dynamicFormService.selRelationById(id);
    }

    /**
     * 查询vo关系集合
     */
    @PostMapping("/form/list/relation/vo")
    List<DynamicFormVo> listRelationVo(@RequestBody DynamicFormVo vo) {
        return dynamicFormService.listRelationVo(vo);
    }

}
