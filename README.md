# user-management-system
##这是一个使用MVC架构设计的客户信息管理系统<br>
##可以用来查询数据库中的信息,在前端网页中显示<br>
###dbcpconfig.properties用来配置数据库相关的信息<br>
###daoconfig.properties用来配置DAO具体实现类<br>


v1.1.5(目前的版本)<br>
1.使用DBUtils替代DBAssist<br>

v1.1<br>
1.DAO与service解耦<br>
2.使用DBCP作为数据源<br>
3.重构DAO的实现类,使用自己写的JDBC框架(DBAssist)进行CURD操作,优化数据访问层性能<br>

v1.0正式版<br>
1.完成分页显示功能<br>
2.基本功能全部完成<br>

v0.9<br>
1.完成删除用户信息功能<br>
2.完成删除多个用户信息功能<br>
3.完成修改用户信息功能<br>

v0.8<br>
1.完成显示用户信息列表功能<br>
2.完成添加用户信息功能<br>

v0.7.7<br>
1.数据访问层已经完成,测试通过<br>

v0.5<br>
1.数据访问层的impl还未完成<br>
2.domain设计完成<br>
3.业务逻辑层已经完成<br>
4.表现层还未设计<br>
此版本还未完成主体功能,只是搭建了主体框架<br>
