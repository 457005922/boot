package application.hbg.common.service.demo.impl;


import application.hbg.common.model.demo.DomeEntity;
import application.hbg.common.repository.demo.DemoEntityRepository;
import application.hbg.common.service.demo.DemoEntityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 *
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/5/4
 */
@Service
public class DemoEntityServerImpl implements DemoEntityServer {
    @Autowired
    public DemoEntityRepository fileRepository;

    @Override
    public DomeEntity saveFile(DomeEntity file) {
        return fileRepository.save(file);
    }

    @Override
    public void removeFile(String id) {
        fileRepository.delete(id);
    }

    @Override
    public DomeEntity getFileById(String id) {
        return fileRepository.findOne(id);
    }

    @Override
    public List<DomeEntity> listFilesByPage(int pageIndex, int pageSize) {
        Page<DomeEntity> page = null;
        List<DomeEntity> list = null;
        Sort sort = new Sort(Sort.Direction.DESC,"uploadDate");
        Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
        page = fileRepository.findAll(pageable);
        list = page.getContent();
        return list;
    }

}
