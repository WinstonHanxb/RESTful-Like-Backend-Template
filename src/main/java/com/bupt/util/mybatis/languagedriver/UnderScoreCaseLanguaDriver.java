package com.bupt.util.mybatis.languagedriver;

import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

/**
 * Created by 韩宪斌 on 2017/7/3.
 * 实现数据库的下划线命名法自动转换为驼峰命名法
 */
public class UnderScoreCaseLanguaDriver extends XMLLanguageDriver
        implements LanguageDriver {
}
