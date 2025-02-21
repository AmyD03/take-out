package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookMapper addressBookMapper;

    /**
     * 查询当前登录用户的所有地址信息
     * @param addressBook
     * @return
     */
    public List<AddressBook> list(AddressBook addressBook){
        return addressBookMapper.list(addressBook);
    }

    /**
     * 新增地址
     * @param addressBook
     */
    public void save(AddressBook addressBook){
        addressBook.setUserId(BaseContext.getCurrentId());
        //默认设置新地址为默认地址
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }
}
