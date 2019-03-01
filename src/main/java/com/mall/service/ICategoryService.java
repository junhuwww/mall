package com.mall.service;


import com.mall.common.ServerResponse;
import com.mall.pojo.Category;

import java.util.List;

public interface ICategoryService {

    ServerResponse<Category> addCategory(String categoryName, Integer parentId);

    ServerResponse<Category> updateCategoryName(String categoryName, Integer categoryId);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChlidrenById(Integer categoryId);

}
