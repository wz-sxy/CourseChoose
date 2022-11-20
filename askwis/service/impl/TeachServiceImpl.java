package com.askwis.service.impl;

import com.askwis.dao.TeachDao;
import com.askwis.domain.Teach;
import com.askwis.service.ITeachService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TeachServiceImpl extends ServiceImpl<TeachDao, Teach> implements ITeachService {
}
