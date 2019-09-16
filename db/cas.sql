/*
 Navicat Premium Data Transfer

 Source Server         : SQL_Local
 Source Server Type    : SQL Server
 Source Server Version : 14001000
 Source Host           : localhost:1433
 Source Catalog        : CAS
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 14001000
 File Encoding         : 65001

 Date: 16/09/2019 10:52:28
*/

-- ----------------------------
-- Table structure for BaseUser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[BaseUser]') AND type IN ('U'))
	DROP TABLE [dbo].[BaseUser]
GO

CREATE TABLE [dbo].[BaseUser] (
  [UserId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [Account] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [Password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [RealName] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [HeadIcon] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [Gender] int  NULL,
  [Birthday] smalldatetime  NULL,
  [Mobile] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [Telephone] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [Email] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [WeChat] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [Description] varchar(max) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[BaseUser] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Table structure for CasClientLog
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[CasClientLog]') AND type IN ('U'))
	DROP TABLE [dbo].[CasClientLog]
GO

CREATE TABLE [dbo].[CasClientLog] (
  [AppLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [CasLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppName] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [Ticket] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [TicketCreateTime] datetime  NULL,
  [TicketEFTime] int  NULL,
  [TicketValidated] int  NULL,
  [TicketValidateTime] datetime  NULL,
  [LoginTime] datetime  NULL,
  [LogoutTime] datetime  NULL,
  [LogStatus] int  NULL,
  [Description] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [ClientSessionId] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[CasClientLog] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'AppLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'CAS会话ID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'CasLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用ID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'AppId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用名称',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'AppName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用地址',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'AppUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'Ticket'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据创建时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'TicketCreateTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据有效时长，以秒为单位',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'TicketEFTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据验证 -1 未验证 0 失败 1 成功 ',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'TicketValidated'
GO

EXEC sp_addextendedproperty
'MS_Description', N'票据验证时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'TicketValidateTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'LoginTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出时间',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'LogoutTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录状态 0 登出、1登录',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'LogStatus'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备注',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'Description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'客户端SESSIONID',
'SCHEMA', N'dbo',
'TABLE', N'CasClientLog',
'COLUMN', N'ClientSessionId'
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
  [CasLogId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [UserId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [Account] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [RealName] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [IP] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [LoginTime] datetime  NULL,
  [LogoutTime] datetime  NULL,
  [LogStatus] int  NULL,
  [BrowserType] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [CasSessionId] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [Description] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[CasLog] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'CasLogId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户ID',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'UserId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户账号',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'Account'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名称',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'RealName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录IP',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'IP'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录时间',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'LoginTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出时间',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'LogoutTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登录状态 0 登出、1登录',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'LogStatus'
GO

EXEC sp_addextendedproperty
'MS_Description', N'浏览器类型',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'BrowserType'
GO

EXEC sp_addextendedproperty
'MS_Description', N'CAS服务端SESSIONID',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'CasSessionId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备注',
'SCHEMA', N'dbo',
'TABLE', N'CasLog',
'COLUMN', N'Description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'单点CAS会话',
'SCHEMA', N'dbo',
'TABLE', N'CasLog'
GO


-- ----------------------------
-- Table structure for ClientApp
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientApp]') AND type IN ('U'))
	DROP TABLE [dbo].[ClientApp]
GO

CREATE TABLE [dbo].[ClientApp] (
  [AppId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [AppName] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppLoginUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppLogoutUrl] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [Manager] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [ManagerTel] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppIcon] varchar(200) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppServerIP] varchar(20) COLLATE Chinese_PRC_CI_AS  NULL,
  [SortCode] int  NULL,
  [DeleteMark] int  NULL,
  [EnabledMark] int  NULL,
  [Description] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,
  [IsDefaultApp] int  NULL,
  [SingleLogout] int  NULL,
  [ForceLogout] int  NULL
)
GO

ALTER TABLE [dbo].[ClientApp] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用名称',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用地址',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppLoginUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'登出URL',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppLogoutUrl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'负责人',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'Manager'
GO

EXEC sp_addextendedproperty
'MS_Description', N'负责人联系电话',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'ManagerTel'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用图标',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppIcon'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用服务器IP',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'AppServerIP'
GO

EXEC sp_addextendedproperty
'MS_Description', N'排序码',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'SortCode'
GO

EXEC sp_addextendedproperty
'MS_Description', N'删除标记',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'DeleteMark'
GO

EXEC sp_addextendedproperty
'MS_Description', N'有效标志',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'EnabledMark'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备注',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'Description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否是默认展示的客户端 0否 大于1 是 按数字顺序排序',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'IsDefaultApp'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否支持单点登出
0 否（只注销自己的会话）
1 是（注销所有的会话）',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'SingleLogout'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否具有强制登出其他人的权限 0 否  1 是',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp',
'COLUMN', N'ForceLogout'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用表',
'SCHEMA', N'dbo',
'TABLE', N'ClientApp'
GO


-- ----------------------------
-- Table structure for ClientAppAuth
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientAppAuth]') AND type IN ('U'))
	DROP TABLE [dbo].[ClientAppAuth]
GO

CREATE TABLE [dbo].[ClientAppAuth] (
  [AuthId] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [UserId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [AppId] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[ClientAppAuth] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'AuthId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'UserId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用主键',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth',
'COLUMN', N'AppId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'应用授权表',
'SCHEMA', N'dbo',
'TABLE', N'ClientAppAuth'
GO


-- ----------------------------
-- Primary Key structure for table CasClientLog
-- ----------------------------
ALTER TABLE [dbo].[CasClientLog] ADD CONSTRAINT [PK_T_SSOAPPSESSION] PRIMARY KEY NONCLUSTERED ([AppLogId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table CasLog
-- ----------------------------
ALTER TABLE [dbo].[CasLog] ADD CONSTRAINT [PK_T_SSOCASSESSION] PRIMARY KEY NONCLUSTERED ([CasLogId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table ClientApp
-- ----------------------------
ALTER TABLE [dbo].[ClientApp] ADD CONSTRAINT [PK_T_APP] PRIMARY KEY NONCLUSTERED ([AppId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table ClientAppAuth
-- ----------------------------
ALTER TABLE [dbo].[ClientAppAuth] ADD CONSTRAINT [PK_T_APPAUTH] PRIMARY KEY NONCLUSTERED ([AuthId])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

