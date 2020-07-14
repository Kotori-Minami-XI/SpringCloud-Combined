# SpringCloud-Combined
SpringCloud-Combined

### 1. Database

```
#选择数据库 
USING springcloud_combined_db

#创建order_table
CREATE TABLE `order_table` (
  `orderId` bigint NOT NULL AUTO_INCREMENT,
  `productId` bigint DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#创建stock_table
CREATE TABLE `stock_table` (
  `productId` bigint NOT NULL AUTO_INCREMENT,
  `stockNum` bigint DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
