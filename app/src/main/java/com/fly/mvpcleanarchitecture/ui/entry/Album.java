package com.fly.mvpcleanarchitecture.ui.entry;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/3/8.
 */

public class Album extends DataSupport{

    @Column
    private String name;
}
