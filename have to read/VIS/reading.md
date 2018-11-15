* 数据的快速产生和失效->一种快速处理数据的方法
  * 比如Heatmap && fan-chart 通过统计特征来



` Trend-detection groups entities that behave similarly over an extended period of time into trends. `



和我想得不一样，trend-detection 是一种聚类的方式。值得安排。



***We think of a trend as a set of entities such that all entities in the trend are a small distance away from their neighbors***![1541771406979](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1541771406979.png)



如何挑选颗粒度：

***Furthermore,agglomeration requires a predeﬁned granularity todetecttrends. Since the trends, and hence the necessary granularity, are not known apiori,trend detection should be performed at different granularities.***

因为颗粒度不是先验的，所以要在多个颗粒度下处理

![1541825473535](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1541825473535.png)

* 关注于初始状态是present initially的数据



![1542202530217](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542202530217.png)

* the model focus on
  * the clustering task 



task:

![1542202687797](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542202687797.png)![1542202737745](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542202737745.png)

* support	:	包含数据的量
* duration :       长度
* range :             宽度
* distribution :   where exactly the time series making up the trend lie within the range of the trend



use the trajectory grouping to detect trends



使用轨迹聚类：



* DBSCAN

  * 2.2 算法过程

1. 随机选取一点p
2. 检索p的所有密度可达点
3. 若p为核心点，则新建一个簇
4. 若p为边界点且p无密度可达点，则DBSCAN选取下一个点
5. 持续1~4直至无点可检索。



轨迹聚类：

* 垂直距离
* 多出的距离
* 角度距离

![1542207449298](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542207449298.png)





算法：

* ![1542210944215](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542210944215.png)
* 就是1.不能加入别的线：距离太远 2.不能在拉长G，有线分开了
* ![1542212469469](C:\Users\pc\AppData\Roaming\Typora\typora-user-images\1542212469469.png)

