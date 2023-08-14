//package cn.yiqu.app.dynamic.server;
//
//import cn.ifloat.brick.basic.common.results.PageRequester;
//import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
//import cn.ifloat.brick.basic.common.results.PageResult;
//import cn.yiqu.app.dynamic.controller.DynamicFormController;
//import cn.yiqu.app.dynamic.domain.DynamicForm;
//import cn.yiqu.app.dynamic.service.DynamicFormService;
//import cn.yiqu.app.dynamic.domain.vo.DynamicFormVo;
//import com.baomidou.mybatisplus.core.conditions.Wrapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * 接口实现
// */
//@RestController
//public class DynamicFormServer implements DynamicFormController {
//
//    @Autowired
//    private DynamicFormService dynamicFormService;
//
//    @Override
//    public PageResult<DynamicForm> pager(PageRequester<DynamicForm> requester) {
//        return dynamicFormService.pager(requester);
//    }
//
//    @Override
//    public PageResult<DynamicFormVo> pagerVo(PageRequester<DynamicFormVo> requester) {
//        return dynamicFormService.pagerVo(requester);
//    }
//
//    @Override
//    public PageResult<DynamicForm> pagerCondition(PageRequesterFormCondition<DynamicForm> requester) {
//        return dynamicFormService.pager(DynamicForm.class, requester);
//    }
//
//    @Override
//    public PageResult<DynamicFormVo> pagerConditionVo(PageRequesterFormCondition<DynamicForm> requester) {
//        return dynamicFormService.pagerVo(DynamicForm.class, requester);
//    }
//
//    @Override
//    public DynamicFormVo get(Long id) {
//        return dynamicFormService.selById(id);
//    }
//
//    @Override
//    public List<DynamicForm> list(DynamicForm project) {
//        Wrapper<DynamicForm> wrapper = dynamicFormService.builder(project);
//        return dynamicFormService.list(wrapper);
//    }
//
//    @Override
//    public List<DynamicFormVo> listVo(DynamicFormVo vo) {
//        return dynamicFormService.listVo(vo);
//    }
//
//    @Override
//    @Transactional
//    public DynamicForm save(DynamicFormVo vo) {
//        return dynamicFormService.saver(vo);
//    }
//
//    @Override
//    @Transactional
//    public void saverOrUpdate(DynamicFormVo vo) {
//        dynamicFormService.saverOrUpdater(vo);
//    }
//
//    @Override
//    @Transactional
//    public void remove(Long id) {
//        dynamicFormService.removeById(id);
//    }
//
//    @Override
//    public PageResult<DynamicFormVo> pagerRelationVo(PageRequester<DynamicFormVo> requester) {
//        return dynamicFormService.pagerRelationVo(requester);
//    }
//
//    @Override
//    public PageResult<DynamicFormVo> pagerConditionRelationVo(PageRequesterFormCondition<DynamicForm> requester) {
//        return dynamicFormService.pagerRelationVo(DynamicForm.class, requester);
//    }
//
//    @Override
//    public DynamicFormVo getRelation(Long id) {
//        return dynamicFormService.selRelationById(id);
//    }
//
//    @Override
//    public List<DynamicFormVo> listRelationVo(DynamicFormVo vo) {
//        return dynamicFormService.listRelationVo(vo);
//    }
//}
