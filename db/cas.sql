/*
 Navicat Premium Data Transfer

 Source Server         : SQL-Server
 Source Server Type    : SQL Server
 Source Server Version : 14001000
 Source Host           : localhost:1433
 Source Catalog        : CAS
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 14001000
 File Encoding         : 65001

 Date: 28/09/2019 19:58:38
*/


-- ----------------------------
-- Table structure for BaseUser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[BaseUser]') AND type IN ('U'))
	DROP TABLE [dbo].[BaseUser]
GO

CREATE TABLE [dbo].[BaseUser] (
  [userId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [account] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [realName] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [headIcon] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [gender] int  NULL,
  [birthday] smalldatetime  NULL,
  [mobile] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [telephone] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [weChat] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(max) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[BaseUser] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of BaseUser
-- ----------------------------
INSERT INTO [dbo].[BaseUser]  VALUES (N'admin', N'admin', N'Pek3WteEF9yN1enoxBG2nw==', N'admin', NULL, N'1', NULL, NULL, NULL, NULL, NULL, N'管理员')
GO


-- ----------------------------
-- Table structure for CasClientLog
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[CasClientLog]') AND type IN ('U'))
	DROP TABLE [dbo].[CasClientLog]
GO

CREATE TABLE [dbo].[CasClientLog] (
  [appLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [casLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [appId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [appName] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [appUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [ticket] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [ticketCreateTime] datetime  NULL,
  [ticketEffectiveTime] int  NULL,
  [ticketValidated] int  NULL,
  [ticketValidateTime] datetime  NULL,
  [loginTime] datetime  NULL,
  [logoutTime] datetime  NULL,
  [logStatus] int  NULL,
  [clientSessionId] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[CasClientLog] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'appLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'CAS会话ID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'casLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用ID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'appId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用名称',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'appName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用地址',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'appUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ticket'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据创建时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ticketCreateTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据有效时长，以秒为单位',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ticketEffectiveTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据验证 -1 未验证 0 失败 1 成功 ',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ticketValidated'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据验证时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ticketValidateTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'loginTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'logoutTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录状态 0 登出、1登录',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'logStatus'
GO

EXEC sp_addextendedproperty
'MS_Description', N'客户端SESSIONID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'clientSessionId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'描述',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'单点登录应用会话',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog'
GO


-- ----------------------------
-- Table structure for CasLog
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[CasLog]') AND type IN ('U'))
	DROP TABLE [dbo].[CasLog]
GO

CREATE TABLE [dbo].[CasLog] (
  [casLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [userId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [account] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [realName] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [ip] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [loginTime] datetime  NULL,
  [logoutTime] datetime  NULL,
  [logStatus] int  NULL,
  [browserType] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [casSessionId] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [description] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[CasLog] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'casLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户ID',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'userId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户账号',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'account'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名称',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'realName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录IP',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'ip'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录时间',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'loginTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出时间',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'logoutTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录状态 0 登出、1登录',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'logStatus'
GO

EXEC sp_addextendedproperty
'MS_Description', N'浏览器类型',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'browserType'
GO

EXEC sp_addextendedproperty
'MS_Description', N'CAS服务端SESSIONID',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'casSessionId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备注',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'单点CAS会话',
'SCHEMA', N'dbo',
'TABLE', N'CasLog'
GO


-- ----------------------------
-- Records of CasLog
-- ----------------------------
INSERT INTO [dbo].[CasLog]  VALUES (N'de83698e-ce6c-4da5-83a4-b36fb2320f12', N'admin', N'admin', N'admin', N'', N'2019-09-28 14:12:40.183', NULL, N'0', N'', N'276244DF9B94CC2CC9955AB1DE8CE7E0', N'')
GO

INSERT INTO [dbo].[CasLog]  VALUES (N'c5ac7ff9-1e63-44bf-923d-3adc11243a74', N'admin', N'admin', N'admin', N'', N'2019-09-28 14:15:53.553', NULL, N'0', N'', N'E6D9CD5D28707618CD51ABC6ACC3B922', N'')
GO

INSERT INTO [dbo].[CasLog]  VALUES (N'3624afcb-6902-4ff8-b1b2-1b5b5dbfa1b5', N'admin', N'admin', N'admin', N'', N'2019-09-28 18:52:47.267', NULL, N'0', N'', N'42C97D76441CCCE63AB340CE3F35F9CF', N'')
GO


-- ----------------------------
-- Table structure for ClientApp
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientApp]') AND type IN ('U'))
	DROP TABLE [dbo].[ClientApp]
GO

CREATE TABLE [dbo].[ClientApp] (
  [appId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [appName] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [appLoginUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [appLogoutUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [appIcon] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [appServerIP] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [manager] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [managerTel] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [isDefaultApp] int  NULL,
  [singleLogout] int  NULL,
  [forceLogout] int  NULL,
  [sortCode] int  NULL,
  [description] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [enabledMark] int  NULL,
  [deleteMark] int  NULL
)
GO

ALTER TABLE [dbo].[ClientApp] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用名称',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用地址',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appLoginUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出URL',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appLogoutUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用图标',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appIcon'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用服务器IP',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'appServerIP'
GO

EXEC sp_addextendedproperty
'MS_Description', N'负责人',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'manager'
GO

EXEC sp_addextendedproperty
'MS_Description', N'负责人联系电话',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'managerTel'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否是默认展示的客户端 0否 大于1 是 按数字顺序排序',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'isDefaultApp'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否支持单点登出
0 否（只注销自己的会话）
1 是（注销所有的会话）',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'singleLogout'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否具有强制登出其他人的权限 0 否  1 是',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'forceLogout'
GO

EXEC sp_addextendedproperty
'MS_Description', N'排序编号',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'sortCode'
GO

EXEC sp_addextendedproperty
'MS_Description', N'描述',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'可编辑标识',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'enabledMark'
GO

EXEC sp_addextendedproperty
'MS_Description', N'删除标识',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'deleteMark'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用表',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp'
GO


-- ----------------------------
-- Records of ClientApp
-- ----------------------------
INSERT INTO [dbo].[ClientApp]  VALUES (N'7680f321-7e87-4385-998d-9f36a77ba961', N'gis', N'http://localhost:9901', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[ClientApp]  VALUES (N'983318a7-1c7f-4e31-ad47-abba9aa1ba87', N'mng', N'http://localhost:9902', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO

INSERT INTO [dbo].[ClientApp]  VALUES (N'8d4b0142-d871-4e7d-b821-bc5a928bfdd5', N'biz', N'http://localhost:9903', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
GO


-- ----------------------------
-- Table structure for ClientAppAuth
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientAppAuth]') AND type IN ('U'))
	DROP TABLE [dbo].[ClientAppAuth]
GO

CREATE TABLE [dbo].[ClientAppAuth] (
  [authId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [userId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [clientAppId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[ClientAppAuth] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'authId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'userId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'clientAppId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用授权表',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth'
GO


-- ----------------------------
-- Primary Key structure for table CasClientLog
-- ----------------------------
ALTER TABLE [dbo].[CasClientLog] ADD CONSTRAINT [PK_T_SSOAPPSESSION] PRIMARY KEY NONCLUSTERED ([appLogId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table CasLog
-- ----------------------------
ALTER TABLE [dbo].[CasLog] ADD CONSTRAINT [PK_T_SSOCASSESSION] PRIMARY KEY NONCLUSTERED ([casLogId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table ClientApp
-- ----------------------------
ALTER TABLE [dbo].[ClientApp] ADD CONSTRAINT [PK_T_APP] PRIMARY KEY NONCLUSTERED ([appId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table ClientAppAuth
-- ----------------------------
ALTER TABLE [dbo].[ClientAppAuth] ADD CONSTRAINT [PK_T_APPAUTH] PRIMARY KEY NONCLUSTERED ([authId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

