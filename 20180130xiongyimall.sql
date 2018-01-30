/*
Navicat MySQL Data Transfer

Source Server         : ��������
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : xiongyimall

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-01-30 18:20:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sm_pictures
-- ----------------------------
DROP TABLE IF EXISTS `sm_pictures`;
CREATE TABLE `sm_pictures` (
  `PICTURES_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '����',
  `NAME` varchar(255) DEFAULT NULL COMMENT '�ļ���',
  `PATH` varchar(255) DEFAULT NULL COMMENT '·��',
  `CREATETIME` varchar(100) DEFAULT NULL COMMENT '����ʱ��',
  `MASTER_ID` varchar(255) DEFAULT NULL COMMENT '����',
  `BZ` varchar(255) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`PICTURES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sm_pictures
-- ----------------------------
INSERT INTO `sm_pictures` VALUES ('7c699f143d8d48ba9fcf7ca8ccff7835', 'ͼƬ', '1f26a68512494ee598527b68daeff5aa.jpg', '20180130/1f26a68512494ee598527b68daeff5aa.jpg', '2018-01-30 14:02:56', '1', 'ͼƬ�����ϴ�');

-- ----------------------------
-- Table structure for sys_app_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `SFID` varchar(100) DEFAULT NULL,
  `START_TIME` varchar(100) DEFAULT NULL,
  `END_TIME` varchar(100) DEFAULT NULL,
  `YEARS` int(10) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
INSERT INTO `sys_app_user` VALUES ('1e89e6504be349a68c025976b3ecc1d1', 'a1', '698d51a19d8a121ce581499d7b701668', '��Ա��', '', '115b386ff04f4352b060dffcd2b5d1da', '', '', '1', '121', '1212', '1212', '2015-12-02', '2015-12-25', '2', '111', '313596790@qq.com');
INSERT INTO `sys_app_user` VALUES ('ead1f56708e4409c8d071e0a699e5633', 'a2', 'bcbe3365e6ac95ea2c0343a2395834dd', '��Ա��', '', '1b67fc82ce89457a8347ae53e43a347e', '', '', '0', '', '', '', '2015-12-01', '2015-12-24', '1', '121', '978336446@qq.com');

-- ----------------------------
-- Table structure for sys_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionaries`;
CREATE TABLE `sys_dictionaries` (
  `DICTIONARIES_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '����',
  `NAME_EN` varchar(50) DEFAULT NULL COMMENT 'Ӣ��',
  `BIANMA` varchar(50) DEFAULT NULL COMMENT '����',
  `ORDER_BY` int(11) NOT NULL COMMENT '����',
  `PARENT_ID` varchar(100) DEFAULT NULL COMMENT '�ϼ�ID',
  `BZ` varchar(255) DEFAULT NULL COMMENT '��ע',
  `TBSNAME` varchar(100) DEFAULT NULL COMMENT '�Ų��',
  PRIMARY KEY (`DICTIONARIES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionaries
-- ----------------------------
INSERT INTO `sys_dictionaries` VALUES ('157d0b30e0dc47879e04de3dbaa13ca7', '����', 'Others', '13', '8', '38f53490f8bf4feb95ebaa9e8a69668a', '����', '');
INSERT INTO `sys_dictionaries` VALUES ('283ccda6e2ec404087f6d9340827982e', '���ɵ���', 'Cake', '8', '3', '38f53490f8bf4feb95ebaa9e8a69668a', '���ɵ���', '');
INSERT INTO `sys_dictionaries` VALUES ('2a92b04c950f437cb7fef15fde80cf05', '�۽�����', 'GuoGan', '9', '4', '38f53490f8bf4feb95ebaa9e8a69668a', '�۽�����', '');
INSERT INTO `sys_dictionaries` VALUES ('38f53490f8bf4feb95ebaa9e8a69668a', '��Ʒ����', 'GoodType', 'GoodType', '2', '0', '��Ʒ����', '');
INSERT INTO `sys_dictionaries` VALUES ('3f5cdd1da9724fb5b736ffe2c5e2b5e4', '��Ʒ״̬', 'GoodsStatus', 'GoodsStatus', '3', '0', '��Ʒ״̬', '');
INSERT INTO `sys_dictionaries` VALUES ('4af58668685b42d0b7d5d2a99dc18be7', '��ȡ��', 'HadCancel', '4', '4', 'ef941b6a82ea48b7a5b797ac2b592a6a', '��ȡ��', '');
INSERT INTO `sys_dictionaries` VALUES ('5aeae7a98796420dad63839b988bf9da', '�������', 'Fire', '6', '1', '38f53490f8bf4feb95ebaa9e8a69668a', '�������', '');
INSERT INTO `sys_dictionaries` VALUES ('89e451183803487bbc36f98aebb48ae0', '��ɹ���', 'DryMeat', '7', '2', '38f53490f8bf4feb95ebaa9e8a69668a', '��ɹ���', '');
INSERT INTO `sys_dictionaries` VALUES ('8f42c07b68d446b4a95ba0cf59c271ff', '�ѷ���', 'HasExpress', '2', '2', 'ef941b6a82ea48b7a5b797ac2b592a6a', '�ѷ���', '');
INSERT INTO `sys_dictionaries` VALUES ('ac811d6811624447bf8740a5e85fcc63', '��ʽ���', 'WestCake', '12', '7', '38f53490f8bf4feb95ebaa9e8a69668a', '��ʽ���', '');
INSERT INTO `sys_dictionaries` VALUES ('ba7b1fc5b04440d9ad7361ce3c85b699', '�Ѹ���', 'HadPay', '1', '1', 'ef941b6a82ea48b7a5b797ac2b592a6a', '�Ѹ���', '');
INSERT INTO `sys_dictionaries` VALUES ('be15d62050a2467ca255731202f6f77a', '�ǹ�/�ɿ���', 'Candy/Chocolate', '11', '6', '38f53490f8bf4feb95ebaa9e8a69668a', '�ǹ�/�ɿ���', '');
INSERT INTO `sys_dictionaries` VALUES ('c10f36e143514126806d6422306c490d', '���¼�', 'HadDown', '15', '2', '3f5cdd1da9724fb5b736ffe2c5e2b5e4', '���¼�', '');
INSERT INTO `sys_dictionaries` VALUES ('ced0ab752c5c4e3c87b311c6f1cfc7de', '���ϼ�', 'HadUp', '14', '1', '3f5cdd1da9724fb5b736ffe2c5e2b5e4', '���ϼ�', '');
INSERT INTO `sys_dictionaries` VALUES ('da3bfbb59af54cbebfd4095302ce7db4', '������ʳ', 'LingShi', '10', '5', '38f53490f8bf4feb95ebaa9e8a69668a', '������ʳ', '');
INSERT INTO `sys_dictionaries` VALUES ('db0a07209f5b48c8a947acdb62c910ac', '�˻�', 'BackGoods', '5', '5', 'ef941b6a82ea48b7a5b797ac2b592a6a', '�˻�', '');
INSERT INTO `sys_dictionaries` VALUES ('ef941b6a82ea48b7a5b797ac2b592a6a', '����״̬', 'OrderStatus', 'OrderStatus', '1', '0', '����״̬ (1:�Ѹ���2:�ѷ���3:ȷ���ջ�4:��ȡ��5:�˻�)', '');
INSERT INTO `sys_dictionaries` VALUES ('fdaec7a212d24332bdcb76a8a2c43879', 'ȷ���ջ�', 'ConfirmReceive', '3', '3', 'ef941b6a82ea48b7a5b797ac2b592a6a', 'ȷ���ջ�', '');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(60) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  `MENU_STATE` int(1) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'ϵͳ����', '#', '0', '1', 'menu-icon fa fa-desktop blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('2', 'Ȩ�޹���', '#', '1', '1', 'menu-icon fa fa-lock black', '1', '1');
INSERT INTO `sys_menu` VALUES ('11', '�����ֵ�', 'dictionaries/listAllDict.do?DICTIONARIES_ID=0', '1', '4', 'menu-icon fa fa-book purple', '1', '1');
INSERT INTO `sys_menu` VALUES ('36', '��ɫ(����Ȩ��)', 'role.do', '2', '1', 'menu-icon fa fa-key orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('37', '��ťȨ��', 'buttonrights/list.do', '2', '2', 'menu-icon fa fa-key green', '1', '1');
INSERT INTO `sys_menu` VALUES ('38', '�˵�����', 'menu/listAllMenu.do', '1', '3', 'menu-icon fa fa-folder-open-o brown', '1', '1');
INSERT INTO `sys_menu` VALUES ('39', '��ť����', 'xybutton/list.do', '1', '2', 'menu-icon fa fa-download orange', '1', '1');
INSERT INTO `sys_menu` VALUES ('40', '�û�����', '#', '0', '2', 'menu-icon fa fa-users blue', '2', '1');
INSERT INTO `sys_menu` VALUES ('41', 'ϵͳ�û�', 'user/listUsers.do', '40', '1', 'menu-icon fa fa-users green', '1', '1');
INSERT INTO `sys_menu` VALUES ('42', '��Ա����', 'happuser/listUsers.do', '40', '2', 'menu-icon fa fa-users orange', '1', '0');
INSERT INTO `sys_menu` VALUES ('43', 'ҵ�����', '#', '0', '4', 'menu-icon fa fa-leaf black', '2', '1');
INSERT INTO `sys_menu` VALUES ('44', '��������', 'order/list.do', '43', '1', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('45', '��Ʒ����', 'goods/list.do', '43', '2', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('46', '���۹���', 'goodsdiscuss/list.do', '43', '3', 'menu-icon fa fa-leaf black', '1', '1');
INSERT INTO `sys_menu` VALUES ('47', '������', 'stock/list.do', '43', '4', 'menu-icon fa fa-leaf black', '1', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ϵͳ������', '2251798773489606', '0', '1', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('115b386ff04f4352b060dffcd2b5d1da', '�м���Ա', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('1b67fc82ce89457a8347ae53e43a347e', '������Ա', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('2', '��Ա��', '498', '0', '0', '0', '0', '1');
INSERT INTO `sys_role` VALUES ('3264c8e83d0248bb9e3ea6195b4c0216', 'һ������Ա', '272678883688448', '1', '2251798773489606', '2251798773489606', '1125898866646982', '2251798773489606');
INSERT INTO `sys_role` VALUES ('46294b31a71c4600801724a6eb06bb26', 'ְλ��', '', '0', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('5466347ac07044cb8d82990ec7f3a90e', '����', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('68f8e4a39efe47c7bb869e9d15ab925d', '��������Ա', '2251798773489606', '1', '0', '0', '2251798773489606', '0');
INSERT INTO `sys_role` VALUES ('856849f422774ad390a4e564054d8cc8', '����', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('8b70a7e67f2841e7aaba8a4d92e5ff6f', '�߼���Ա', '498', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('c21cecf84048434b93383182b1d98cba', '�鳤', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('d449195cd8e7491080688c58e11452eb', '�ܼ�', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('de9de2f006e145a29d52dfadda295353', '��������Ա', '2251798773489606', '1', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for sys_role_xybutton
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_xybutton`;
CREATE TABLE `sys_role_xybutton` (
  `RB_ID` varchar(100) NOT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `BUTTON_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RB_ID`),
  KEY `��ɫ�����` (`ROLE_ID`) USING BTREE,
  KEY `fbutton` (`BUTTON_ID`),
  CONSTRAINT `fbutton` FOREIGN KEY (`BUTTON_ID`) REFERENCES `sys_xybutton` (`XYBUTTON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `frole` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_xybutton
-- ----------------------------
INSERT INTO `sys_role_xybutton` VALUES ('14b5c28ea6ae4508b57d2d272ab3d5f1', '3264c8e83d0248bb9e3ea6195b4c0216', '46992ea280ba4b72b29dedb0d4bc0106');
INSERT INTO `sys_role_xybutton` VALUES ('1743733f366240c693c4295b527d1b0e', 'de9de2f006e145a29d52dfadda295353', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_xybutton` VALUES ('3768e60edd1c4b5c9f1dd861188ae2f9', '3264c8e83d0248bb9e3ea6195b4c0216', 'cc51b694d5344d28a9aa13c84b7166cd');
INSERT INTO `sys_role_xybutton` VALUES ('8231c216fb514b4188e4162e629c6237', '3264c8e83d0248bb9e3ea6195b4c0216', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_xybutton` VALUES ('9412d1d05162464c83658c7f89ab03f0', '68f8e4a39efe47c7bb869e9d15ab925d', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_xybutton` VALUES ('96567633dd3548c9b75d28f430adf5a3', '3264c8e83d0248bb9e3ea6195b4c0216', 'da7fd386de0b49ce809984f5919022b8');
INSERT INTO `sys_role_xybutton` VALUES ('a1478f27c852459fa9cad04b642f4fb7', 'de9de2f006e145a29d52dfadda295353', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_xybutton` VALUES ('ba6696b8761044618e44c7e02c9ba89e', '68f8e4a39efe47c7bb869e9d15ab925d', 'cc51b694d5344d28a9aa13c84b7166cd');
INSERT INTO `sys_role_xybutton` VALUES ('f0329033d0914faf8ea6e9ff252cc5e6', '68f8e4a39efe47c7bb869e9d15ab925d', '46992ea280ba4b72b29dedb0d4bc0106');
INSERT INTO `sys_role_xybutton` VALUES ('f627982cc9d4479dbc03af726dc6ac58', 'de9de2f006e145a29d52dfadda295353', 'cc51b694d5344d28a9aa13c84b7166cd');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(15) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', 'ϵͳ����Ա', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2018-01-30 18:09:57', '0:0:0:0:0:0:0:1', '0', '���ͳ����', 'default', '', '001', '18788888888');
INSERT INTO `sys_user` VALUES ('3510cb8c2ba44bc2a35342c590d0983f', 'zyr', 'a2991076ae10b80a6ff37eb82e8c404b815eb0c0', '��һ��', '', '3264c8e83d0248bb9e3ea6195b4c0216', '2018-01-28 11:05:04', '127.0.0.1', '0', '', 'default', 'zhaoyiren@xy.com', 'XY001', '18792615002');

-- ----------------------------
-- Table structure for sys_xybutton
-- ----------------------------
DROP TABLE IF EXISTS `sys_xybutton`;
CREATE TABLE `sys_xybutton` (
  `XYBUTTON_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '����',
  `QX_NAME` varchar(50) DEFAULT NULL COMMENT 'Ȩ�ޱ�ʶ',
  `BZ` varchar(255) DEFAULT NULL COMMENT '��ע',
  PRIMARY KEY (`XYBUTTON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_xybutton
-- ----------------------------
INSERT INTO `sys_xybutton` VALUES ('3542adfbda73410c976e185ffe50ad06', '����EXCEL', 'toExcel', '����EXCEL');
INSERT INTO `sys_xybutton` VALUES ('46992ea280ba4b72b29dedb0d4bc0106', '���ʼ�', 'email', '���͵����ʼ�');
INSERT INTO `sys_xybutton` VALUES ('4efa162fce8340f0bd2dcd3b11d327ec', '����EXCEL', 'FromExcel', '����EXCEL��ϵͳ�û�');
INSERT INTO `sys_xybutton` VALUES ('cc51b694d5344d28a9aa13c84b7166cd', '������', 'sms', '���Ͷ���');
INSERT INTO `sys_xybutton` VALUES ('da7fd386de0b49ce809984f5919022b8', 'վ����', 'FHSMS', '����վ����');

-- ----------------------------
-- Table structure for xy_goodinfo
-- ----------------------------
DROP TABLE IF EXISTS `xy_goodinfo`;
CREATE TABLE `xy_goodinfo` (
  `GOODINFO_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `GOODDESCRIBE` varchar(255) DEFAULT NULL COMMENT '��Ʒ����',
  PRIMARY KEY (`GOODINFO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_goodinfo
-- ----------------------------

-- ----------------------------
-- Table structure for xy_goods
-- ----------------------------
DROP TABLE IF EXISTS `xy_goods`;
CREATE TABLE `xy_goods` (
  `GOODS_ID` varchar(100) NOT NULL,
  `GOODSNAME` varchar(100) DEFAULT NULL COMMENT '��Ʒ����',
  `GOODSCODE` varchar(100) DEFAULT NULL COMMENT '��Ʒ���',
  `GOODSPICTURE` varchar(100) DEFAULT NULL COMMENT '��Ʒ����ͼ',
  `GOODSTYPE` varchar(100) DEFAULT NULL,
  `PUBLISHDATE` varchar(100) DEFAULT NULL COMMENT '�ϻ�ʱ��',
  `DOWNPUBLISHDATE` varchar(100) DEFAULT NULL COMMENT '�¼�ʱ��',
  `GOODSSTATE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`GOODS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_goods
-- ----------------------------
INSERT INTO `xy_goods` VALUES ('1b55fea182264c189007fdeedbb53fd0', '�½��͵�ľ', 'XJ0000102', '20180130/7ffd591bf6514c26889a96e5d073581e.jpg', '5aeae7a98796420dad63839b988bf9da', '2018-01-30 17:45:29', null, 'ced0ab752c5c4e3c87b311c6f1cfc7de');

-- ----------------------------
-- Table structure for xy_goodsdiscuss
-- ----------------------------
DROP TABLE IF EXISTS `xy_goodsdiscuss`;
CREATE TABLE `xy_goodsdiscuss` (
  `GOODSDISCUSS_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `DISCUSSCONTENT` varchar(255) DEFAULT NULL COMMENT '��������',
  `DISCUSSTIME` varchar(100) DEFAULT NULL COMMENT '����ʱ��',
  `DISCUSSSTATUS` varchar(100) DEFAULT NULL COMMENT '����״̬',
  `USERID` varchar(100) DEFAULT NULL COMMENT '���û�ID����',
  `DISCUSSSCORE` varchar(10) DEFAULT NULL COMMENT '���۵÷�',
  PRIMARY KEY (`GOODSDISCUSS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_goodsdiscuss
-- ----------------------------

-- ----------------------------
-- Table structure for xy_order
-- ----------------------------
DROP TABLE IF EXISTS `xy_order`;
CREATE TABLE `xy_order` (
  `ORDER_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `ORDERNO` varchar(100) DEFAULT NULL COMMENT '�������',
  `ORDERSTATUS` varchar(100) DEFAULT NULL COMMENT '����״̬',
  `ORDERCREATETIME` varchar(100) DEFAULT NULL COMMENT '��������ʱ��',
  `USERID` varchar(100) DEFAULT NULL COMMENT '���û�ID����',
  `ORDERCANCELTIME` varchar(100) DEFAULT NULL COMMENT '����ȡ��ʱ��',
  `DISCUSSSID` varchar(100) DEFAULT NULL COMMENT '��������ID',
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_order
-- ----------------------------

-- ----------------------------
-- Table structure for xy_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `xy_shopcar`;
CREATE TABLE `xy_shopcar` (
  `SHOPCAR_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `USERID` varchar(100) DEFAULT NULL COMMENT '���û�ID����',
  PRIMARY KEY (`SHOPCAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_shopcar
-- ----------------------------

-- ----------------------------
-- Table structure for xy_stock
-- ----------------------------
DROP TABLE IF EXISTS `xy_stock`;
CREATE TABLE `xy_stock` (
  `STOCK_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `INVENTORYNUM` varchar(100) DEFAULT NULL COMMENT '�����',
  PRIMARY KEY (`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_stock
-- ----------------------------

-- ----------------------------
-- Table structure for xy_stockrecord
-- ----------------------------
DROP TABLE IF EXISTS `xy_stockrecord`;
CREATE TABLE `xy_stockrecord` (
  `STOCKRECORD_ID` varchar(100) NOT NULL,
  `GOODSID` varchar(100) DEFAULT NULL COMMENT '����ƷID����',
  `TYPE` varchar(100) DEFAULT NULL COMMENT '��淽ʽ',
  `TYPENUM` varchar(100) DEFAULT NULL COMMENT '��淽ʽ��Ӧ������',
  `OPREATOR` varchar(100) DEFAULT NULL COMMENT 'ִ����',
  PRIMARY KEY (`STOCKRECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xy_stockrecord
-- ----------------------------
