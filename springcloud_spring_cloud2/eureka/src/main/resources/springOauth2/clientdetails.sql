drop table if exists clientdetails;
create table clientdetails(
  appId varchar(128) not null,
  resourceIds varchar(256) default null,
  appSecret varchar(256) default null,
  scope varchar(256) default null,
  grantTypes varchar(256) default null,
  redirectUrl varchar(256) default null,
  authorities varchar(256) default null,
  access_token_validity int(11) default null,
  refresh_token_validity int(11) default null,
  additionalInformation varchar(4096) default null,
  autoApproveScopes varchar(256) default null,
  PRIMARY key ('appId')
)