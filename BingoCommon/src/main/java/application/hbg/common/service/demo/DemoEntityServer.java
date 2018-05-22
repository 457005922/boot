package application.hbg.common.service.demo;


import application.hbg.common.model.demo.DomeEntity;

import java.util.List;

/**
 * 描述:
 *
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/5/4
 */
public interface DemoEntityServer {
    /**
     * 保存文件
     * @param
     * @return
     */
    DomeEntity saveFile(DomeEntity file);

    /**
     * 删除文件
     * @param
     * @return
     */
    void removeFile(String id);

    /**
     * 根据id获取文件
     * @param
     * @return
     */
    DomeEntity getFileById(String id);

    /**
     * 分页查询，按上传时间降序
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<DomeEntity> listFilesByPage(int pageIndex, int pageSize);
}
