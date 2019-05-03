package com.cloud.oauthupms.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.oauthupms.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单循树结构
 * </p>
 *
 * @Title MenuTreeUtil.java
 * @Package com.cloud.oauthupms.utils
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/3 15:39
 */
public class MenuTreeUtil {

    public static List<?> treeMenu(List<Menu> menuList) {
        List list = new ArrayList<>();

        for (Menu treeNode : menuList) {
            JSONObject object = JSONUtil.parseObj(treeNode);
            if (treeNode.getParentId().toString().equals("-1")) {
                setTreeMap(object, treeNode, menuList);
                list.add(object);
            }
        }
        return list;
    }

    public static List<?> menuChild(String id, List<Menu> menuList) {
        List<Object> lists = new ArrayList<>();
        for (Menu treeNode : menuList) {
            JSONObject childArray = JSONUtil.parseObj(treeNode);
            if (treeNode.getParentId().toString().equals(id)) {
                setTreeMap(childArray, treeNode, menuList);
                lists.add(childArray);
            }
        }
        return lists;
    }

    private static void setTreeMap(JSONObject mapArr, Menu treeNode, List<Menu> menuList) {
        List<?> childrens = menuChild(treeNode.getMenuId().toString(), menuList);
        if (childrens.size() > 0) {
            mapArr.put("hasChild", true);
        } else {
            mapArr.put("hasChildren", false);
        }
        mapArr.put("childrens", menuChild(treeNode.getMenuId().toString(), menuList));
    }
}
