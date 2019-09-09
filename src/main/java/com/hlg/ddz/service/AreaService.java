package com.hlg.ddz.service;

import com.hlg.ddz.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    boolean addArea(Area area);
    boolean modifyArea(Area area);
    boolean deleteArea(int areaId);
}
