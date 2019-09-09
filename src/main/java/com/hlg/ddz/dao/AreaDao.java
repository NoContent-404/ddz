package com.hlg.ddz.dao;

import com.hlg.ddz.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insetArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);

}
