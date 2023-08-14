//package cn.yiqu.app.dynamic.server;
//
//import cn.ifloat.brick.basic.common.results.PageRequester;
//import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
//import cn.ifloat.brick.basic.common.results.PageResult;
//import cn.yiqu.app.dynamic.controller.DynamicFormHistoryController;
//import cn.yiqu.app.dynamic.domain.DynamicFormHistory;
//import cn.yiqu.app.dynamic.service.DynamicFormHistoryService;
//import cn.yiqu.app.dynamic.domain.vo.DynamicFormHistoryVo;
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
//public class DynamicFormHistoryServer{
//
//    @Autowired
//    private DynamicFormHistoryService dynamicFormHistoryService;
//
//
//    public PageResult<DynamicFormHistory> pager(PageRequester<DynamicFormHistory> requester) {
//        return dynamicFormHistoryService.pager(requester);
//    }
//
//
//    public PageResult<DynamicFormHistoryVo> pagerVo(PageRequester<DynamicFormHistoryVo> requester) {
//        return dynamicFormHistoryService.pagerVo(requester);
//    }
//
//
//    public PageResult<DynamicFormHistory> pagerCondition(PageRequesterFormCondition<DynamicFormHistory> requester) {
//        return dynamicFormHistoryService.pager(DynamicFormHistory.class, requester);
//    }
//
//
//    public PageResult<DynamicFormHistoryVo> pagerConditionVo(PageRequesterFormCondition<DynamicFormHistory> requester) {
//        return dynamicFormHistoryService.pagerVo(DynamicFormHistory.class, requester);
//    }
//
//
//    public DynamicFormHistoryVo get(Long id) {
//        return dynamicFormHistoryService.selById(id);
//    }
//
//
//    public List<DynamicFormHistory> list(DynamicFormHistory project) {
//        Wrapper<DynamicFormHistory> wrapper = dynamicFormHistoryService.builder(project);
//        return dynamicFormHistoryService.list(wrapper);
//    }
//
//
//    public List<DynamicFormHistoryVo> listVo(DynamicFormHistoryVo vo) {
//        return dynamicFormHistoryService.listVo(vo);
//    }
//
//
//    @Transactional
//    public DynamicFormHistory save(DynamicFormHistoryVo vo) {
//        return dynamicFormHistoryService.saver(vo);
//    }
//
//
//    @Transactional
//    public void saverOrUpdate(DynamicFormHistoryVo vo) {
//        dynamicFormHistoryService.saverOrUpdater(vo);
//    }
//
//
//    @Transactional
//    public void remove(Long id) {
//        dynamicFormHistoryService.removeById(id);
//    }
//
//}
