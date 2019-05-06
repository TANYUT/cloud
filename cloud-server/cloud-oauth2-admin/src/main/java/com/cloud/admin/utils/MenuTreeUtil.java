package com.cloud.admin.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.admin.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单循树结构
 * </p>
 *
 * @Title MenuTreeUtil.java
 * @Package com.cloud.admin.utils
 * @Author <a href="mailto:au.t@foxmail.com">au .T</a>
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

    /**
     * <p>
     *
     * </p>
     *
     * @params: [tree, node, parentId, id]
     * @params: [list, 顶级节点, 是谁的子集, 默认ID]
     * @return: java.util.List<?>
     * @Author: au .T
     * @Date: 2019/5/5 18:24
     */
    public static List<?> treeTest(List<?> tree, String node, String parentId, String id) {
        List list = new ArrayList<>();
        tree.forEach(obj -> {
            JSONObject object = JSONUtil.parseObj(obj);
            if (object.getStr(parentId).equals(node)) {
                setTreeMap(object, tree, node, parentId, id);
                list.add(object);
            }
        });
        return list;
    }

    private static void setTreeMap(JSONObject mapArr, List<?> tree, String node, String parentId, String id) {
        List<?> childrens = menuChild(mapArr, tree, node, parentId, id);
        if (childrens.size() > 0) {
            mapArr.put("hasChild", true);
        } else {
            mapArr.put("hasChildren", false);
        }
        mapArr.put("childrens", menuChild(mapArr, tree, node, parentId, id));
    }

    public static List<?> menuChild(JSONObject mapArr, List<?> tree, String node, String parentId, String id) {
        List<Object> lists = new ArrayList<>();
        for (Object treeNode : tree) {
            JSONObject childArray = JSONUtil.parseObj(treeNode);
            if (childArray.getStr(parentId).equals(id)) {
                setTreeMap(mapArr, tree, node, parentId, id);
                lists.add(childArray);
            }
        }
        return lists;
    }
}
