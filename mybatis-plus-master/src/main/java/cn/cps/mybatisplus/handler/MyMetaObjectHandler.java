package cn.cps.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //自动填充：执行插入操作
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("createDateTime",new Date(),metaObject);
        this.setFieldValByName("updateDateTime",new Date(),metaObject);
    }

    //自动填充：执行更新操作
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateDateTime",new Date(),metaObject);
    }
}
