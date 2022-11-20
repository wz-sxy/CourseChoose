package com.askwis.service.impl;

import com.askwis.dao.CouDao;
import com.askwis.domain.Cou;
import com.askwis.service.ICouService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CouServiceImpl extends ServiceImpl<CouDao, Cou> implements ICouService {
}
