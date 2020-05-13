package com.example.demo090.service.impl;

import com.example.demo090.control.param.CommodityReq;
import com.example.demo090.control.param.UserReq;
import com.example.demo090.dao.entity.CommodityEntity;
import com.example.demo090.dao.entity.UserEntity;
import com.example.demo090.dao.repository.CommodityRepository;
import com.example.demo090.dao.repository.UserRepository;
import com.example.demo090.domain.Commodity;
import com.example.demo090.service.CommodityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 新建一个商品对象
     * @param commodityReq 商品参数
     * @return
     */
    @Override
    public Commodity createOne(CommodityReq commodityReq) {

        //创建数据库实体类对象
        CommodityEntity commodityEntity = new CommodityEntity();
        //使用工具类进行拷贝
        BeanUtils.copyProperties(commodityReq, commodityEntity);
        //保存至数据库
        commodityRepository.save(commodityEntity);

        //创建domain对象用于返回
        Commodity commodity = new Commodity();
        //拷贝
        BeanUtils.copyProperties(commodityReq, commodity);

        //返回
        return commodity;
    }

    /**
     * 返回所有商品已审核的信息
     * @return
     */
    @Override
    public List<Commodity> getAll() {

        List<CommodityEntity> commodities = commodityRepository.findByComStatus("released");

        List<Commodity> commodityList = commodities.stream().map( entity ->{

            Commodity commodity = new Commodity();
            BeanUtils.copyProperties(entity,commodity);
            return commodity;
        }).collect(Collectors.toList());

        /*
                List<Book> books = bookEntities.stream().map(entity -> {
            Book book = new Book();
            BeanUtils.copyProperties(entity, book);
            return book;
        }).collect(Collectors.toList());
         */

        return commodityList;
    }

    /**
     * 查找状态为已经发布的商品信息
     * @return
     */
    @Override
    public List<CommodityEntity> getStatus() {
        return commodityRepository.findByComStatus("released");
    }

    /**
     * 添加一个商品，同时对两个表中的实例进行关联
     * 此处有小bug，若重名用户添加出错，因为传入参数是userreq按照姓名查找，应该按照id查找，待改
     * @param commodityReq 商品参数
     * @param userReq 用户参数
     * @return
     */
    @Override
    public Commodity addCommodityFromOneUser(CommodityReq commodityReq, UserReq userReq) {

        //创建两个实体类对象
        CommodityEntity commodityEntity = new CommodityEntity();
        UserEntity userEntity = new UserEntity();

        //数据拷贝
        BeanUtils.copyProperties(commodityReq,commodityEntity);
        BeanUtils.copyProperties(userReq,userEntity);

        //保存商品状态
        //保存状态为“unchecked”
        commodityEntity.setComStatus("unchecked");

        //保存并产生关联
        UserEntity out = userRepository.findByUsername(userReq.getUsername());
        commodityEntity.setUser(out);
        commodityRepository.save(commodityEntity);
        //userRepository.save(userEntity);

        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityReq,commodity);

        return commodity;
    }
}
