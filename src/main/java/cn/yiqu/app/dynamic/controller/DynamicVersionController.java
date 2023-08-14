package cn.yiqu.app.dynamic.controller;

import cn.ifloat.brick.basic.common.results.PageRequester;
import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
import cn.ifloat.brick.basic.common.results.PageResult;
import cn.yiqu.app.dynamic.domain.DynamicVersion;
import cn.yiqu.app.dynamic.domain.vo.DynamicVersionVo;
import cn.yiqu.app.dynamic.service.DynamicVersionService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 动态表单版本Controller
 *
 * @author zhanghengtong 2023/8/14 10:31
 */
@RestController
@RequestMapping("/version")
public class DynamicVersionController {

    @Autowired
    private DynamicVersionService dynamicVersionService;

    /**
     * 分页查询集合
     */
    @PostMapping("/pager")
    PageResult<DynamicVersion> pager(@RequestBody PageRequester<DynamicVersion> requester) {
        return dynamicVersionService.pager(requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/vo/pager")
    PageResult<DynamicVersionVo> pagerVo(@RequestBody PageRequester<DynamicVersionVo> requester) {
        return dynamicVersionService.pagerVo(requester);
    }

    /**
     * 分页查询集合
     */
    @PostMapping("/condition/pager")
    PageResult<DynamicVersion> pagerCondition(@RequestBody PageRequesterFormCondition<DynamicVersion> requester) {
        return dynamicVersionService.pager(DynamicVersion.class, requester);
    }

    /**
     * 分页查询vo集合
     */
    @PostMapping("/condition/vo/pager")
    PageResult<DynamicVersionVo> pagerConditionVo(@RequestBody PageRequesterFormCondition<DynamicVersion> requester) {
        return dynamicVersionService.pagerVo(DynamicVersion.class, requester);
    }

    /**
     * 通过id查询vo对象
     */
    @GetMapping("/get")
    DynamicVersionVo get(Long id) {
        return dynamicVersionService.selById(id);
    }

    /**
     * 查询集合
     */
    @PostMapping("/list")
    List<DynamicVersion> list(@RequestBody DynamicVersion project) {
        Wrapper<DynamicVersion> wrapper = dynamicVersionService.builder(project);
        return dynamicVersionService.list(wrapper);
    }

    /**
     * 查询vo集合
     */
    @PostMapping("/list/vo")
    List<DynamicVersionVo> listVo(@RequestBody DynamicVersionVo vo) {
        return dynamicVersionService.listVo(vo);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    DynamicVersion save(@RequestBody DynamicVersionVo vo) {
        return dynamicVersionService.saver(vo);
    }

    /**
     * 保存或修改
     */
    @PostMapping("/saver/or/update")
    void saverOrUpdate(@RequestBody DynamicVersionVo vo) {
        dynamicVersionService.saverOrUpdater(vo);
    }

    /**
     * 通过id删除
     */
    @GetMapping("/remove")
    void remove(Long id) {
        dynamicVersionService.removeById(id);
    }

}
