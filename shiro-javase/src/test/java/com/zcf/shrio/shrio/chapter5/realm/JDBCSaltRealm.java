package com.zcf.shrio.shrio.chapter5.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;

public class JDBCSaltRealm extends JdbcRealm{
	 public JDBCSaltRealm() {
	        setSaltStyle(SaltStyle.COLUMN);
	}
}
