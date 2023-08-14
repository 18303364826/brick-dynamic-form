//package cn.yiqu.app.dynamic.server;
//
//import cn.ifloat.brick.basic.common.results.PageRequester;
//import cn.ifloat.brick.basic.common.results.PageRequesterFormCondition;
//import cn.ifloat.brick.basic.common.results.PageResult;
//import cn.yiqu.app.dynamic.controller.DynamicVersionController;
//import cn.yiqu.app.dynamic.domain.DynamicVersion;
//import cn.yiqu.app.dynamic.service.DynamicVersionService;
//import cn.yiqu.app.dynamic.domain.vo.DynamicVersionVo;
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
//public class DynamicVersionServer implements DynamicVersionController {
//
//    @Autowired
//    private DynamicVersionService dynamicVersionService;
//
//    @Override
//    public PageResult<DynamicVersion> pager(PageRequester<DynamicVersion> requester) {
//        return dynamicVersionService.pager(requester);
//    }
//
//    @Override
//    public PageResult<DynamicVersionVo> pagerVo(PageRequester<DynamicVersionVo> requester) {
//        return dynamicVersionService.pagerVo(requester);
//    }
//
//    @Override
//    public PageResult<DynamicVersion> pagerCondition(PageRequesterFormCondition<DynamicVersion> requester) {
//        return dynamicVersionService.pager(DynamicVersion.class, requester);
//    }
//
//    @Override
//    public PageResult<DynamicVersionVo> pagerConditionVo(PageRequesterFormCondition<DynamicVersion> requester) {
//        return dynamicVersionService.pagerVo(DynamicVersion.class, requester);
//    }
//
//    @Override
//    public DynamicVersionVo get(Long id) {
//        return dynamicVersionService.selById(id);
//    }
//
//    @Override
//    public List<DynamicVersion> list(DynamicVersion project) {
//        Wrapper<DynamicVersion> wrapper = dynamicVersionService.builder(project);
//        return dynamicVersionService.list(wrapper);
//    }
//
//    @Override
//    public List<DynamicVersionVo> listVo(DynamicVersionVo vo) {
//        return dynamicVersionService.listVo(vo);
//    }
//
//    @Override
//    @Transactional
//    public DynamicVersion save(DynamicVersionVo vo) {
//        return dynamicVersionService.saver(vo);
//    }
//
//    @Override
//    @Transactional
//    public void saverOrUpdate(DynamicVersionVo vo) {
//        dynamicVersionService.saverOrUpdater(vo);
//    }
//
//    @Override
//    @Transactional
//    public void remove(Long id) {
//        dynamicVersionService.removeById(id);
//    }
//
//}
