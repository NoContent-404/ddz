package com.hlg.ddz.service.impl;

import com.hlg.ddz.dao.AreaDao;
import com.hlg.ddz.entity.Area;
import com.hlg.ddz.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insetArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && !"".equals(area.getAreaId())){
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败:" + e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {


            if (areaId > 0) {
                try {
                    int effectedNum = areaDao.deleteArea(areaId);
                    if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("区域信息删除失败");
                  }
                } catch (Exception e) {
                    throw new RuntimeException("区域信息删除失败:" + e.getMessage());
                }
            }else {
                throw new RuntimeException("区域Id不能为空！");
            }
    }
}
