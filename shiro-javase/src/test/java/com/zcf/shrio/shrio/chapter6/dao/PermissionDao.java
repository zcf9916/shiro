package com.zcf.shrio.shrio.chapter6.dao;

import com.zcf.shrio.shrio.chapter6.entity.Permission;


public interface PermissionDao {
   
	
	/**
	 * 创建权限
	 * @param permission
	 * @return
	 */
    public Permission createPermission(Permission permission);

    
    /**
     * 删除权限
     * @param permissionId
     */
    public void deletePermission(Long permissionId);

}
